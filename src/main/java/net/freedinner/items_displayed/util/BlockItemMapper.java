package net.freedinner.items_displayed.util;

import net.freedinner.items_displayed.block.ModBlocks;
import net.freedinner.items_displayed.config.ModConfigs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;

import java.util.HashMap;
import java.util.Map;

public class BlockItemMapper {
    private static Map<Block, Item> itemForBlockMap;
    private static Map<Item, Block> blockForItemMap;

    public static Item getItemOrNull(Block block) {
        return getItemOrNull(block, false);
    }

    public static Item getItemOrNull(Block block, boolean includeBlacklisted) {
        if (itemForBlockMap == null) {
            itemForBlockMap = new HashMap<>();

            itemForBlockMap.put(ModBlocks.ANGLER_POTTERY_SHERD, Items.ANGLER_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.ARCHER_POTTERY_SHERD, Items.ARCHER_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.ARMS_UP_POTTERY_SHERD, Items.ARMS_UP_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.BLADE_POTTERY_SHERD, Items.BLADE_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.BREWER_POTTERY_SHERD, Items.BREWER_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.BURN_POTTERY_SHERD, Items.BURN_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.DANGER_POTTERY_SHERD, Items.DANGER_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.EXPLORER_POTTERY_SHERD, Items.EXPLORER_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.FRIEND_POTTERY_SHERD, Items.FRIEND_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.HEART_POTTERY_SHERD, Items.HEART_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.HEARTBREAK_POTTERY_SHERD, Items.HEARTBREAK_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.HOWL_POTTERY_SHERD, Items.HOWL_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.MINER_POTTERY_SHERD, Items.MINER_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.MOURNER_POTTERY_SHERD, Items.MOURNER_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.PLENTY_POTTERY_SHERD, Items.PLENTY_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.PRIZE_POTTERY_SHERD, Items.PRIZE_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.SHEAF_POTTERY_SHERD, Items.SHEAF_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.SHELTER_POTTERY_SHERD, Items.SHELTER_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.SKULL_POTTERY_SHERD, Items.SKULL_POTTERY_SHERD);
            itemForBlockMap.put(ModBlocks.SNORT_POTTERY_SHERD, Items.SNORT_POTTERY_SHERD);

            itemForBlockMap.put(ModBlocks.NETHERITE_UPGRADE, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.COAST_ARMOR_TRIM, Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.DUNE_ARMOR_TRIM, Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.EYE_ARMOR_TRIM, Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.HOST_ARMOR_TRIM, Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.RAISER_ARMOR_TRIM, Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.RIB_ARMOR_TRIM, Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.SENTRY_ARMOR_TRIM, Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.SHAPER_ARMOR_TRIM, Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.SILENCE_ARMOR_TRIM, Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.SNOUT_ARMOR_TRIM, Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.SPIRE_ARMOR_TRIM, Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.TIDE_ARMOR_TRIM, Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.VEX_ARMOR_TRIM, Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.WARD_ARMOR_TRIM, Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.WAYFINDER_ARMOR_TRIM, Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE);
            itemForBlockMap.put(ModBlocks.WILD_ARMOR_TRIM, Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE);

            itemForBlockMap.put(ModBlocks.IRON_INGOT, Items.IRON_INGOT);
            itemForBlockMap.put(ModBlocks.COPPER_INGOT, Items.COPPER_INGOT);
            itemForBlockMap.put(ModBlocks.GOLD_INGOT, Items.GOLD_INGOT);
            itemForBlockMap.put(ModBlocks.NETHERITE_INGOT, Items.NETHERITE_INGOT);

            itemForBlockMap.put(ModBlocks.DIAMOND, Items.DIAMOND);
            itemForBlockMap.put(ModBlocks.EMERALD, Items.EMERALD);
            itemForBlockMap.put(ModBlocks.LAPIS_LAZULI, Items.LAPIS_LAZULI);
        }

        Item foundItem = itemForBlockMap.getOrDefault(block, null);

        if (ModConfigs.BLACKLISTED_ITEMS.contains(Registries.ITEM.getId(foundItem).toString()) && !includeBlacklisted) {
            return null;
        }

        return foundItem;
    }

    public static Block getBlockOrNull(Item item) {
        return getBlockOrNull(item, false);
    }

    public static Block getBlockOrNull(Item item, boolean includeBlacklisted) {
        if (blockForItemMap == null) {
            blockForItemMap = new HashMap<>();

            blockForItemMap.put(Items.ANGLER_POTTERY_SHERD, ModBlocks.ANGLER_POTTERY_SHERD);
            blockForItemMap.put(Items.ARCHER_POTTERY_SHERD, ModBlocks.ARCHER_POTTERY_SHERD);
            blockForItemMap.put(Items.ARMS_UP_POTTERY_SHERD, ModBlocks.ARMS_UP_POTTERY_SHERD);
            blockForItemMap.put(Items.BLADE_POTTERY_SHERD, ModBlocks.BLADE_POTTERY_SHERD);
            blockForItemMap.put(Items.BREWER_POTTERY_SHERD, ModBlocks.BREWER_POTTERY_SHERD);
            blockForItemMap.put(Items.BURN_POTTERY_SHERD, ModBlocks.BURN_POTTERY_SHERD);
            blockForItemMap.put(Items.DANGER_POTTERY_SHERD, ModBlocks.DANGER_POTTERY_SHERD);
            blockForItemMap.put(Items.EXPLORER_POTTERY_SHERD, ModBlocks.EXPLORER_POTTERY_SHERD);
            blockForItemMap.put(Items.FRIEND_POTTERY_SHERD, ModBlocks.FRIEND_POTTERY_SHERD);
            blockForItemMap.put(Items.HEART_POTTERY_SHERD, ModBlocks.HEART_POTTERY_SHERD);
            blockForItemMap.put(Items.HEARTBREAK_POTTERY_SHERD, ModBlocks.HEARTBREAK_POTTERY_SHERD);
            blockForItemMap.put(Items.HOWL_POTTERY_SHERD, ModBlocks.HOWL_POTTERY_SHERD);
            blockForItemMap.put(Items.MINER_POTTERY_SHERD, ModBlocks.MINER_POTTERY_SHERD);
            blockForItemMap.put(Items.MOURNER_POTTERY_SHERD, ModBlocks.MOURNER_POTTERY_SHERD);
            blockForItemMap.put(Items.PLENTY_POTTERY_SHERD, ModBlocks.PLENTY_POTTERY_SHERD);
            blockForItemMap.put(Items.PRIZE_POTTERY_SHERD, ModBlocks.PRIZE_POTTERY_SHERD);
            blockForItemMap.put(Items.SHEAF_POTTERY_SHERD, ModBlocks.SHEAF_POTTERY_SHERD);
            blockForItemMap.put(Items.SHELTER_POTTERY_SHERD, ModBlocks.SHELTER_POTTERY_SHERD);
            blockForItemMap.put(Items.SKULL_POTTERY_SHERD, ModBlocks.SKULL_POTTERY_SHERD);
            blockForItemMap.put(Items.SNORT_POTTERY_SHERD, ModBlocks.SNORT_POTTERY_SHERD);

            blockForItemMap.put(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModBlocks.NETHERITE_UPGRADE);
            blockForItemMap.put(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.COAST_ARMOR_TRIM);
            blockForItemMap.put(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.DUNE_ARMOR_TRIM);
            blockForItemMap.put(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.EYE_ARMOR_TRIM);
            blockForItemMap.put(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.HOST_ARMOR_TRIM);
            blockForItemMap.put(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.RAISER_ARMOR_TRIM);
            blockForItemMap.put(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.RIB_ARMOR_TRIM);
            blockForItemMap.put(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SENTRY_ARMOR_TRIM);
            blockForItemMap.put(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SHAPER_ARMOR_TRIM);
            blockForItemMap.put(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SILENCE_ARMOR_TRIM);
            blockForItemMap.put(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SNOUT_ARMOR_TRIM);
            blockForItemMap.put(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SPIRE_ARMOR_TRIM);
            blockForItemMap.put(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.TIDE_ARMOR_TRIM);
            blockForItemMap.put(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.VEX_ARMOR_TRIM);
            blockForItemMap.put(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.WARD_ARMOR_TRIM);
            blockForItemMap.put(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.WAYFINDER_ARMOR_TRIM);
            blockForItemMap.put(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.WILD_ARMOR_TRIM);

            blockForItemMap.put(Items.COPPER_INGOT, ModBlocks.COPPER_INGOT);
            blockForItemMap.put(Items.IRON_INGOT, ModBlocks.IRON_INGOT);
            blockForItemMap.put(Items.GOLD_INGOT, ModBlocks.GOLD_INGOT);
            blockForItemMap.put(Items.NETHERITE_INGOT, ModBlocks.NETHERITE_INGOT);

            blockForItemMap.put(Items.DIAMOND, ModBlocks.DIAMOND);
            blockForItemMap.put(Items.EMERALD, ModBlocks.EMERALD);
            blockForItemMap.put(Items.LAPIS_LAZULI, ModBlocks.LAPIS_LAZULI);
        }

        if (ModConfigs.BLACKLISTED_ITEMS.contains(Registries.ITEM.getId(item).toString()) && !includeBlacklisted) {
            return null;
        }

        return blockForItemMap.getOrDefault(item, null);
    }
}