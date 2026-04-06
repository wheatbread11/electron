package net.wheatbread11.electron.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.content.world.level.block.entity.BuilderBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntityType {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Electron.MOD_ID);

    public static final Supplier<BlockEntityType<BuilderBlockEntity>> BUILDER =
            BLOCK_ENTITY_TYPE.register(
                    "builder",
                    () -> new BlockEntityType<>(
                            BuilderBlockEntity::new,
                            false,
                            ModBlocks.BUILDER.get()
                    )
            );
}
