package net.wheatbread11.electron.datagen.provider.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.registry.ModBlocks;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Electron.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider lookupProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CRUSHER.get())
                .add(ModBlocks.BUILDER.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.SILVER_BLOCK.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .replace(false);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.SILVER_BLOCK.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .replace(false);

        this.tag(BlockTags.create(Identifier.fromNamespaceAndPath("c", "ores/silver")))
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .replace(false);
        this.tag(BlockTags.create(Identifier.fromNamespaceAndPath("c", "storage_blocks/silver")))
                .add(ModBlocks.SILVER_BLOCK.get())
                .replace(false);
        this.tag(BlockTags.create(Identifier.fromNamespaceAndPath("c", "storage_blocks/raw_silver")))
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .replace(false);

        this.tag(BlockTags.create(Identifier.fromNamespaceAndPath("electron", "incorrect_for_silver_tool")))
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL)
                .replace(false);
    }
}
