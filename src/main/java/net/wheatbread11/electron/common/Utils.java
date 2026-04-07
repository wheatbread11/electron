package net.wheatbread11.electron.common;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Utils {

    public static boolean isWearingTag(LivingEntity entity, TagKey<Item> tag) {
        for (EquipmentSlot slot : EquipmentSlot.VALUES) {
            ItemStack itemStack = entity.getItemBySlot(slot);

            if (!itemStack.isEmpty() && itemStack.is(tag)) {
                return true;
            }
        }

        return false;
    }
}
