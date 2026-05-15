package net.freedinner.items_displayed.networking;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public record S2CLoadMapsPacket(BiMap<Block, Item> blockItemMap) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<S2CLoadMapsPacket> ID = new CustomPacketPayload.Type<>(ItemsDisplayed.id("client_load_maps"));
    public static final StreamCodec<RegistryFriendlyByteBuf, S2CLoadMapsPacket> CODEC = CustomPacketPayload.codec(
            S2CLoadMapsPacket::write,
            S2CLoadMapsPacket::new
    );

    public S2CLoadMapsPacket(RegistryFriendlyByteBuf buf){
        this(MapWriter.readMapFromPacket(buf));
    }

    public void write(RegistryFriendlyByteBuf buf){
        MapWriter.writeMapToPacket(blockItemMap, buf);
    }

    public static void send(ServerPlayer player, BiMap<Block, Item> blockItemMap) {
        ServerPlayNetworking.send(player, new S2CLoadMapsPacket(blockItemMap));
    }

    public static void receive(S2CLoadMapsPacket packet, ClientPlayNetworking.Context context) {
        context.client().execute(() -> BlockItemMapper.setBlockItemMap(packet.blockItemMap));
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }

    public static class MapWriter {
        public static void writeMapToPacket(BiMap<Block, Item> map, FriendlyByteBuf packet) {
            packet.writeInt(map.size());

            map.forEach((key, value) -> {
                Identifier blockId = BuiltInRegistries.BLOCK.getKey(key);
                packet.writeIdentifier(blockId);

                Identifier itemId = BuiltInRegistries.ITEM.getKey(value);
                packet.writeIdentifier(itemId);
            });
        }

        public static BiMap<Block, Item> readMapFromPacket(FriendlyByteBuf packet) {
            BiMap<Block, Item> map = HashBiMap.create();
            int size = packet.readInt();

            for (int i = 0; i < size; i++) {
                Identifier blockId = packet.readIdentifier();
                Block block = BuiltInRegistries.BLOCK.getValue(blockId);

                Identifier itemId = packet.readIdentifier();
                Item item = BuiltInRegistries.ITEM.getValue(itemId);

                map.put(block, item);
            }

            return map;
        }
    }
}
