package net.wheatbread11.electron.content.core.crusher;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.wheatbread11.electron.content.world.level.block.CrusherBlock;
import net.wheatbread11.electron.registry.ModBlocks;
import net.wheatbread11.electron.registry.ModItems;

public class CrusherDropsRegisterDefault {

    public static void register() {
        CrusherBlock.registerDrops(
                Blocks.COBBLESTONE,
                new CrusherPlainDrops(Blocks.GRAVEL.asItem(), 1)
        );
        CrusherBlock.registerDrops(
                Blocks.GRAVEL,
                new CrusherBundledDrops(
                        new CrusherPlainDrops(Blocks.SAND.asItem(), 1),
                        new CrusherChanceDrops(Items.FLINT, 1, 0.1F)
                )
        );
        CrusherBlock.registerDrops(
                Blocks.DIORITE,
                new CrusherBundledDrops(
                        new CrusherPlainDrops(Blocks.COBBLESTONE.asItem(), 1),
                        new CrusherChanceDrops(Items.QUARTZ, 1, 0.2F)
                )
        );
        CrusherBlock.registerDrops(
                Blocks.ANDESITE,
                new CrusherBundledDrops(
                        new CrusherPlainDrops(Blocks.COBBLESTONE.asItem(), 1),
                        new CrusherChanceDrops(Items.QUARTZ, 1, 0.1F)
                )
        );
        CrusherBlock.registerDrops(
                Blocks.GRANITE,
                new CrusherBundledDrops(
                        new CrusherPlainDrops(Blocks.COBBLESTONE.asItem(), 1),
                        new CrusherChanceDrops(Items.QUARTZ, 1, 0.3F)
                )
        );
        CrusherBlock.registerDrops(
                Blocks.SANDSTONE,
                new CrusherPlainDrops(Blocks.SAND.asItem(), 4)
        );
        CrusherBlock.registerDrops(
                Blocks.RED_SANDSTONE,
                new CrusherPlainDrops(Blocks.RED_SAND.asItem(), 4)
        );
        CrusherBlock.registerDrops(
                Blocks.BRICKS,
                new CrusherPlainDrops(Items.BRICK, 4)
        );
        CrusherBlock.registerDrops(
                Blocks.NETHER_BRICKS,
                new CrusherPlainDrops(Items.NETHER_BRICK, 4)
        );
        CrusherBlock.registerDrops(
                Blocks.RESIN_BRICKS,
                new CrusherPlainDrops(Items.RESIN_BRICK, 4)
        );
        CrusherBlock.registerDrops(
                Blocks.AMETHYST_BLOCK,
                new CrusherPlainDrops(Items.AMETHYST_SHARD, 4)
        );
        CrusherBlock.registerDrops(
                Blocks.RAW_IRON_BLOCK,
                new CrusherBundledDrops(
                        new CrusherPlainDrops(ModItems.IRON_DUST.get(), 12),
                        new CrusherChanceDrops(ModItems.IRON_DUST.get(), 4, 0.5F)
                )
        );
        CrusherBlock.registerDrops(
                Blocks.RAW_GOLD_BLOCK,
                new CrusherBundledDrops(
                        new CrusherPlainDrops(ModItems.GOLD_DUST.get(), 12),
                        new CrusherChanceDrops(ModItems.GOLD_DUST.get(), 4, 0.5F)
                )
        );
        CrusherBlock.registerDrops(
                Blocks.RAW_COPPER_BLOCK,
                new CrusherBundledDrops(
                        new CrusherPlainDrops(ModItems.COPPER_DUST.get(), 12),
                        new CrusherChanceDrops(ModItems.COPPER_DUST.get(), 4, 0.5F)
                )
        );
        CrusherBlock.registerDrops(
                ModBlocks.RAW_SILVER_BLOCK.get(),
                new CrusherBundledDrops(
                        new CrusherPlainDrops(ModItems.SILVER_DUST.get(), 12),
                        new CrusherChanceDrops(ModItems.SILVER_DUST.get(), 4, 0.5F)
                )
        );
    }
}
