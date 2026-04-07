package net.wheatbread11.electron.event;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.content.tags.ModItemTags;

@EventBusSubscriber(modid = Electron.MOD_ID)
public class LivingDamageEventHandler {

    @SubscribeEvent
    public static void onPreLivingDamage(LivingDamageEvent.Pre event) {
        float originalDamage = event.getOriginalDamage();
        Entity entityDamaged = event.getEntity();
        Entity entityAttacked = event.getSource().getEntity();

        if (entityAttacked instanceof LivingEntity livingEntityAttacked
                && livingEntityAttacked.getMainHandItem().is(ModItemTags.WEAPON_IMMUNE_TO_UNDEAD)
                && entityDamaged.is(EntityTypeTags.UNDEAD)
        ) {
                event.setNewDamage(originalDamage * 2.0F);
        }
    }
}
