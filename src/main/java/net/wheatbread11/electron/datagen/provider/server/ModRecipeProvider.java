package net.wheatbread11.electron.datagen.provider.server;

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
import net.wheatbread11.electron.registry.ModItems;
import org.jspecify.annotations.NonNull;

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

        buildSmeltingAndBlastingRecipe(
                ModItems.RAW_SILVER,
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                ModItems.SILVER_INGOT,
                0.7F,
                200
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
