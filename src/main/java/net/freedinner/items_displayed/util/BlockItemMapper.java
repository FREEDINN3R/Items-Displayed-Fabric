package net.freedinner.items_displayed.util;

import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.config.ModConfigs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;

import java.util.*;
import java.util.stream.Collectors;

public class BlockItemMapper {
    private static Map<Block, Item> itemForBlockMap = new HashMap<>();
    private static Map<Item, Block> blockForItemMap = new HashMap<>();

    private static List<Item> blacklistedItems = new ArrayList<>();

    public static void addEntry(Block block, Item item) {
        itemForBlockMap.put(block, item);
        blockForItemMap.put(item, block);

        String itemId = Registries.ITEM.getId(item).toString();
        if (ModConfigs.BLACKLISTED_ITEMS.contains(itemId)) {
            blacklistedItems.add(item);
        }
    }

    public static void writeDataToPacket(PacketByteBuf packet) {
        PacketByteBuf.PacketWriter<Block> blockWriter = (buf, block) -> buf.writeIdentifier(Registries.BLOCK.getId(block));
        PacketByteBuf.PacketWriter<Item> itemWriter = (buf, item) -> buf.writeIdentifier(Registries.ITEM.getId(item));

        PacketByteBuf.PacketWriter<Map.Entry<Block, Item>> entryWriter = (buf, blockItemEntry) -> {
            blockWriter.accept(buf, blockItemEntry.getKey());
            itemWriter.accept(buf, blockItemEntry.getValue());
        };

        packet.writeCollection(itemForBlockMap.entrySet(), entryWriter);
        packet.writeCollection(blacklistedItems, itemWriter);
    }

    public static void loadDataFromPacket(PacketByteBuf packet) {
        PacketByteBuf.PacketReader<Block> blockReader = (buf) -> Registries.BLOCK.get(buf.readIdentifier());
        PacketByteBuf.PacketReader<Item> itemReader = (buf) -> Registries.ITEM.get(buf.readIdentifier());

        PacketByteBuf.PacketReader<Map.Entry<Block, Item>> entryReader =
                (buf) -> Map.entry(blockReader.apply(buf), itemReader.apply(buf));


        itemForBlockMap = new HashMap<>();
        for(Map.Entry<Block, Item> entry : packet.readCollection(HashSet::new, entryReader)) {
            itemForBlockMap.put(entry.getKey(), entry.getValue());
        }
        blockForItemMap = itemForBlockMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        blacklistedItems = packet.readList(itemReader);
    }

    public static Item getItemOrNull(Block block) {
        return getItemOrNull(block, false);
    }

    public static Block getBlockOrNull(Item item) {
        return getBlockOrNull(item, false);
    }

    public static Item getItemOrNull(Block block, boolean includeBlacklisted) {
        Item foundItem = itemForBlockMap.getOrDefault(block, null);

        if (blacklistedItems.contains(foundItem) && !includeBlacklisted) {
            return null;
        }

        return foundItem;
    }

    public static Block getBlockOrNull(Item item, boolean includeBlacklisted) {
        if (blacklistedItems.contains(item) && !includeBlacklisted) {
            return null;
        }

        return blockForItemMap.getOrDefault(item, null);
    }
}