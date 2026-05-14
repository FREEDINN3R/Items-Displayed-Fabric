package net.freedinner.items_displayed.block.custom.stackable;

import com.mojang.serialization.MapCodec;
import net.freedinner.items_displayed.block.custom.AbstractItemBlock;
import net.freedinner.items_displayed.util.ModProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DiscFragmentItemBlock extends AbstractStackableItemBlock {
    public static final VoxelShape SHAPE =
            Block.box(2.0, 0.0, 2.0, 14.0, 1.0, 14.0);

    private static final MapCodec<? extends HorizontalDirectionalBlock> CODEC = AbstractItemBlock.simpleCodec(DiscFragmentItemBlock::new);

    public DiscFragmentItemBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected IntegerProperty getItemProperty() {
        return ModProperties.FRAGMENTS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
