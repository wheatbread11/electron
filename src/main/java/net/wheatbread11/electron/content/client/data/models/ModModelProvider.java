package net.wheatbread11.electron.content.client.data.models;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.content.world.item.equipment.ModEquipmentAssets;
import net.wheatbread11.electron.content.world.level.block.ModBlocks;
import net.wheatbread11.electron.content.world.item.ModItems;
import org.jspecify.annotations.NonNull;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, Electron.MOD_ID);
    }

    protected static final TexturedModel.Provider FACING_BLOCK_TEXTURE = TexturedModel.createDefault(
                block -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_up"))
                        .put(TextureSlot.UP, TextureMapping.getBlockTexture(block, "_up"))
                        .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(block, "_down"))
                        .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(block, "_north"))
                        .put(TextureSlot.EAST, TextureMapping.getBlockTexture(block, "_east"))
                        .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(block, "_south"))
                        .put(TextureSlot.WEST, TextureMapping.getBlockTexture(block, "_west")),
                ModelTemplates.CUBE_DIRECTIONAL
        );

    @Override
    protected void registerModels(
            @NonNull BlockModelGenerators blockModels,
            @NonNull ItemModelGenerators itemModels
    ) {

        Block crusher = ModBlocks.CRUSHER.get();
        Identifier crusherModelLoc = FACING_BLOCK_TEXTURE.create(crusher, blockModels.modelOutput);
        Variant crusherVariant = new Variant(crusherModelLoc);
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(
                        crusher,
                        BlockModelGenerators.variant(crusherVariant)
                ).with(
                        PropertyDispatch.modify(BlockStateProperties.FACING)
                                .select(Direction.NORTH, BlockModelGenerators.NOP)
                                .select(Direction.EAST, BlockModelGenerators.Y_ROT_90)
                                .select(Direction.SOUTH, BlockModelGenerators.Y_ROT_180)
                                .select(Direction.WEST, BlockModelGenerators.Y_ROT_270)
                                .select(Direction.UP, BlockModelGenerators.X_ROT_270)
                                .select(Direction.DOWN, BlockModelGenerators.X_ROT_90)
                )
        );

        Block builder = ModBlocks.BUILDER.get();
        Identifier builderModelLoc = FACING_BLOCK_TEXTURE.create(builder, blockModels.modelOutput);
        Variant builderVariant = new Variant(builderModelLoc);
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(
                        builder,
                        BlockModelGenerators.variant(builderVariant)
                ).with(
                        PropertyDispatch.modify(BlockStateProperties.FACING)
                                .select(Direction.NORTH, BlockModelGenerators.NOP)
                                .select(Direction.EAST, BlockModelGenerators.Y_ROT_90)
                                .select(Direction.SOUTH, BlockModelGenerators.Y_ROT_180)
                                .select(Direction.WEST, BlockModelGenerators.Y_ROT_270)
                                .select(Direction.UP, BlockModelGenerators.X_ROT_270)
                                .select(Direction.DOWN, BlockModelGenerators.X_ROT_90)
                )
        );

        blockModels.createTrivialCube(ModBlocks.SILVER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.SILVER_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.RAW_SILVER_BLOCK.get());

        itemModels.generateFlatItem(ModItems.IRON_DUST.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.GOLD_DUST.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.COPPER_DUST.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SILVER_DUST.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.SILVER_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SILVER_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_SILVER.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.SILVER_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.SILVER_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.SILVER_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.SILVER_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.SILVER_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateSpear(ModItems.SILVER_SPEAR.get());
        itemModels.generateDynamicTrimmableItem(ModItems.SILVER_HELMET.get(), itemModels.createFlatItemModel(ModItems.SILVER_HELMET.get(), ModelTemplates.FLAT_ITEM), ItemModelGenerators.TRIM_PREFIX_HELMET);
        itemModels.generateDynamicTrimmableItem(ModItems.SILVER_CHESTPLATE.get(), itemModels.createFlatItemModel(ModItems.SILVER_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM), ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        itemModels.generateDynamicTrimmableItem(ModItems.SILVER_LEGGINGS.get(), itemModels.createFlatItemModel(ModItems.SILVER_LEGGINGS.get(), ModelTemplates.FLAT_ITEM), ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        itemModels.generateDynamicTrimmableItem(ModItems.SILVER_BOOTS.get(), itemModels.createFlatItemModel(ModItems.SILVER_BOOTS.get(), ModelTemplates.FLAT_ITEM), ItemModelGenerators.TRIM_PREFIX_BOOTS);
        itemModels.generateFlatItem(ModItems.SILVER_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SILVER_NAUTILUS_ARMOR.get(), ModelTemplates.FLAT_ITEM);
    }
}
