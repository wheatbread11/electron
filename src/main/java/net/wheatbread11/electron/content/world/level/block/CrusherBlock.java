package net.wheatbread11.electron.content.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.wheatbread11.electron.content.core.crusher.CrusherDrops;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class CrusherBlock extends Block {

    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    public static final BooleanProperty TRIGGERED = BlockStateProperties.TRIGGERED;

    public static final Map<Block, CrusherDrops> DROPS_REGISTRY = new IdentityHashMap<>();

    public CrusherBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.getStateDefinition().any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(TRIGGERED, false)
        );
    }

    public static void registerDrops(@NonNull Block block, @NonNull CrusherDrops drops) {
        DROPS_REGISTRY.put(block, drops);
    }

    protected static boolean isCrushable(
            @NonNull ServerLevel level, @NonNull BlockState state, @NonNull BlockPos pos,
            @NonNull ItemStack tool
    ) {
        if (state.isAir()) return false;
        if (state.getDestroySpeed(level, pos) == -1) return false;
        if (state.requiresCorrectToolForDrops()) {
            return tool.isCorrectToolForDrops(state);
        } else {
            return true;
        }
    }

    protected static List<ItemStack> getCrushedDrops(
            @NonNull ServerLevel level, @NonNull BlockState state, @NonNull BlockPos pos,
            @NonNull ItemStack tool, @NonNull RandomSource random
    ) {
        Block block = state.getBlock();

        if (DROPS_REGISTRY.containsKey(block)) {
            return DROPS_REGISTRY.get(block).obtain(random);
        } else {
            BlockEntity blockEntity = level.getBlockEntity(pos);

            LootParams.Builder builder = new LootParams.Builder(level)
                    .withParameter(LootContextParams.BLOCK_STATE, state)
                    .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                    .withParameter(LootContextParams.TOOL, tool);

            if (blockEntity != null) {
                builder.withOptionalParameter(LootContextParams.BLOCK_ENTITY, blockEntity);
            }

            return state.getDrops(builder);
        }
    }

    protected static void crushFrom(
            @NonNull ServerLevel level, @NonNull BlockState state, @NonNull BlockPos pos,
            @NonNull RandomSource random
    ) {

        BlockPos frontPos = pos.relative(state.getValue(FACING));
        BlockState frontState = level.getBlockState(frontPos);
        ItemStack tool = new ItemStack(Items.IRON_PICKAXE);

        if (!(isCrushable(level, frontState, frontPos, tool))) return;

        List<ItemStack> drops = getCrushedDrops(level, frontState, frontPos, tool, random);

        level.destroyBlock(frontPos,false, null);

        Vec3 center = frontPos.getCenter();
        for (ItemStack drop : drops) {
            level.addFreshEntity(new ItemEntity(
                    level,
                    center.x, center.y, center.z,
                    drop,
                    0.0F, 0.0F, 0.0F
            ));
        }
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
        crushFrom(level, state, pos, random);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TRIGGERED);
    }
}
