package net.wheatbread11.electron.tags;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.wheatbread11.electron.Electron;

public class ModItemTags {

    public static final TagKey<Item> SILVER_TOOL_MATERIALS = createTag("silver_tool_materials");
    public static final TagKey<Item> REPAIRS_SILVER_ARMOR = createTag("repairs_silver_armor");

    private static TagKey<Item> createTag(String name) {
        return ItemTags.create(Identifier.fromNamespaceAndPath(Electron.MOD_ID, name));
    }
}
