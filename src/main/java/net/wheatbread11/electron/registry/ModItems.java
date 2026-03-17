package net.wheatbread11.electron.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wheatbread11.electron.Electron;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Electron.MOD_ID);

    public static final DeferredItem<Item> IRON_DUST = ITEMS.registerSimpleItem("iron_dust");
    public static final DeferredItem<Item> GOLD_DUST = ITEMS.registerSimpleItem("gold_dust");
    public static final DeferredItem<Item> COPPER_DUST = ITEMS.registerSimpleItem("copper_dust");

    public static final DeferredItem<BlockItem> CRUSHER =
            ITEMS.registerSimpleBlockItem("crusher", ModBlocks.CRUSHER);
    public static final DeferredItem<BlockItem> BUILDER =
            ITEMS.registerSimpleBlockItem("builder", ModBlocks.BUILDER);
}
