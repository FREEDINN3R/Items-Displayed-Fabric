package net.freedinner.items_displayed.item;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.item.custom.ItemDisplayItem;
import net.freedinner.items_displayed.item.custom.JewelryPillowItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item ITEM_DISPLAY=register("item_display",ItemDisplayItem::new);

    public static final Item WHITE_JEWELRY_PILLOW=register("white_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.WHITE));

    public static final Item LIGHT_GRAY_JEWELRY_PILLOW=register("light_gray_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.LIGHT_GRAY));

    public static final Item GRAY_JEWELRY_PILLOW=register("gray_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.GRAY));

    public static final Item BLACK_JEWELRY_PILLOW=register("black_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.BLACK));

    public static final Item RED_JEWELRY_PILLOW=register("red_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.RED));

    public static final Item ORANGE_JEWELRY_PILLOW=register("orange_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.ORANGE));

    public static final Item YELLOW_JEWELRY_PILLOW=register("yellow_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.YELLOW));

    public static final Item LIME_JEWELRY_PILLOW=register("lime_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.LIME));

    public static final Item GREEN_JEWELRY_PILLOW=register("green_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.GREEN));

    public static final Item LIGHT_BLUE_JEWELRY_PILLOW=register("light_blue_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.LIGHT_BLUE));

    public static final Item CYAN_JEWELRY_PILLOW=register("cyan_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.CYAN));

    public static final Item BLUE_JEWELRY_PILLOW=register("blue_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.BLUE));

    public static final Item PURPLE_JEWELRY_PILLOW=register("purple_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.PURPLE));

    public static final Item MAGENTA_JEWELRY_PILLOW=register("magenta_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.MAGENTA));

    public static final Item PINK_JEWELRY_PILLOW=register("pink_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.PINK));

    public static final Item BROWN_JEWELRY_PILLOW=register("brown_jewelry_pillow",
            properties->new JewelryPillowItem(properties,DyeColor.BROWN));

    private static Item register(String name, Function<Item.Properties,Item> function){
        Identifier id=ItemsDisplayed.id(name);
        return Registry.register(BuiltInRegistries.ITEM, id, function.apply(new Item.Properties().setId(ResourceKey.create(BuiltInRegistries.ITEM.key(), id))));
    }

    public static void registerItems(){
        ItemsDisplayed.LOGGER.info("Registering items");

        FuelRegistryEvents.BUILD.register((builder, context)-> builder.add(ITEM_DISPLAY,250));
    }
}