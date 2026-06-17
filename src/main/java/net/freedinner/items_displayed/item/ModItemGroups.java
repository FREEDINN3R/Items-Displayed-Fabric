package net.freedinner.items_displayed.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItemGroups {

    public static final ResourceKey<CreativeModeTab> ITEMS_DISPLAYED = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), ItemsDisplayed.id("item_group")
    );

    public static final CreativeModeTab ITEMS_DISPLAYED_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.ITEM_DISPLAY))
            .title(Component.translatable("item.items_displayed.item_group_name"))
            .displayItems((params, entries) -> {
                // Custom items
                entries.accept(ModItems.ITEM_DISPLAY);
                entries.accept(ModItems.WHITE_JEWELRY_PILLOW);
                entries.accept(ModItems.LIGHT_GRAY_JEWELRY_PILLOW);
                entries.accept(ModItems.GRAY_JEWELRY_PILLOW);
                entries.accept(ModItems.BLACK_JEWELRY_PILLOW);
                entries.accept(ModItems.BROWN_JEWELRY_PILLOW);
                entries.accept(ModItems.RED_JEWELRY_PILLOW);
                entries.accept(ModItems.ORANGE_JEWELRY_PILLOW);
                entries.accept(ModItems.YELLOW_JEWELRY_PILLOW);
                entries.accept(ModItems.LIME_JEWELRY_PILLOW);
                entries.accept(ModItems.GREEN_JEWELRY_PILLOW);
                entries.accept(ModItems.LIGHT_BLUE_JEWELRY_PILLOW);
                entries.accept(ModItems.CYAN_JEWELRY_PILLOW);
                entries.accept(ModItems.BLUE_JEWELRY_PILLOW);
                entries.accept(ModItems.PURPLE_JEWELRY_PILLOW);
                entries.accept(ModItems.MAGENTA_JEWELRY_PILLOW);
                entries.accept(ModItems.PINK_JEWELRY_PILLOW);

                // Gems & crystals
                entries.accept(Items.COAL);
                entries.accept(Items.CHARCOAL);
                entries.accept(Items.LAPIS_LAZULI);
                entries.accept(Items.AMETHYST_SHARD);
                entries.accept(Items.DIAMOND);
                entries.accept(Items.EMERALD);
                entries.accept(Items.ECHO_SHARD);

                // Ingots & bricks
                entries.accept(Items.BRICK);
                entries.accept(Items.NETHER_BRICK);
                entries.accept(Items.IRON_INGOT);
                entries.accept(Items.COPPER_INGOT);
                entries.accept(Items.GOLD_INGOT);
                entries.accept(Items.NETHERITE_INGOT);

                // Sherds
                entries.accept(Items.ANGLER_POTTERY_SHERD);
                entries.accept(Items.ARCHER_POTTERY_SHERD);
                entries.accept(Items.ARMS_UP_POTTERY_SHERD);
                entries.accept(Items.BLADE_POTTERY_SHERD);
                entries.accept(Items.BREWER_POTTERY_SHERD);
                entries.accept(Items.BURN_POTTERY_SHERD);
                entries.accept(Items.DANGER_POTTERY_SHERD);
                entries.accept(Items.EXPLORER_POTTERY_SHERD);
                entries.accept(Items.FLOW_POTTERY_SHERD);
                entries.accept(Items.FRIEND_POTTERY_SHERD);
                entries.accept(Items.GUSTER_POTTERY_SHERD);
                entries.accept(Items.HEART_POTTERY_SHERD);
                entries.accept(Items.HEARTBREAK_POTTERY_SHERD);
                entries.accept(Items.HOWL_POTTERY_SHERD);
                entries.accept(Items.MINER_POTTERY_SHERD);
                entries.accept(Items.MOURNER_POTTERY_SHERD);
                entries.accept(Items.PLENTY_POTTERY_SHERD);
                entries.accept(Items.PRIZE_POTTERY_SHERD);
                entries.accept(Items.SCRAPE_POTTERY_SHERD);
                entries.accept(Items.SHEAF_POTTERY_SHERD);
                entries.accept(Items.SHELTER_POTTERY_SHERD);
                entries.accept(Items.SKULL_POTTERY_SHERD);
                entries.accept(Items.SNORT_POTTERY_SHERD);

                // Templates
                entries.accept(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.accept(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE);
                entries.accept(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE);

                // Discs
                entries.accept(Items.MUSIC_DISC_13);
                entries.accept(Items.MUSIC_DISC_CAT);
                entries.accept(Items.MUSIC_DISC_BLOCKS);
                entries.accept(Items.MUSIC_DISC_CHIRP);
                entries.accept(Items.MUSIC_DISC_FAR);
                entries.accept(Items.MUSIC_DISC_MALL);
                entries.accept(Items.MUSIC_DISC_MELLOHI);
                entries.accept(Items.MUSIC_DISC_STAL);
                entries.accept(Items.MUSIC_DISC_STRAD);
                entries.accept(Items.MUSIC_DISC_WARD);
                entries.accept(Items.MUSIC_DISC_11);
                entries.accept(Items.MUSIC_DISC_CREATOR_MUSIC_BOX);
                entries.accept(Items.MUSIC_DISC_WAIT);
                entries.accept(Items.MUSIC_DISC_CREATOR);
                entries.accept(Items.MUSIC_DISC_PRECIPICE);
                entries.accept(Items.MUSIC_DISC_OTHERSIDE);
                entries.accept(Items.MUSIC_DISC_RELIC);
                entries.accept(Items.MUSIC_DISC_5);
                entries.accept(Items.MUSIC_DISC_PIGSTEP);
                entries.accept(Items.DISC_FRAGMENT_5);
            })
            .build();

    public static void registerItemGroups() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEMS_DISPLAYED, ITEMS_DISPLAYED_TAB);
        ItemsDisplayed.LOGGER.info("Registering item groups");
    }
}
