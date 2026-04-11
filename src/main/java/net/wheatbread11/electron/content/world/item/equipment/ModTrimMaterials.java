package net.wheatbread11.electron.content.world.item.equipment;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.wheatbread11.electron.Electron;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> SILVER = registryKey("silver");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, SILVER, Style.EMPTY.withColor(0xd6c3fc), ModMaterialAssetGroups.SILVER);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> registryKey, Style hoverTextStyle, MaterialAssetGroup assets) {
        Component description = Component.translatable(Util.makeDescriptionId("trim_material", registryKey.identifier())).withStyle(hoverTextStyle);
        context.register(registryKey, new TrimMaterial(assets, description));
    }

    private static ResourceKey<TrimMaterial> registryKey(String id) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(Electron.MOD_ID, id));
    }
}
