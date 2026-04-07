package net.wheatbread11.electron.event;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.wheatbread11.electron.Electron;
import net.wheatbread11.electron.common.Utils;
import net.wheatbread11.electron.content.tags.ModItemTags;

@EventBusSubscriber(modid = Electron.MOD_ID)
public class EntityJoinLevelEventHandler {

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();

        if (entity.is(EntityTypeTags.UNDEAD) && entity instanceof PathfinderMob pathfinderMob) {
            pathfinderMob.goalSelector.addGoal(
                    2,
                    new AvoidEntityGoal<>(
                            pathfinderMob,
                            LivingEntity.class,
                            16.0F, 1.2, 1.2,
                            t -> EntitySelector.NO_SPECTATORS.test(t) && Utils.isWearingTag(t, ModItemTags.EQUIPMENT_AVOID_UNDEAD)
                    )
            );
        }
    }
}
