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

    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

        ShapedRecipeBuilder.shaped(
                    this.registries.lookupOrThrow(Registries.ITEM),
                    RecipeCategory.REDSTONE,
                    ModItems.CRUSHER.get().asItem()
                )
                .pattern("###")
                .pattern("#X#")
                .pattern("#R#")
                .define('#', Items.COBBLESTONE)
                .define('X', Items.IRON_PICKAXE)
                .define('R', Items.REDSTONE)
                .unlockedBy("has_iron_pickaxe", this.has(Items.IRON_PICKAXE))
                .save(this.output);

        buildSmeltingRecipe(
                ModItems.IRON_DUST.get(),
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                Items.IRON_INGOT,
                0.2F,
                200
        );
        buildBlastingRecipe(
                ModItems.IRON_DUST.get(),
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                Items.IRON_INGOT,
                0.2F,
                100
        );

        buildSmeltingRecipe(
                ModItems.GOLD_DUST.get(),
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                Items.GOLD_INGOT,
                0.2F,
                200
        );
        buildBlastingRecipe(
                ModItems.GOLD_DUST.get(),
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                Items.GOLD_INGOT,
                0.2F,
                100
        );

        buildSmeltingRecipe(
                ModItems.COPPER_DUST.get(),
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                Items.COPPER_INGOT,
                0.2F,
                200
        );
        buildBlastingRecipe(
                ModItems.COPPER_DUST.get(),
                RecipeCategory.MISC,
                CookingBookCategory.MISC,
                Items.COPPER_INGOT,
                0.2F,
                100
        );
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
}
