package net.freedinner.items_displayed.util;

import net.freedinner.items_displayed.config.ModConfigs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;

import java.util.HashMap;
import java.util.Map;

public class BlockItemMapper {
    private static final Map<Block, Item> itemForBlockMap = new HashMap<>();
    private static final Map<Item, Block> blockForItemMap = new HashMap<>();

    private static final Map<Block, Item> itemForBlockMapBlacklisted = new HashMap<>();
    private static final Map<Item, Block> blockForItemMapBlacklisted = new HashMap<>();

    public static void tryAddEntry(Block block, Item item) {
        String itemId = Registries.ITEM.getId(item).toString();

        if (ModConfigs.BLACKLISTED_ITEMS.contains(itemId)) {
            itemForBlockMapBlacklisted.put(block, item);
            blockForItemMapBlacklisted.put(item, block);
            return;
        }

        itemForBlockMap.put(block, item);
        blockForItemMap.put(item, block);
    }

    public static boolean hasEntryFor(Block block) {
        return itemForBlockMap.containsKey(block);
    }

    public static boolean hasEntryFor(Item item) {
        return blockForItemMap.containsKey(item);
    }

    public static Item getItemOrNull(Block block) {
        return getItemOrNull(block, false);
    }

    public static Block getBlockOrNull(Item item) {
        return getBlockOrNull(item, false);
    }

    public static Item getItemOrNull(Block block, boolean includeBlacklisted) {
        Item foundItem = itemForBlockMap.getOrDefault(block, null);

        if (foundItem != null || !includeBlacklisted) {
            return foundItem;
        }

        return itemForBlockMapBlacklisted.getOrDefault(block, null);
    }

    public static Block getBlockOrNull(Item item, boolean includeBlacklisted) {
        Block foundBlock = blockForItemMap.getOrDefault(item, null);

        if (foundBlock != null || !includeBlacklisted) {
            return foundBlock;
        }

        return blockForItemMapBlacklisted.getOrDefault(item, null);
    }
}
