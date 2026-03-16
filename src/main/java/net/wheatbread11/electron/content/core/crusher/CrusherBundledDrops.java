package net.wheatbread11.electron.content.core.crusher;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CrusherBundledDrops implements CrusherDrops {

    protected List<CrusherDrops> drops;

    public CrusherBundledDrops(List<CrusherDrops> drops) {
        this.drops = drops;
    }

    public CrusherBundledDrops(CrusherDrops... drops) {
        this(List.of(drops));
    }

    @Override
    public List<ItemStack> obtain(RandomSource random) {
        return drops.stream()
                .flatMap(drop -> drop.obtain(random).stream())
                .toList();
    }
}
