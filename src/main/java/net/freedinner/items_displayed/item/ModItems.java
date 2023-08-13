package net.freedinner.items_displayed.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.block.ModBlocks;
import net.freedinner.items_displayed.item.custom.DebugBlockItem;
import net.freedinner.items_displayed.item.custom.ItemDisplayItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ITEM_DISPLAY = register("item_display",
            new ItemDisplayItem(new FabricItemSettings()));

    public static final DebugBlockItem ANGLER_POTTERY_SHERD = registerDebug("angler_pottery_sherd",
            ModBlocks.ANGLER_POTTERY_SHERD);
    public static final DebugBlockItem ARCHER_POTTERY_SHERD = registerDebug("archer_pottery_sherd",
            ModBlocks.ARCHER_POTTERY_SHERD);
    public static final DebugBlockItem ARMS_UP_POTTERY_SHERD = registerDebug("arms_up_pottery_sherd",
            ModBlocks.ARMS_UP_POTTERY_SHERD);
    public static final DebugBlockItem BLADE_POTTERY_SHERD = registerDebug("blade_pottery_sherd",
            ModBlocks.BLADE_POTTERY_SHERD);
    public static final DebugBlockItem BREWER_POTTERY_SHERD = registerDebug("brewer_pottery_sherd",
            ModBlocks.BREWER_POTTERY_SHERD);
    public static final DebugBlockItem BURN_POTTERY_SHERD = registerDebug("burn_pottery_sherd",
            ModBlocks.BURN_POTTERY_SHERD);
    public static final DebugBlockItem DANGER_POTTERY_SHERD = registerDebug("danger_pottery_sherd",
            ModBlocks.DANGER_POTTERY_SHERD);
    public static final DebugBlockItem EXPLORER_POTTERY_SHERD = registerDebug("explorer_pottery_sherd",
            ModBlocks.EXPLORER_POTTERY_SHERD);
    public static final DebugBlockItem FRIEND_POTTERY_SHERD = registerDebug("friend_pottery_sherd",
            ModBlocks.FRIEND_POTTERY_SHERD);
    public static final DebugBlockItem HEART_POTTERY_SHERD = registerDebug("heart_pottery_sherd",
            ModBlocks.HEART_POTTERY_SHERD);
    public static final DebugBlockItem HEARTBREAK_POTTERY_SHERD = registerDebug("heartbreak_pottery_sherd",
            ModBlocks.HEARTBREAK_POTTERY_SHERD);
    public static final DebugBlockItem HOWL_POTTERY_SHERD = registerDebug("howl_pottery_sherd",
            ModBlocks.HOWL_POTTERY_SHERD);
    public static final DebugBlockItem MINER_POTTERY_SHERD = registerDebug("miner_pottery_sherd",
            ModBlocks.MINER_POTTERY_SHERD);
    public static final DebugBlockItem MOURNER_POTTERY_SHERD = registerDebug("mourner_pottery_sherd",
            ModBlocks.MOURNER_POTTERY_SHERD);
    public static final DebugBlockItem PLENTY_POTTERY_SHERD = registerDebug("plenty_pottery_sherd",
            ModBlocks.PLENTY_POTTERY_SHERD);
    public static final DebugBlockItem PRIZE_POTTERY_SHERD = registerDebug("prize_pottery_sherd",
            ModBlocks.PRIZE_POTTERY_SHERD);
    public static final DebugBlockItem SHEAF_POTTERY_SHERD = registerDebug("sheaf_pottery_sherd",
            ModBlocks.SHEAF_POTTERY_SHERD);
    public static final DebugBlockItem SHELTER_POTTERY_SHERD = registerDebug("shelter_pottery_sherd",
            ModBlocks.SHELTER_POTTERY_SHERD);
    public static final DebugBlockItem SKULL_POTTERY_SHERD = registerDebug("skull_pottery_sherd",
            ModBlocks.SKULL_POTTERY_SHERD);
    public static final DebugBlockItem SNORT_POTTERY_SHERD = registerDebug("snort_pottery_sherd",
            ModBlocks.SNORT_POTTERY_SHERD);

    public static final DebugBlockItem NETHERITE_UPGRADE = registerDebug("netherite_upgrade",
            ModBlocks.NETHERITE_UPGRADE);
    public static final DebugBlockItem COAST_ARMOR_TRIM = registerDebug("coast_armor_trim",
            ModBlocks.COAST_ARMOR_TRIM);
    public static final DebugBlockItem DUNE_ARMOR_TRIM = registerDebug("dune_armor_trim",
            ModBlocks.DUNE_ARMOR_TRIM);
    public static final DebugBlockItem EYE_ARMOR_TRIM = registerDebug("eye_armor_trim",
            ModBlocks.EYE_ARMOR_TRIM);
    public static final DebugBlockItem HOST_ARMOR_TRIM = registerDebug("host_armor_trim",
            ModBlocks.HOST_ARMOR_TRIM);
    public static final DebugBlockItem RAISER_ARMOR_TRIM = registerDebug("raiser_armor_trim",
            ModBlocks.RAISER_ARMOR_TRIM);
    public static final DebugBlockItem RIB_ARMOR_TRIM = registerDebug("rib_armor_trim",
            ModBlocks.RIB_ARMOR_TRIM);
    public static final DebugBlockItem SENTRY_ARMOR_TRIM = registerDebug("sentry_armor_trim",
            ModBlocks.SENTRY_ARMOR_TRIM);
    public static final DebugBlockItem SHAPER_ARMOR_TRIM = registerDebug("shaper_armor_trim",
            ModBlocks.SHAPER_ARMOR_TRIM);
    public static final DebugBlockItem SILENCE_ARMOR_TRIM = registerDebug("silence_armor_trim",
            ModBlocks.SILENCE_ARMOR_TRIM);
    public static final DebugBlockItem SNOUT_ARMOR_TRIM = registerDebug("snout_armor_trim",
            ModBlocks.SNOUT_ARMOR_TRIM);
    public static final DebugBlockItem SPIRE_ARMOR_TRIM = registerDebug("spire_armor_trim",
            ModBlocks.SPIRE_ARMOR_TRIM);
    public static final DebugBlockItem TIDE_ARMOR_TRIM = registerDebug("tide_armor_trim",
            ModBlocks.TIDE_ARMOR_TRIM);
    public static final DebugBlockItem VEX_ARMOR_TRIM = registerDebug("vex_armor_trim",
            ModBlocks.VEX_ARMOR_TRIM);
    public static final DebugBlockItem WARD_ARMOR_TRIM = registerDebug("ward_armor_trim",
            ModBlocks.WARD_ARMOR_TRIM);
    public static final DebugBlockItem WAYFINDER_ARMOR_TRIM = registerDebug("wayfinder_armor_trim",
            ModBlocks.WAYFINDER_ARMOR_TRIM);
    public static final DebugBlockItem WILD_ARMOR_TRIM = registerDebug("wild_armor_trim",
            ModBlocks.WILD_ARMOR_TRIM);

    public static final DebugBlockItem IRON_INGOT = registerDebug("iron_ingot",
            ModBlocks.IRON_INGOT);
    public static final DebugBlockItem COPPER_INGOT = registerDebug("copper_ingot",
            ModBlocks.COPPER_INGOT);
    public static final DebugBlockItem GOLD_INGOT = registerDebug("gold_ingot",
            ModBlocks.GOLD_INGOT);
    public static final DebugBlockItem NETHERITE_INGOT = registerDebug("netherite_ingot",
            ModBlocks.NETHERITE_INGOT);

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ItemsDisplayed.MOD_ID, name), item);
    }

    private static DebugBlockItem registerDebug(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ItemsDisplayed.MOD_ID, name), new DebugBlockItem(block, new FabricItemSettings()));
    }

    public static void registerItems() {
        ItemsDisplayed.LOGGER.info("Registering items");

        FuelRegistry.INSTANCE.add(ITEM_DISPLAY, 250);
    }
}
