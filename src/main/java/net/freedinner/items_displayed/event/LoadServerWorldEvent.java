package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class LoadServerWorldEvent implements ServerWorldEvents.Load {
    @Override
    public void onWorldLoad(MinecraftServer server, ServerLevel world) {
        BuiltInRegistries.BLOCK.stream().filter(this::fromThisMod).forEach(
                (Block block) -> BlockItemMapper.addEntry(block, getDroppedItem(block, world))
        );
    }

    private boolean fromThisMod(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(ItemsDisplayed.MOD_ID);
    }

    private Item getDroppedItem(Block block, ServerLevel world) {
        return Block.getDrops(block.defaultBlockState(), world, BlockPos.ZERO, null).getFirst().getItem();
    }
}
