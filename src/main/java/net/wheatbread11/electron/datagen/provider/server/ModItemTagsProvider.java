package net.wheatbread11.electron.datagen.provider.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.registry.ModItems;
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

        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("electron", "silver_tool_materials")))
                .addTag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "ingots/silver")))
                .replace(false);
        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("electron", "repairs_silver_armor")))
                .addTag(ItemTags.create(Identifier.fromNamespaceAndPath("c", "ingots/silver")))
                .replace(false);

        this.tag(ItemTags.create(Identifier.fromNamespaceAndPath("minecraft", "swords")))
                .add(ModItems.SILVER_SWORD.get())
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
    }
}
