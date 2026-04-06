package net.wheatbread11.electron.content.world.item;

import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wheatbread11.electron.Electron;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Electron.MOD_ID);

    public static final DeferredItem<Item> IRON_DUST = ITEMS.registerSimpleItem("iron_dust");
    public static final DeferredItem<Item> GOLD_DUST = ITEMS.registerSimpleItem("gold_dust");
    public static final DeferredItem<Item> COPPER_DUST = ITEMS.registerSimpleItem("copper_dust");
    public static final DeferredItem<Item> SILVER_DUST = ITEMS.registerSimpleItem("silver_dust");

    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.registerSimpleItem("silver_ingot");
    public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.registerSimpleItem("silver_nugget");
    public static final DeferredItem<Item> RAW_SILVER = ITEMS.registerSimpleItem("raw_silver");

    public static final DeferredItem<Item> SILVER_SWORD =
            ITEMS.registerItem(
                    "silver_sword",
                    Item::new,
                    () -> new Item.Properties().sword(ModToolMaterial.SILVER, 3.0F, -2.4F)
            );
    public static final DeferredItem<ShovelItem> SILVER_SHOVEL =
            ITEMS.registerItem(
                    "silver_shovel",
                    p -> new ShovelItem(ModToolMaterial.SILVER, 1.5F, -3.0F, p)
            );
    public static final DeferredItem<Item> SILVER_PICKAXE =
            ITEMS.registerItem(
                    "silver_pickaxe",
                    Item::new,
                    () -> new Item.Properties().pickaxe(ModToolMaterial.SILVER, 1.0F, -2.8F)
            );
    public static final DeferredItem<AxeItem> SILVER_AXE =
            ITEMS.registerItem(
                    "silver_axe",
                    p -> new AxeItem(ModToolMaterial.SILVER, 6.0F, -3.0F, p)
            );
    public static final DeferredItem<HoeItem> SILVER_HOE =
            ITEMS.registerItem(
                    "silver_hoe",
                    p -> new HoeItem(ModToolMaterial.SILVER, 0.0F, -3.0F, p)
            );
    public static final DeferredItem<Item> SILVER_SPEAR =
            ITEMS.registerItem(
                    "silver_spear",
                    Item::new,
                    () -> new Item.Properties().spear(
                            ModToolMaterial.SILVER,
                            0.95F, 0.7F, 0.7F,
                            3.5F, 13.0F,
                            8.5F, 5.1F,
                            13.75F, 4.6F
                    )
            );
    public static final DeferredItem<Item> SILVER_HELMET =
            ITEMS.registerItem(
                    "silver_helmet",
                    Item::new,
                    () -> new Item.Properties().humanoidArmor(
                            ModArmorMaterials.SILVER,
                            ArmorType.HELMET
                    )
            );
    public static final DeferredItem<Item> SILVER_CHESTPLATE =
            ITEMS.registerItem(
                    "silver_chestplate",
                    Item::new,
                    () -> new Item.Properties().humanoidArmor(
                            ModArmorMaterials.SILVER,
                            ArmorType.CHESTPLATE
                    )
            );
    public static final DeferredItem<Item> SILVER_LEGGINGS =
            ITEMS.registerItem(
                    "silver_leggings",
                    Item::new,
                    () -> new Item.Properties().humanoidArmor(
                            ModArmorMaterials.SILVER,
                            ArmorType.LEGGINGS
                    )
            );
    public static final DeferredItem<Item> SILVER_BOOTS =
            ITEMS.registerItem(
                    "silver_boots",
                    Item::new,
                    () -> new Item.Properties().humanoidArmor(
                            ModArmorMaterials.SILVER,
                            ArmorType.BOOTS
                    )
            );
    public static final DeferredItem<Item> SILVER_HORSE_ARMOR =
            ITEMS.registerItem(
                    "silver_horse_armor",
                    Item::new,
                    () -> new Item.Properties().horseArmor(ModArmorMaterials.SILVER)
            );
    public static final DeferredItem<Item> SILVER_NAUTILUS_ARMOR =
            ITEMS.registerItem(
                    "silver_nautilus_armor",
                    Item::new,
                    () -> new Item.Properties().nautilusArmor(ModArmorMaterials.SILVER)
            );

    public static final DeferredItem<BlockItem> CRUSHER =
            ITEMS.registerSimpleBlockItem("crusher", ModBlocks.CRUSHER);
    public static final DeferredItem<BlockItem> BUILDER =
            ITEMS.registerSimpleBlockItem("builder", ModBlocks.BUILDER);

    public static final DeferredItem<BlockItem> SILVER_ORE =
            ITEMS.registerSimpleBlockItem("silver_ore", ModBlocks.SILVER_ORE);
    public static final DeferredItem<BlockItem> DEEPSLATE_SILVER_ORE =
            ITEMS.registerSimpleBlockItem("deepslate_silver_ore", ModBlocks.DEEPSLATE_SILVER_ORE);
    public static final DeferredItem<BlockItem> SILVER_BLOCK =
            ITEMS.registerSimpleBlockItem("silver_block", ModBlocks.SILVER_BLOCK);
    public static final DeferredItem<BlockItem> RAW_SILVER_BLOCK =
            ITEMS.registerSimpleBlockItem("raw_silver_block", ModBlocks.RAW_SILVER_BLOCK);
}
