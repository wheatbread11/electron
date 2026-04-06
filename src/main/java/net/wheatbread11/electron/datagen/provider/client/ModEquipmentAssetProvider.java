package net.wheatbread11.electron.datagen.provider.client;

import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.wheatbread11.electron.content.world.item.ModEquipmentAssets;

import java.util.Optional;
import java.util.function.BiConsumer;

public class ModEquipmentAssetProvider extends EquipmentAssetProvider {

    public ModEquipmentAssetProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(
                ModEquipmentAssets.SILVER,
                EquipmentClientInfo.builder()
                        .addHumanoidLayers(
                                Identifier.fromNamespaceAndPath("electron", "silver")
                        )
                        .build()
        );
    }
}
