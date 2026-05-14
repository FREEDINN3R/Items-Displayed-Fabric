package net.freedinner.items_displayed.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NetheriteUpgradeBlock extends AbstractItemBlock implements SimpleWaterloggedBlock {
    private static final VoxelShape NORTH_SOUTH_SHAPE =
            Block.box(3.5, 0, 2, 12.5, 4, 14);
    private static final VoxelShape EAST_WEST_SHAPE =
            Block.box(2, 0, 3.5, 14, 4, 12.5);

    private static final MapCodec<? extends HorizontalDirectionalBlock> CODEC = AbstractItemBlock.simpleCodec(NetheriteUpgradeBlock::new);


    public NetheriteUpgradeBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH, SOUTH -> NORTH_SOUTH_SHAPE;
            case EAST, WEST -> EAST_WEST_SHAPE;
            default -> throw new IllegalStateException("Unexpected value: " + state.getValue(FACING));
        };
    }
}
