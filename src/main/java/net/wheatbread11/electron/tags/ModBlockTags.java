package net.wheatbread11.electron.tags;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.wheatbread11.electron.Electron;

public class ModBlockTags {

    public static final TagKey<Block> INCORRECT_FOR_SILVER_TOOL = createTag("incorrect_for_silver_tool");

    private static TagKey<Block> createTag(String name) {
        return BlockTags.create(Identifier.fromNamespaceAndPath(Electron.MOD_ID, name));
    }
}
