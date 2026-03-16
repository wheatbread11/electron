package net.wheatbread11.electron.content.core.crusher;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CrusherPlainDrops implements CrusherDrops{

    protected Item drop;
    protected int amount;

    public CrusherPlainDrops(Item drop, int amount) {
        this.drop = drop;
        this.amount = amount;
    }

    @Override
    public List<ItemStack> obtain(RandomSource random) {
        return List.of(new ItemStack(drop, amount));
    }
}
