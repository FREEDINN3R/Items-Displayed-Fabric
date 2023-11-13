package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.freedinner.items_displayed.util.BlockPlacer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class UseBlockEvent implements UseBlockCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if (world.isClient || !player.isSneaking()) {
            return ActionResult.PASS;
        }

        ItemStack heldItemStack = player.getStackInHand(hand);
        Block block = BlockItemMapper.getBlockOrNull(heldItemStack.getItem());

        if (block == null) {
            return ActionResult.PASS;
        }

        return BlockPlacer.place(block, player, hand, hitResult);
    }
}