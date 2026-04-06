package net.wheatbread11.electron.content.data.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.content.world.item.ModItems;
import net.wheatbread11.electron.content.tags.ModItemTags;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        @NonNull
        protected RecipeProvider createRecipeProvider(
                HolderLookup.@NonNull Provider provider,
                @NonNull RecipeOutput output
        ) {
            return new ModRecipeProvider(provider, output);
        }

        @Override
        @NonNull
        public String getName() {
            return Electron.MOD_ID;
        }
    }

    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

        ShapedRecipeBuilder.shaped(
                this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.REDSTONE,
                        ModItems.CRUSHER
                )
                .pattern("###")
                .pattern("#X#")
                .pattern("#R#")
                .define('#', Items.COBBLESTONE)
                .define('X', Items.IRON_PICKAXE)
                .define('R', Items.REDSTONE)
                .unlockedBy("has_iron_pickaxe", this.has(Items.IRON_PICKAXE))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.REDSTONE,
                        ModItems.BUILDER
                )
                .pattern("###")
                .pattern("# #")
                .pattern("#R#")
                .define('#', Items.BRICKS)
                .define('R', Items.REDSTONE)
                .unlockedBy("has_bricks", this.has(Items.BRICKS))
                .save(this.output);

        buildCompactingCraftRecipe(
                ModItems.SILVER_NUGGET,
                ModItems.SILVER_INGOT
        );
        buildCompactingCraftRecipe(
                ModItems.SILVER_INGOT,
                ModItems.SILVER_BLOCK
        );
        buildCompactingCraftRecipe(
                ModItems.RAW_SILVER,
                ModItems.RAW_SILVER_BLOCK
        );

        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.SILVER_SWORD
                )
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .define('#', Items.STICK)
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.TOOLS,
                        ModItems.SILVER_SHOVEL
                )
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .define('#', Items.STICK)
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.TOOLS,
                        ModItems.SILVER_PICKAXE
                )
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .define('#', Items.STICK)
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.TOOLS,
                        ModItems.SILVER_AXE
                )
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .define('#', Items.STICK)
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.TOOLS,
                        ModItems.SILVER_HOE
                )
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .define('#', Items.STICK)
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.TOOLS,
                        ModItems.SILVER_SPEAR
                )
                .pattern("  X")
                .pattern(" # ")
                .pattern("#  ")
                .define('#', Items.STICK)
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.SILVER_HELMET
                )
                .pattern("XXX")
                .pattern("X X")
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.SILVER_CHESTPLATE
                )
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.SILVER_LEGGINGS
                )
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);
        ShapedRecipeBuilder.shaped(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.SILVER_BOOTS
                )
                .pattern("X X")
                .pattern("X X")
                .define('X', ModItemTags.SILVER_TOOL_MATERIALS)
                .unlockedBy("has_silver_ingot", this.has(ModItemTags.SILVER_TOOL_MATERIALS))
                .save(this.output);

        buildSmeltingAndBlastingRecipe(
                ModItems.SILVER_ORE,
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                ModItems.SILVER_INGOT,
                0.7F,
                200
        );
        buildSmeltingAndBlastingRecipe(
                ModItems.DEEPSLATE_SILVER_ORE,
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                ModItems.SILVER_INGOT,
                0.7F,
                200
        );
        buildSmeltingAndBlastingRecipe(
                ModItems.RAW_SILVER,
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                ModItems.SILVER_INGOT,
                0.7F,
                200
        );
        buildSmeltingAndBlastingRecipe(
                ModItems.IRON_DUST,
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                Items.IRON_INGOT,
                0.2F,
                200
        );
        buildSmeltingAndBlastingRecipe(
                ModItems.GOLD_DUST,
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                Items.GOLD_INGOT,
                0.2F,
                200
        );
        buildSmeltingAndBlastingRecipe(
                ModItems.COPPER_DUST,
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                Items.COPPER_INGOT,
                0.2F,
                200
        );
        buildSmeltingAndBlastingRecipe(
                ModItems.SILVER_DUST,
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                ModItems.SILVER_INGOT,
                0.2F,
                200
        );
        List<ItemLike> silverEquipments = List.of(
                ModItems.SILVER_SWORD,
                ModItems.SILVER_SHOVEL,
                ModItems.SILVER_PICKAXE,
                ModItems.SILVER_AXE,
                ModItems.SILVER_HOE,
                ModItems.SILVER_SPEAR,
                ModItems.SILVER_HELMET,
                ModItems.SILVER_CHESTPLATE,
                ModItems.SILVER_LEGGINGS,
                ModItems.SILVER_BOOTS,
                ModItems.SILVER_HORSE_ARMOR,
                ModItems.SILVER_NAUTILUS_ARMOR
        );
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(silverEquipments.stream()),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.SILVER_NUGGET,
                        0.1F,
                        200
                )
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_SWORD.asItem()), this.has(ModItems.SILVER_SWORD))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_SHOVEL.asItem()), this.has(ModItems.SILVER_SHOVEL))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_PICKAXE.asItem()), this.has(ModItems.SILVER_PICKAXE))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_AXE.asItem()), this.has(ModItems.SILVER_AXE))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_HOE.asItem()), this.has(ModItems.SILVER_HOE))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_SPEAR.asItem()), this.has(ModItems.SILVER_SPEAR))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_HELMET.asItem()), this.has(ModItems.SILVER_HELMET))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_CHESTPLATE.asItem()), this.has(ModItems.SILVER_CHESTPLATE))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_LEGGINGS.asItem()), this.has(ModItems.SILVER_LEGGINGS))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_BOOTS.asItem()), this.has(ModItems.SILVER_BOOTS))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_HORSE_ARMOR.asItem()), this.has(ModItems.SILVER_HORSE_ARMOR))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_NAUTILUS_ARMOR.asItem()), this.has(ModItems.SILVER_NAUTILUS_ARMOR))
                .save(
                        this.output,
                        ResourceKey.create(
                                Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(
                                        Electron.MOD_ID,
                                        BuiltInRegistries.ITEM.getKey(ModItems.SILVER_NUGGET.asItem()).getPath()
                                                + "_from_smelting"
                                )
                        )
                );
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(silverEquipments.stream()),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.SILVER_NUGGET,
                        0.1F,
                        100
                )
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_SWORD.asItem()), this.has(ModItems.SILVER_SWORD))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_SHOVEL.asItem()), this.has(ModItems.SILVER_SHOVEL))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_PICKAXE.asItem()), this.has(ModItems.SILVER_PICKAXE))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_AXE.asItem()), this.has(ModItems.SILVER_AXE))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_HOE.asItem()), this.has(ModItems.SILVER_HOE))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_SPEAR.asItem()), this.has(ModItems.SILVER_SPEAR))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_HELMET.asItem()), this.has(ModItems.SILVER_HELMET))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_CHESTPLATE.asItem()), this.has(ModItems.SILVER_CHESTPLATE))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_LEGGINGS.asItem()), this.has(ModItems.SILVER_LEGGINGS))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_BOOTS.asItem()), this.has(ModItems.SILVER_BOOTS))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_HORSE_ARMOR.asItem()), this.has(ModItems.SILVER_HORSE_ARMOR))
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ModItems.SILVER_NAUTILUS_ARMOR.asItem()), this.has(ModItems.SILVER_NAUTILUS_ARMOR))
                .save(
                        this.output,
                        ResourceKey.create(
                                Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(
                                        Electron.MOD_ID,
                                        BuiltInRegistries.ITEM.getKey(ModItems.SILVER_NUGGET.asItem()).getPath()
                                                + "_from_blasting"
                                )
                        )
                );
    }

    protected void buildCompactingCraftRecipe(
            ItemLike input,
            ItemLike output
    ) {
        ShapelessRecipeBuilder.shapeless(
                    this.registries.lookupOrThrow(Registries.ITEM),
                    RecipeCategory.MISC,
                    output
            )
            .requires(input, 9)
            .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(input.asItem()), this.has(input))
            .save(
                    this.output,
                    ResourceKey.create(
                            Registries.RECIPE,
                            Identifier.fromNamespaceAndPath(
                                    Electron.MOD_ID,
                                    BuiltInRegistries.ITEM.getKey(output.asItem()).getPath()
                                        + "_from_"
                                        + BuiltInRegistries.ITEM.getKey(input.asItem()).getPath()
                            )
                    )
            );

        ShapelessRecipeBuilder.shapeless(
                        this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.MISC,
                        input, 9
                )
                .requires(output)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(output.asItem()), this.has(output))
                .save(
                        this.output,
                        ResourceKey.create(
                                Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(
                                        Electron.MOD_ID,
                                        BuiltInRegistries.ITEM.getKey(input.asItem()).getPath()
                                                + "_from_"
                                                + BuiltInRegistries.ITEM.getKey(output.asItem()).getPath()
                                )
                        )
                );
    }

    protected void buildSmeltingAndBlastingRecipe(
            ItemLike input,
            RecipeCategory recipeCategory,
            CookingBookCategory cookingBookCategory,
            ItemLike output,
            float exp,
            int baseCookTime
    ) {
        buildSmeltingRecipe(input, recipeCategory, cookingBookCategory, output, exp, baseCookTime);
        buildBlastingRecipe(input, recipeCategory, cookingBookCategory, output, exp, baseCookTime / 2);
    }

    protected void buildSmeltingRecipe(
            ItemLike input,
            RecipeCategory recipeCategory,
            CookingBookCategory cookingBookCategory,
            ItemLike output,
            float exp,
            int cookTime
    ) {
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(input),
                        recipeCategory,
                        cookingBookCategory,
                        output,
                        exp,
                        cookTime
                )
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(input.asItem()), this.has(input))
                .save(
                        this.output,
                        ResourceKey.create(
                                Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(
                                        Electron.MOD_ID,
                                        BuiltInRegistries.ITEM.getKey(output.asItem()).getPath()
                                                + "_from_smelting_"
                                                + BuiltInRegistries.ITEM.getKey(input.asItem()).getPath()
                                )
                        )
                );
    }

    protected void buildBlastingRecipe(
            ItemLike input,
            RecipeCategory recipeCategory,
            CookingBookCategory cookingBookCategory,
            ItemLike output,
            float exp,
            int cookTime
    ) {
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(input),
                        recipeCategory,
                        cookingBookCategory,
                        output,
                        exp,
                        cookTime
                )
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(input.asItem()), this.has(input))
                .save(
                        this.output,
                        ResourceKey.create(
                                Registries.RECIPE,
                                Identifier.fromNamespaceAndPath(
                                        Electron.MOD_ID,
                                        BuiltInRegistries.ITEM.getKey(output.asItem()).getPath()
                                                + "_from_blasting_"
                                                + BuiltInRegistries.ITEM.getKey(input.asItem()).getPath()
                                )
                        )
                );
    }
}
