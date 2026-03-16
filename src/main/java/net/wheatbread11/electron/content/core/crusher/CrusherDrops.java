package net.wheatbread11.electron.content.core.crusher;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public interface CrusherDrops {
    List<ItemStack> obtain(RandomSource random);
}
