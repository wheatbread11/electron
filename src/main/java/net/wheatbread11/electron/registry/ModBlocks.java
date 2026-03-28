package net.wheatbread11.electron.registry;

import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.content.world.level.block.BuilderBlock;
import net.wheatbread11.electron.content.world.level.block.CrusherBlock;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Electron.MOD_ID);

    public static final DeferredBlock<CrusherBlock> CRUSHER =
            BLOCKS.registerBlock(
                    "crusher",
                    CrusherBlock::new,
                    () -> BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.5F)
            );
    public static final DeferredBlock<BuilderBlock> BUILDER =
            BLOCKS.registerBlock(
                    "builder",
                    BuilderBlock::new,
                    () -> BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_RED)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 6.0F)
            );

    public static final DeferredBlock<DropExperienceBlock> SILVER_ORE =
            BLOCKS.registerBlock(
                    "silver_ore",
                    p -> new DropExperienceBlock(ConstantInt.of(0), p),
                    () -> BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F)
            );
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_SILVER_ORE =
            BLOCKS.registerBlock(
                    "deepslate_silver_ore",
                    p -> new DropExperienceBlock(ConstantInt.of(0), p),
                    () -> BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(4.5F, 3.0F)
                            .sound(SoundType.DEEPSLATE)
            );
    public static final DeferredBlock<Block> SILVER_BLOCK =
            BLOCKS.registerBlock(
                    "silver_block",
                    Block::new,
                    () -> BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_LIGHT_GRAY)
                            .instrument(NoteBlockInstrument.BELL)
                            .requiresCorrectToolForDrops()
                            .strength(3.0F, 6.0F)
                            .sound(SoundType.METAL)
            );
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK =
            BLOCKS.registerBlock(
                    "raw_silver_block",
                    Block::new,
                    () -> BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_LIGHT_GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(5.0F, 6.0F)
            );
}
