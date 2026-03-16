package net.wheatbread11.electron.content.core.crusher;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CrusherChanceDrops extends CrusherPlainDrops {

    protected float chance;

    public CrusherChanceDrops(
            Item drop, int amount, float chance
    ) {
        super(drop, amount);
        this.chance = chance;
    }

    @Override
    public List<ItemStack> obtain(RandomSource random) {
        return random.nextFloat() < chance
                        ? List.of(new ItemStack(drop, amount))
                        : List.of();
    }
}
