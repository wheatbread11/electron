package net.wheatbread11.electron.common.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.content.tags.ModItemTags;
import net.wheatbread11.electron.content.world.item.ModItems;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Electron.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider lookupProvider) {

        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "dusts/iron")))
                .add(ModItems.IRON_DUST.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "dusts/gold")))
                .add(ModItems.GOLD_DUST.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "dusts/copper")))
                .add(ModItems.COPPER_DUST.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "dusts/silver")))
                .add(ModItems.SILVER_DUST.get())
                .replace(false);

        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "ingots/silver")))
                .add(ModItems.SILVER_INGOT.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "nuggets/silver")))
                .add(ModItems.SILVER_NUGGET.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "raw_materials/silver")))
                .add(ModItems.RAW_SILVER.get())
                .replace(false);

        this.tag(ModItemTags.SILVER_TOOL_MATERIALS)
                .addTag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "ingots/silver")))
                .replace(false);
        this.tag(ModItemTags.REPAIRS_SILVER_ARMOR)
                .addTag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "ingots/silver")))
                .replace(false);
        this.tag(ModItemTags.WEAPON_IMMUNE_TO_UNDEAD)
                .add(ModItems.SILVER_SWORD.get())
                .add(ModItems.SILVER_SHOVEL.get())
                .add(ModItems.SILVER_PICKAXE.get())
                .add(ModItems.SILVER_AXE.get())
                .add(ModItems.SILVER_HOE.get())
                .add(ModItems.SILVER_SPEAR.get())
                .replace(false);
        this.tag(ModItemTags.EQUIPMENT_AVOID_UNDEAD)
                .addTag(ModItemTags.WEAPON_IMMUNE_TO_UNDEAD)
                .add(ModItems.SILVER_CHESTPLATE.get())
                .add(ModItems.SILVER_LEGGINGS.get())
                .add(ModItems.SILVER_BOOTS.get())
                .add(ModItems.SILVER_HORSE_ARMOR.get())
                .add(ModItems.SILVER_NAUTILUS_ARMOR.get())
                .replace(false);

        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("minecraft", "swords")))
                .add(ModItems.SILVER_SWORD.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("minecraft", "spears")))
                .add(ModItems.SILVER_SPEAR.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("minecraft", "foot_armor")))
                .add(ModItems.SILVER_BOOTS.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("minecraft", "leg_armor")))
                .add(ModItems.SILVER_LEGGINGS.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("minecraft", "chest_armor")))
                .add(ModItems.SILVER_CHESTPLATE.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("minecraft", "head_armor")))
                .add(ModItems.SILVER_HELMET.get())
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("minecraft", "metal_nuggets")))
                .add(ModItems.SILVER_NUGGET.get())
                .replace(false);
    }
}
