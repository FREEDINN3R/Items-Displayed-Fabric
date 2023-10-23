package net.freedinner.items_displayed.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.HashMap;
import java.util.Map;

public class BlockItemMapper {
    private static final Map<Block, Item> itemForBlockMap = new HashMap<>();
    private static final Map<Item, Block> blockForItemMap = new HashMap<>();

    public static void tryAddEntry(Block block, Item item) {
        if (!itemForBlockMap.containsKey(block)) {
            itemForBlockMap.put(block, item);
            blockForItemMap.put(item, block);
        }
    }

    public static boolean hasEntryFor(Block block) {
        return itemForBlockMap.containsKey(block);
    }

    public static boolean hasEntryFor(Item item) {
        return blockForItemMap.containsKey(item);
    }

    public static Item getItemOrNull(Block block) {
        return itemForBlockMap.getOrDefault(block, null);
    }

    public static Block getBlockOrNull(ItemStack itemStack) {
        return getBlockOrNull(itemStack.getItem());
    }

    public static Block getBlockOrNull(Item item) {
        return blockForItemMap.getOrDefault(item, null);
    }
}
