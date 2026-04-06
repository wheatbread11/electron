package net.wheatbread11.electron.event;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.registry.ModBlocks;
import net.wheatbread11.electron.registry.ModItems;

@EventBusSubscriber(modid = Electron.MOD_ID)
public class BuildCreativeModTabContentsEventHandler {

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.SILVER_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.SILVER_ORE);
            event.accept(ModBlocks.DEEPSLATE_SILVER_ORE);
            event.accept(ModBlocks.RAW_SILVER_BLOCK);
        }
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModBlocks.CRUSHER);
            event.accept(ModBlocks.BUILDER);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.SILVER_SWORD);
            event.accept(ModItems.SILVER_SPEAR);
            event.accept(ModItems.SILVER_AXE);
            event.accept(ModItems.SILVER_HELMET);
            event.accept(ModItems.SILVER_CHESTPLATE);
            event.accept(ModItems.SILVER_LEGGINGS);
            event.accept(ModItems.SILVER_BOOTS);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.SILVER_SHOVEL);
            event.accept(ModItems.SILVER_PICKAXE);
            event.accept(ModItems.SILVER_AXE);
            event.accept(ModItems.SILVER_HOE);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_SILVER);
            event.accept(ModItems.SILVER_NUGGET);
            event.accept(ModItems.SILVER_INGOT);
            event.accept(ModItems.IRON_DUST);
            event.accept(ModItems.GOLD_DUST);
            event.accept(ModItems.COPPER_DUST);
            event.accept(ModItems.SILVER_DUST);
        }
    }
}
