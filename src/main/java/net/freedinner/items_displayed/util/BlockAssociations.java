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
    private static Map<RegistryKey<ArmorTrimPattern>, Block> blockForPatternMap;
    
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

    public static Block getBlockFor(RegistryKey<ArmorTrimPattern> trimPattern) {
        if (blockForPatternMap == null) {
            blockForPatternMap = new HashMap<>();

            blockForPatternMap.put(ArmorTrimPatterns.COAST, ModBlocks.COAST_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.DUNE, ModBlocks.DUNE_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.EYE, ModBlocks.EYE_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.HOST, ModBlocks.HOST_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.RAISER, ModBlocks.RAISER_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.RIB, ModBlocks.RIB_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.SENTRY, ModBlocks.SENTRY_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.SHAPER, ModBlocks.SHAPER_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.SILENCE, ModBlocks.SILENCE_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.SNOUT, ModBlocks.SNOUT_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.SPIRE, ModBlocks.SPIRE_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.TIDE, ModBlocks.TIDE_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.VEX, ModBlocks.VEX_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.WARD, ModBlocks.WARD_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.WAYFINDER, ModBlocks.WAYFINDER_ARMOR_TRIM);
            blockForPatternMap.put(ArmorTrimPatterns.WILD, ModBlocks.WILD_ARMOR_TRIM);
        }

        return blockForPatternMap.getOrDefault(trimPattern, Blocks.AIR);
    }
}
