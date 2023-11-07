package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.networking.NetworkingConstants;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.block.Block;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;

public class ServerJoinHandler implements ServerPlayConnectionEvents.Join {
    @Override
    public void onPlayReady(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server) {
        ItemsDisplayed.LOGGER.info("player joined the server");

        PacketByteBuf buf = PacketByteBufs.create();
        BlockItemMapper.writeDataToPacket(buf);

        ServerPlayNetworking.send(handler.getPlayer(), NetworkingConstants.CLIENT_LOAD_ASSOCIATIONS_ID, buf);
    }
}