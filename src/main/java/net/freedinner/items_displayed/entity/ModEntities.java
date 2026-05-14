package net.freedinner.items_displayed.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.entity.custom.item_display.ItemDisplayEntity;
import net.freedinner.items_displayed.entity.custom.jewelry_pillow.JewelryPillowEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final EntityType<ItemDisplayEntity> ITEM_DISPLAY = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            ItemsDisplayed.id( "item_display"),
            EntityType.Builder
                    .of(ItemDisplayEntity::new, MobCategory.MISC)
                    .sized(0.7f, 0.7f)
                    .build()
    );

    public static final EntityType<JewelryPillowEntity> JEWELRY_PILLOW = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            ItemsDisplayed.id( "jewelry_pillow"),
            EntityType.Builder
                    .of(JewelryPillowEntity::new, MobCategory.MISC)
                    .sized(0.75f, 0.4f)
                    .build()
    );

    static {
        FabricDefaultAttributeRegistry.register(ITEM_DISPLAY, ItemDisplayEntity.createLivingAttributes());
        FabricDefaultAttributeRegistry.register(JEWELRY_PILLOW, JewelryPillowEntity.createLivingAttributes());
    }

    public static void registerEntities() {
        ItemsDisplayed.LOGGER.info("Registering entities");
    }
}
