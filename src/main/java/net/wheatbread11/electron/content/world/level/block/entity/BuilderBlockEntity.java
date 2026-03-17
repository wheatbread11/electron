package net.wheatbread11.electron.content.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DispenserMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.wheatbread11.electron.registry.ModBlockEntityType;
import org.jspecify.annotations.NonNull;

public class BuilderBlockEntity extends RandomizableContainerBlockEntity {

    public static final int CONTAINER_SIZE = 9;
    private static final Component DEFAULT_NAME = Component.translatable("block.electron.builder");
    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);

    protected BuilderBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public BuilderBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntityType.BUILDER.get(), pos, state);
    }

    public int getBlockAvailableSlot() {
        this.unpackLootTable(null);
        int replaceSlot = -1;

        for (int i = 0; i < this.items.size(); i++) {

            ItemStack itemStack = this.items.get(i);

            if (itemStack.getItem() instanceof BlockItem) {
                replaceSlot = i;
                break;
            }
        }

        return replaceSlot;
    }

    @Override
    public int getContainerSize() {
        return CONTAINER_SIZE;
    }

    @Override
    @NonNull
    public Component getDefaultName() {
        return Component.translatable("block.electron.builder");
    }

    @Override
    protected void loadAdditional(@NonNull ValueInput input) {
        super.loadAdditional(input);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(input)) {
            ContainerHelper.loadAllItems(input, this.items);
        }
    }

    @Override
    protected void saveAdditional(@NonNull ValueOutput output) {
        super.saveAdditional(output);
        if (!this.trySaveLootTable(output)) {
            ContainerHelper.saveAllItems(output, this.items);
        }
    }

    @Override
    @NonNull
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(@NonNull NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    @NonNull
    protected AbstractContainerMenu createMenu(int id, @NonNull Inventory inventory) {
        return new DispenserMenu(id, inventory, this);
    }
}
