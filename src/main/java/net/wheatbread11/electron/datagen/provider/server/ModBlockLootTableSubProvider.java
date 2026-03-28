package net.wheatbread11.electron.datagen.provider.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.wheatbread11.electron.registry.ModBlocks;
import net.wheatbread11.electron.registry.ModItems;
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

        this.add(
                ModBlocks.SILVER_ORE.get(),
                this.createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get())
        );
        this.add(
                ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                this.createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get())
        );
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());
    }
}
