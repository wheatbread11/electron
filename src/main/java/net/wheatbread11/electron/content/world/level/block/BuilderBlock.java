package net.wheatbread11.electron.content.world.level.block;

import com.mojang.authlib.GameProfile;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.wheatbread11.electron.content.world.level.block.entity.BuilderBlockEntity;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public class BuilderBlock extends BaseEntityBlock {

    public static final MapCodec<BuilderBlock> CODEC = simpleCodec(BuilderBlock::new);

    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    public static final BooleanProperty TRIGGERED = BlockStateProperties.TRIGGERED;

    public BuilderBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.getStateDefinition().any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(TRIGGERED, false)
        );
    }

    protected void buildFrom(ServerLevel level, BlockState state, BlockPos pos, RandomSource random) {
        BuilderBlockEntity blockEntity = (BuilderBlockEntity) level.getBlockEntity(pos);

        if (blockEntity != null) {
            int slot = blockEntity.getBlockAvailableSlot();
            if (slot >= 0) {
                ItemStack itemStack = blockEntity.getItem(slot);

                if (itemStack.getItem() instanceof BlockItem blockItem) {
                    Direction facing = state.getValue(FACING);
                    BlockPos frontPos = pos.relative(facing);
                    FakePlayer fakePlayer = new FakePlayer(
                            level,
                            new GameProfile(UUID.nameUUIDFromBytes("builder".getBytes()), "builder")
                    );
                    fakePlayer.lookAt(EntityAnchorArgument.Anchor.EYES, facing.getUnitVec3());

                    if (level.getBlockState(frontPos).isAir()) {
                        BlockPlaceContext blockPlaceContext = new BlockPlaceContext(
                                level,
                                fakePlayer,
                                InteractionHand.MAIN_HAND,
                                itemStack,
                                new BlockHitResult(frontPos.getCenter(), facing, frontPos, false)
                        );

                        blockItem.place(blockPlaceContext);
                    }
                }
            }
        }
    }

    @Override
    @NonNull
    protected InteractionResult useWithoutItem(
            @NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos,
            @NonNull Player player, @NonNull BlockHitResult hitResult
    ) {
        if (!level.isClientSide() && level.getBlockEntity(pos) instanceof BuilderBlockEntity builder) {
            player.openMenu(builder);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    @NonNull
    protected MapCodec<? extends BuilderBlock> codec() {
        return CODEC;
    }

    @Override
    protected void neighborChanged(
            BlockState state, Level level, @NonNull BlockPos pos,
            @NonNull Block block, @Nullable Orientation orientation, boolean moveByPiston
    ) {
        boolean shouldTrigger = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above());
        boolean isTriggered = state.getValue(TRIGGERED);
        if (shouldTrigger && !isTriggered) {
            level.scheduleTick(pos, this, 4);
            level.setBlock(pos, state.setValue(TRIGGERED, true), 2);
        } else if (!shouldTrigger && isTriggered) {
            level.setBlock(pos, state.setValue(TRIGGERED, false), 2);
        }
    }

    @Override
    protected void tick(
            @NonNull BlockState state, @NonNull ServerLevel level, @NonNull BlockPos pos,
            @NonNull RandomSource random
    ) {
        this.buildFrom(level, state, pos, random);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(
            @NonNull BlockPos pos,
            @NonNull BlockState state
    ) {
        return new BuilderBlockEntity(pos, state);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection());
    }

    @Override
    protected void affectNeighborsAfterRemoval(
            @NonNull BlockState state, @NonNull ServerLevel level, @NonNull BlockPos pos, boolean movedByPiston
    ) {
        Containers.updateNeighboursAfterDestroy(state, level, pos);
    }

    @Override
    protected boolean hasAnalogOutputSignal(@NonNull BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(
            @NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Direction direction
    ) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TRIGGERED);
    }
}
