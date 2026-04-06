package net.wheatbread11.electron.event;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.datagen.provider.client.ModEquipmentAssetProvider;
import net.wheatbread11.electron.datagen.provider.client.ModModelProvider;
import net.wheatbread11.electron.datagen.provider.server.*;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = Electron.MOD_ID)
public class GatherDataEventHandler {

    @SubscribeEvent
    public static void gatherDataClient(GatherDataEvent.Client event) {
        event.createProvider(ModModelProvider::new);
        event.createProvider(ModEquipmentAssetProvider::new);
    }

    @SubscribeEvent
    public static void gatherDataServer(GatherDataEvent.Server event) {
        event.createProvider(ModRecipeProvider.Runner::new);
        event.createProvider((output, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(
                        new LootTableProvider.SubProviderEntry(
                                ModBlockLootTableSubProvider::new,
                                LootContextParamSets.BLOCK
                        )
                ),
                lookupProvider
        ));
        event.createProvider(ModBlockTagsProvider::new);
        event.createProvider(ModItemTagsProvider::new);
        event.createProvider(ModDatapackProvider::new);
    }
}
