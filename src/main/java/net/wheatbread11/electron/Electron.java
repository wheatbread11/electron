package net.wheatbread11.electron;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.wheatbread11.electron.content.world.entity.ModBlockEntityType;
import net.wheatbread11.electron.content.world.level.block.ModBlocks;
import net.wheatbread11.electron.content.world.item.ModItems;

@Mod(Electron.MOD_ID)
public class Electron {

    public static final String MOD_ID = "electron";

    public Electron(IEventBus modBus) {

        ModItems.ITEMS.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModBlockEntityType.BLOCK_ENTITY_TYPE.register(modBus);
    }
}
