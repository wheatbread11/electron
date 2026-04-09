package net.wheatbread11.electron.content.world.item.equipment;

import com.google.common.collect.Maps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.wheatbread11.electron.content.tags.ModItemTags;

import java.util.Map;

public interface ModArmorMaterials {
    ArmorMaterial SILVER = new ArmorMaterial(7, makeDefense(1, 3, 5, 2, 7), 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.0F, ModItemTags.REPAIRS_SILVER_ARMOR, ModEquipmentAssets.SILVER);

    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }
}
