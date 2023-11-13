package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.freedinner.items_displayed.block.ModBlocks;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.freedinner.items_displayed.util.BlockPlacer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class UseBlockHandler implements UseBlockCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if (world.isClient || hitResult.getType().equals(HitResult.Type.MISS) || !player.isSneaking()) {
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