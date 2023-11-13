package net.freedinner.items_displayed.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.freedinner.items_displayed.config.ModConfigs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Collectors;

public class BlockItemMapper {
    private static BiMap<Block, Item> blockItemMap = HashBiMap.create();

    public static void addEntry(Block block, Item item) {
        blockItemMap.put(block, item);
    }

    public static void writeDataToPacket(PacketByteBuf packet) {
        PacketByteBuf.PacketWriter<Block> blockWriter = (buf, block) -> buf.writeIdentifier(Registries.BLOCK.getId(block));
        PacketByteBuf.PacketWriter<Item> itemWriter = (buf, item) -> buf.writeIdentifier(Registries.ITEM.getId(item));

        packet.writeMap(blockItemMap, blockWriter, itemWriter);
    }

    public static void loadDataFromPacket(PacketByteBuf packet) {
        PacketByteBuf.PacketReader<Block> blockReader = (buf) -> Registries.BLOCK.get(buf.readIdentifier());
        PacketByteBuf.PacketReader<Item> itemReader = (buf) -> Registries.ITEM.get(buf.readIdentifier());

        blockItemMap = HashBiMap.create(packet.readMap(blockReader, itemReader));
    }

    public static Item getItemOrNull(Block block) {
        return getItemOrNull(block, false);
    }

    public static Item getItemOrNull(Block block, boolean includeBlacklisted) {
        Item foundItem = blockItemMap.getOrDefault(block, null);

        if (isItemBlacklisted(foundItem) && !includeBlacklisted) {
            return null;
        }

        return foundItem;
    }

    public static Block getBlockOrNull(Item item) {
        return getBlockOrNull(item, false);
    }

    public static Block getBlockOrNull(Item item, boolean includeBlacklisted) {
        if (isItemBlacklisted(item) && !includeBlacklisted) {
            return null;
        }

        return blockItemMap.inverse().getOrDefault(item, null);
    }

    public static boolean isItemBlacklisted(Item item) {
        String itemId = Registries.ITEM.getId(item).toString();
        return ModConfigs.BLACKLISTED_ITEMS.contains(itemId);
    }
}