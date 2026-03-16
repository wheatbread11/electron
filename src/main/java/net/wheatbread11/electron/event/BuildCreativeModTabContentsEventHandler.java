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
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModBlocks.CRUSHER);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.IRON_DUST);
            event.accept(ModItems.GOLD_DUST);
            event.accept(ModItems.COPPER_DUST);
        }
    }
}
