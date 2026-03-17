package net.wheatbread11.electron.datagen.provider.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.wheatbread11.electron.registry.ModBlocks;
import org.jspecify.annotations.NonNull;

import java.util.Set;

public class ModBlockLootTableSubProvider extends BlockLootSubProvider {

    public ModBlockLootTableSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }

    @Override
    @NonNull
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries()
                .stream()
                .map(e -> (Block) e.value())
                .toList();
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CRUSHER.get());
        this.dropSelf(ModBlocks.BUILDER.get());
    }
}
