package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.freedinner.items_displayed.util.BlockPlacer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

public class UseBlockEvent implements UseBlockCallback {
    @Override
    public InteractionResult interact(Player player, Level world, InteractionHand hand, BlockHitResult hitResult) {
        if (world.isClientSide || !player.isShiftKeyDown()) {
            return InteractionResult.PASS;
        }

        ItemStack heldItemStack = player.getItemInHand(hand);
        Block block = BlockItemMapper.getBlockOrNull(heldItemStack.getItem());

        if (block == null) {
            return InteractionResult.PASS;
        }

        return BlockPlacer.place(block, player, hand, hitResult);
    }
}