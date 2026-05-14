package net.freedinner.items_displayed.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

public class BlockPlacer {
    public static InteractionResult place(Block block, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (player.level().isClientSide() || !player.getAbilities().mayBuild) {
            return InteractionResult.PASS;
        }

        BlockItem blockItem = (BlockItem) block.asItem();
        BlockPlaceContext placementContext = new BlockPlaceContext(player, hand, player.getItemInHand(hand), hitResult);

        InteractionResult result = blockItem.place(placementContext);

        if (result.consumesAction()) {
            player.swing(hand, true);

            SoundEvent sound = block.defaultBlockState().getSoundType().getPlaceSound();
            float pitch = player.level().getRandom().nextFloat() * 0.1f + 0.9f;
            player.level().playSound(null, placementContext.getClickedPos(), sound, SoundSource.BLOCKS, 1.0f, pitch);
        }

        return result;
    }
}
