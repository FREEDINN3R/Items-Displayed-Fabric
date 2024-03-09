package net.freedinner.items_displayed.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class SherdBlock extends AbstractItemBlock implements Waterloggable {
    public static final VoxelShape SHAPE =
            Block.createCuboidShape(1, 0, 1, 15, 2, 15);

    private static final MapCodec<? extends HorizontalFacingBlock> CODEC = AbstractItemBlock.createCodec(SherdBlock::new);

    public SherdBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
