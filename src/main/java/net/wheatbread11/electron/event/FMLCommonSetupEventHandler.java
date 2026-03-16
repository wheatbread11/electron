package net.wheatbread11.electron.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.content.core.crusher.*;

@EventBusSubscriber(modid = Electron.MOD_ID)
public class FMLCommonSetupEventHandler {

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CrusherDropsRegisterDefault.register();
        });
    }
}
