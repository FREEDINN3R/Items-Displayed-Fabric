package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class ServerWorldLoadHandler implements ServerWorldEvents.Load {
    @Override
    public void onWorldLoad(MinecraftServer server, ServerWorld world) {
        Registries.BLOCK.stream().filter(
                (Block block) -> Registries.BLOCK.getId(block).getNamespace().equals(ItemsDisplayed.MOD_ID)
        ).forEach(
                (Block block) -> {
                    Item item = Block.getDroppedStacks(block.getDefaultState(), world, BlockPos.ORIGIN, null).get(0).getItem();
                    BlockItemMapper.addEntry(block, item);
                }
        );
    }
}
