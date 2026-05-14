package net.freedinner.items_displayed.item;

import net.freedinner.items_displayed.ItemsDisplayed;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> CRYSTAL_SHAPED = register("crystal_shaped");
    public static final TagKey<Item> DISC_SHAPED = register("disc_shaped");
    public static final TagKey<Item> GEMSTONE_SHAPED = register("gemstone_shaped");
    public static final TagKey<Item> INGOT_SHAPED = register("ingot_shaped");
    public static final TagKey<Item> SHERD_SHAPED = register("sherd_shaped");
    public static final TagKey<Item> TEMPLATE_SHAPED = register("template_shaped");

    private static TagKey<Item> register(String name) {
        return TagKey.create(Registries.ITEM, ItemsDisplayed.id(name));
    }

    public static void registerTags() {
        ItemsDisplayed.LOGGER.info("Registering tags");
    }
}
