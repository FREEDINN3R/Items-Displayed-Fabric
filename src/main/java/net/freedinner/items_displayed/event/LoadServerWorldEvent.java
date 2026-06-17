package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLevelEvents;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class LoadServerWorldEvent implements ServerLevelEvents.Load {

    @Override
    public void onLevelLoad(MinecraftServer server, ServerLevel level) {
        BuiltInRegistries.BLOCK.stream().filter(this::fromThisMod).forEach(
                (Block block) -> BlockItemMapper.addEntry(block, getDroppedItem(block, level))
        );
    }
    private boolean fromThisMod(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(ItemsDisplayed.MOD_ID);
    }

    private Item getDroppedItem(Block block, ServerLevel world) {
        return Block.getDrops(block.defaultBlockState(), world, BlockPos.ZERO, null).getFirst().getItem();
    }
}
