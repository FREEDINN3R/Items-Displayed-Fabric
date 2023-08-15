package net.freedinner.items_displayed.util;

import net.freedinner.items_displayed.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.item.trim.ArmorTrimPatterns;
import net.minecraft.registry.RegistryKey;

import java.util.HashMap;
import java.util.Map;

public class BlockAssociations {
    private static Map<Block, Item> stackForBlockMap;
    private static Map<Item, Block> blockForStackMap;
    private static Map<String, Block> blockForStringMap;
    private static Map<RegistryKey<ArmorTrimPattern>, String> stringForPatternMap;
    
    public static ItemStack getStackFor(Block block) {
        if (stackForBlockMap == null) {
            stackForBlockMap = new HashMap<>();
            
            stackForBlockMap.put(ModBlocks.ANGLER_POTTERY_SHERD, Items.ANGLER_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.ARCHER_POTTERY_SHERD, Items.ARCHER_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.ARMS_UP_POTTERY_SHERD, Items.ARMS_UP_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.BLADE_POTTERY_SHERD, Items.BLADE_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.BREWER_POTTERY_SHERD, Items.BREWER_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.BURN_POTTERY_SHERD, Items.BURN_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.DANGER_POTTERY_SHERD, Items.DANGER_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.EXPLORER_POTTERY_SHERD, Items.EXPLORER_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.FRIEND_POTTERY_SHERD, Items.FRIEND_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.HEART_POTTERY_SHERD, Items.HEART_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.HEARTBREAK_POTTERY_SHERD, Items.HEARTBREAK_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.HOWL_POTTERY_SHERD, Items.HOWL_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.MINER_POTTERY_SHERD, Items.MINER_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.MOURNER_POTTERY_SHERD, Items.MOURNER_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.PLENTY_POTTERY_SHERD, Items.PLENTY_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.PRIZE_POTTERY_SHERD, Items.PRIZE_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.SHEAF_POTTERY_SHERD, Items.SHEAF_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.SHELTER_POTTERY_SHERD, Items.SHELTER_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.SKULL_POTTERY_SHERD, Items.SKULL_POTTERY_SHERD);
            stackForBlockMap.put(ModBlocks.SNORT_POTTERY_SHERD, Items.SNORT_POTTERY_SHERD);

            stackForBlockMap.put(ModBlocks.NETHERITE_UPGRADE, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.COAST_ARMOR_TRIM, Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.DUNE_ARMOR_TRIM, Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.EYE_ARMOR_TRIM, Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.HOST_ARMOR_TRIM, Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.RAISER_ARMOR_TRIM, Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.RIB_ARMOR_TRIM, Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.SENTRY_ARMOR_TRIM, Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.SHAPER_ARMOR_TRIM, Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.SILENCE_ARMOR_TRIM, Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.SNOUT_ARMOR_TRIM, Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.SPIRE_ARMOR_TRIM, Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.TIDE_ARMOR_TRIM, Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.VEX_ARMOR_TRIM, Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.WARD_ARMOR_TRIM, Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.WAYFINDER_ARMOR_TRIM, Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE);
            stackForBlockMap.put(ModBlocks.WILD_ARMOR_TRIM, Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE);

            stackForBlockMap.put(ModBlocks.IRON_INGOT, Items.IRON_INGOT);
            stackForBlockMap.put(ModBlocks.COPPER_INGOT, Items.COPPER_INGOT);
            stackForBlockMap.put(ModBlocks.GOLD_INGOT, Items.GOLD_INGOT);
            stackForBlockMap.put(ModBlocks.NETHERITE_INGOT, Items.NETHERITE_INGOT);
        }
        
        return new ItemStack(stackForBlockMap.getOrDefault(block, Items.AIR));
    }

    public static Block getBlockFor(ItemStack stack) {
        if (blockForStackMap == null) {
            blockForStackMap = new HashMap<>();

            blockForStackMap.put(Items.ANGLER_POTTERY_SHERD, ModBlocks.ANGLER_POTTERY_SHERD);
            blockForStackMap.put(Items.ARCHER_POTTERY_SHERD, ModBlocks.ARCHER_POTTERY_SHERD);
            blockForStackMap.put(Items.ARMS_UP_POTTERY_SHERD, ModBlocks.ARMS_UP_POTTERY_SHERD);
            blockForStackMap.put(Items.BLADE_POTTERY_SHERD, ModBlocks.BLADE_POTTERY_SHERD);
            blockForStackMap.put(Items.BREWER_POTTERY_SHERD, ModBlocks.BREWER_POTTERY_SHERD);
            blockForStackMap.put(Items.BURN_POTTERY_SHERD, ModBlocks.BURN_POTTERY_SHERD);
            blockForStackMap.put(Items.DANGER_POTTERY_SHERD, ModBlocks.DANGER_POTTERY_SHERD);
            blockForStackMap.put(Items.EXPLORER_POTTERY_SHERD, ModBlocks.EXPLORER_POTTERY_SHERD);
            blockForStackMap.put(Items.FRIEND_POTTERY_SHERD, ModBlocks.FRIEND_POTTERY_SHERD);
            blockForStackMap.put(Items.HEART_POTTERY_SHERD, ModBlocks.HEART_POTTERY_SHERD);
            blockForStackMap.put(Items.HEARTBREAK_POTTERY_SHERD, ModBlocks.HEARTBREAK_POTTERY_SHERD);
            blockForStackMap.put(Items.HOWL_POTTERY_SHERD, ModBlocks.HOWL_POTTERY_SHERD);
            blockForStackMap.put(Items.MINER_POTTERY_SHERD, ModBlocks.MINER_POTTERY_SHERD);
            blockForStackMap.put(Items.MOURNER_POTTERY_SHERD, ModBlocks.MOURNER_POTTERY_SHERD);
            blockForStackMap.put(Items.PLENTY_POTTERY_SHERD, ModBlocks.PLENTY_POTTERY_SHERD);
            blockForStackMap.put(Items.PRIZE_POTTERY_SHERD, ModBlocks.PRIZE_POTTERY_SHERD);
            blockForStackMap.put(Items.SHEAF_POTTERY_SHERD, ModBlocks.SHEAF_POTTERY_SHERD);
            blockForStackMap.put(Items.SHELTER_POTTERY_SHERD, ModBlocks.SHELTER_POTTERY_SHERD);
            blockForStackMap.put(Items.SKULL_POTTERY_SHERD, ModBlocks.SKULL_POTTERY_SHERD);
            blockForStackMap.put(Items.SNORT_POTTERY_SHERD, ModBlocks.SNORT_POTTERY_SHERD);

            blockForStackMap.put(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModBlocks.NETHERITE_UPGRADE);
            blockForStackMap.put(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.COAST_ARMOR_TRIM);
            blockForStackMap.put(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.DUNE_ARMOR_TRIM);
            blockForStackMap.put(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.EYE_ARMOR_TRIM);
            blockForStackMap.put(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.HOST_ARMOR_TRIM);
            blockForStackMap.put(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.RAISER_ARMOR_TRIM);
            blockForStackMap.put(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.RIB_ARMOR_TRIM);
            blockForStackMap.put(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SENTRY_ARMOR_TRIM);
            blockForStackMap.put(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SHAPER_ARMOR_TRIM);
            blockForStackMap.put(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SILENCE_ARMOR_TRIM);
            blockForStackMap.put(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SNOUT_ARMOR_TRIM);
            blockForStackMap.put(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.SPIRE_ARMOR_TRIM);
            blockForStackMap.put(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.TIDE_ARMOR_TRIM);
            blockForStackMap.put(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.VEX_ARMOR_TRIM);
            blockForStackMap.put(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.WARD_ARMOR_TRIM);
            blockForStackMap.put(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.WAYFINDER_ARMOR_TRIM);
            blockForStackMap.put(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.WILD_ARMOR_TRIM);
        }

        return blockForStackMap.getOrDefault(stack.getItem(), Blocks.AIR);
    }

    public static Block getBlockFor(String s) {
        if (blockForStringMap == null) {
            blockForStringMap = new HashMap<>();

            blockForStringMap.put("angler_pottery_sherd", ModBlocks.ANGLER_POTTERY_SHERD);
            blockForStringMap.put("archer_pottery_sherd", ModBlocks.ARCHER_POTTERY_SHERD);
            blockForStringMap.put("arms_up_pottery_sherd", ModBlocks.ARMS_UP_POTTERY_SHERD);
            blockForStringMap.put("blade_pottery_sherd", ModBlocks.BLADE_POTTERY_SHERD);
            blockForStringMap.put("brewer_pottery_sherd", ModBlocks.BREWER_POTTERY_SHERD);
            blockForStringMap.put("burn_pottery_sherd", ModBlocks.BURN_POTTERY_SHERD);
            blockForStringMap.put("danger_pottery_sherd", ModBlocks.DANGER_POTTERY_SHERD);
            blockForStringMap.put("explorer_pottery_sherd", ModBlocks.EXPLORER_POTTERY_SHERD);
            blockForStringMap.put("friend_pottery_sherd", ModBlocks.FRIEND_POTTERY_SHERD);
            blockForStringMap.put("heart_pottery_sherd", ModBlocks.HEART_POTTERY_SHERD);
            blockForStringMap.put("heartbreak_pottery_sherd", ModBlocks.HEARTBREAK_POTTERY_SHERD);
            blockForStringMap.put("howl_pottery_sherd", ModBlocks.HOWL_POTTERY_SHERD);
            blockForStringMap.put("miner_pottery_sherd", ModBlocks.MINER_POTTERY_SHERD);
            blockForStringMap.put("mourner_pottery_sherd", ModBlocks.MOURNER_POTTERY_SHERD);
            blockForStringMap.put("plenty_pottery_sherd", ModBlocks.PLENTY_POTTERY_SHERD);
            blockForStringMap.put("prize_pottery_sherd", ModBlocks.PRIZE_POTTERY_SHERD);
            blockForStringMap.put("sheaf_pottery_sherd", ModBlocks.SHEAF_POTTERY_SHERD);
            blockForStringMap.put("shelter_pottery_sherd", ModBlocks.SHELTER_POTTERY_SHERD);
            blockForStringMap.put("skull_pottery_sherd", ModBlocks.SKULL_POTTERY_SHERD);
            blockForStringMap.put("snort_pottery_sherd", ModBlocks.SNORT_POTTERY_SHERD);

            blockForStringMap.put("netherite_upgrade", ModBlocks.NETHERITE_UPGRADE);
            blockForStringMap.put("coast_armor_trim", ModBlocks.COAST_ARMOR_TRIM);
            blockForStringMap.put("dune_armor_trim", ModBlocks.DUNE_ARMOR_TRIM);
            blockForStringMap.put("eye_armor_trim", ModBlocks.EYE_ARMOR_TRIM);
            blockForStringMap.put("host_armor_trim", ModBlocks.HOST_ARMOR_TRIM);
            blockForStringMap.put("raiser_armor_trim", ModBlocks.RAISER_ARMOR_TRIM);
            blockForStringMap.put("rib_armor_trim", ModBlocks.RIB_ARMOR_TRIM);
            blockForStringMap.put("sentry_armor_trim", ModBlocks.SENTRY_ARMOR_TRIM);
            blockForStringMap.put("shaper_armor_trim", ModBlocks.SHAPER_ARMOR_TRIM);
            blockForStringMap.put("silence_armor_trim", ModBlocks.SILENCE_ARMOR_TRIM);
            blockForStringMap.put("snout_armor_trim", ModBlocks.SNOUT_ARMOR_TRIM);
            blockForStringMap.put("spire_armor_trim", ModBlocks.SPIRE_ARMOR_TRIM);
            blockForStringMap.put("tide_armor_trim", ModBlocks.TIDE_ARMOR_TRIM);
            blockForStringMap.put("vex_armor_trim", ModBlocks.VEX_ARMOR_TRIM);
            blockForStringMap.put("ward_armor_trim", ModBlocks.WARD_ARMOR_TRIM);
            blockForStringMap.put("wayfinder_armor_trim", ModBlocks.WAYFINDER_ARMOR_TRIM);
            blockForStringMap.put("wild_armor_trim", ModBlocks.WILD_ARMOR_TRIM);

            blockForStringMap.put("iron_ingot", ModBlocks.IRON_INGOT);
            blockForStringMap.put("copper_ingot", ModBlocks.COPPER_INGOT);
            blockForStringMap.put("gold_ingot", ModBlocks.GOLD_INGOT);
            blockForStringMap.put("netherite_ingot", ModBlocks.NETHERITE_INGOT);
        }

        return blockForStringMap.getOrDefault(s, Blocks.AIR);
    }

    public static String getStringFor(RegistryKey<ArmorTrimPattern> trimPattern) {
        if (stringForPatternMap == null) {
            stringForPatternMap = new HashMap<>();

            stringForPatternMap.put(ArmorTrimPatterns.COAST, "coast_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.DUNE, "dune_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.EYE, "eye_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.HOST, "host_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.RAISER, "raiser_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.RIB, "rib_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.SENTRY, "sentry_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.SHAPER, "shaper_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.SILENCE, "silence_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.SNOUT, "snout_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.SPIRE, "spire_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.TIDE, "tide_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.VEX, "vex_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.WARD, "ward_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.WAYFINDER, "wayfinder_armor_trim");
            stringForPatternMap.put(ArmorTrimPatterns.WILD, "wild_armor_trim");
        }

        return stringForPatternMap.getOrDefault(trimPattern, "");
    }
}
