package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameter;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ServerWorldLoadHandler implements ServerWorldEvents.Load {
    @Override
    public void onWorldLoad(MinecraftServer server, ServerWorld world) {
        Registries.BLOCK.stream().filter(
                (Block block) -> Registries.BLOCK.getId(block).getNamespace().equals(ItemsDisplayed.MOD_ID)
        ).forEach(
                (Block block) -> {
                    LootContextParameterSet.Builder builder = new LootContextParameterSet.Builder(world)
                            .add(LootContextParameters.TOOL, ItemStack.EMPTY)
                            .add(LootContextParameters.ORIGIN, Vec3d.ZERO);
                    Item item = block.getDefaultState().getDroppedStacks(builder).get(0).getItem();
                    BlockItemMapper.tryAddEntry(block, item);
                }
        );
    }
}
