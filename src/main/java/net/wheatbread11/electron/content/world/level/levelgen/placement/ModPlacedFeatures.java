package net.wheatbread11.electron.content.world.level.levelgen.placement;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.content.world.level.levelgen.feature.ModConfiguredFeatures;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ORE_SILVER_EXTRA = registerKey("ore_silver_extra");
    public static final ResourceKey<PlacedFeature> ORE_SILVER = registerKey("ore_silver");
    public static final ResourceKey<PlacedFeature> ORE_SILVER_LOWER = registerKey("ore_silver_lower");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        var oreGold = configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_SILVER);
        var oreGoldBuried = configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_SILVER_BURIED);

        register(context, ORE_SILVER_EXTRA, oreGold, commonOrePlacement(50, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(256))));
        register(context, ORE_SILVER, oreGoldBuried, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
        register(context, ORE_SILVER_LOWER, oreGoldBuried, orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Electron.MOD_ID, name));
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier frequencyModifier, PlacementModifier heightRange) {
        return List.of(frequencyModifier, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static void register(
            BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
            List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
