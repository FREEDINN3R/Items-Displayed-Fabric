package net.freedinner.items_displayed.block.custom.stackable;

import net.freedinner.items_displayed.block.custom.AbstractItemBlock;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.freedinner.items_displayed.util.BlockPlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public abstract class AbstractStackableItemBlock extends AbstractItemBlock {
    public AbstractStackableItemBlock(Properties settings) {
        super(settings);
        registerDefaultState(defaultBlockState()
                .setValue(getItemProperty(), 1));
    }
    
    protected abstract IntegerProperty getItemProperty();

    private int getMaxItemCount() {
        return getItemProperty().getPossibleValues().size();
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!player.isSecondaryUseActive() && shouldAddItem(player.getItemInHand(hand), state)) {
            InteractionResult result = BlockPlacer.place(state.getBlock(), player, hand, hit);

            if (result.consumesAction()) {
                return ItemInteractionResult.CONSUME;
            }
            else {
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        }

        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (!context.isSecondaryUseActive() && shouldAddItem(context.getItemInHand(), state)) {
            return true;
        }

        return super.canBeReplaced(state, context);
    }

    private boolean shouldAddItem(ItemStack heldItemStack, BlockState state) {
        boolean sameItem = heldItemStack.is(BlockItemMapper.getItemOrNull(state.getBlock()));
        return sameItem && state.getValue(getItemProperty()) < getMaxItemCount();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = ctx.getLevel().getBlockState(ctx.getClickedPos());
        if (blockState.is(this)) {
            return blockState.cycle(getItemProperty());
        }

        return super.getStateForPlacement(ctx);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(getItemProperty());
    }
}
