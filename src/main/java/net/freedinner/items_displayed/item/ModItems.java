package net.freedinner.items_displayed.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.item.custom.ItemDisplayItem;
import net.freedinner.items_displayed.item.custom.JewelryPillowItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item ITEM_DISPLAY = register("item_display",
            new ItemDisplayItem(new Item.Properties()));

    public static final Item WHITE_JEWELRY_PILLOW = register("white_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.WHITE));
    public static final Item LIGHT_GRAY_JEWELRY_PILLOW = register("light_gray_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.LIGHT_GRAY));
    public static final Item GRAY_JEWELRY_PILLOW = register("gray_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.GRAY));
    public static final Item BLACK_JEWELRY_PILLOW = register("black_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.BLACK));
    public static final Item RED_JEWELRY_PILLOW = register("red_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.RED));
    public static final Item ORANGE_JEWELRY_PILLOW = register("orange_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.ORANGE));
    public static final Item YELLOW_JEWELRY_PILLOW = register("yellow_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.YELLOW));
    public static final Item LIME_JEWELRY_PILLOW = register("lime_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.LIME));
    public static final Item GREEN_JEWELRY_PILLOW = register("green_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.GREEN));
    public static final Item LIGHT_BLUE_JEWELRY_PILLOW = register("light_blue_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.LIGHT_BLUE));
    public static final Item CYAN_JEWELRY_PILLOW = register("cyan_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.CYAN));
    public static final Item BLUE_JEWELRY_PILLOW = register("blue_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.BLUE));
    public static final Item PURPLE_JEWELRY_PILLOW = register("purple_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.PURPLE));
    public static final Item MAGENTA_JEWELRY_PILLOW = register("magenta_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.MAGENTA));
    public static final Item PINK_JEWELRY_PILLOW = register("pink_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.PINK));
    public static final Item BROWN_JEWELRY_PILLOW = register("brown_jewelry_pillow",
            new JewelryPillowItem(new Item.Properties(), DyeColor.BROWN));

    private static Item register(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ItemsDisplayed.id(name), item);
    }

    public static void registerItems() {
        ItemsDisplayed.LOGGER.info("Registering items");

        FuelRegistry.INSTANCE.add(ITEM_DISPLAY, 250);
    }
}
