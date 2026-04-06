package net.wheatbread11.electron.content.world.item;

import net.minecraft.world.item.ToolMaterial;
import net.wheatbread11.electron.content.tags.ModBlockTags;
import net.wheatbread11.electron.content.tags.ModItemTags;

public class ModToolMaterial {

    public static final ToolMaterial SILVER = new ToolMaterial(
            ModBlockTags.INCORRECT_FOR_SILVER_TOOL,
            32, 12.0F, 0.0F, 22,
            ModItemTags.SILVER_TOOL_MATERIALS
    );
}
