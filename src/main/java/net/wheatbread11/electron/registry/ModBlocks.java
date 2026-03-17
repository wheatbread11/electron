package net.wheatbread11.electron.registry;

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
}
