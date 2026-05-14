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

public class LapisLazuliItemBlock extends AbstractStackableItemBlock {
    public static final VoxelShape NORTH_SOUTH_SHAPE_1 =
            Block.box(6.0, 0.0, 5.0, 10.0, 2.0, 11.0);
    public static final VoxelShape EAST_WEST_SHAPE_1 =
            Block.box(5.0, 0.0, 6.0, 11.0, 2.0, 10.0);
    public static final VoxelShape SHAPE_2 =
            Block.box(3.0, 0.0, 3.0, 13.0, 2.0, 13.0);
    public static final VoxelShape SHAPE_3 =
            Block.box(2.0, 0.0, 2.0, 14.0, 2.0, 14.0);
    public static final VoxelShape SHAPE_4 =
            Block.box(1.0, 0.0, 1.0, 15.0, 4.0, 15.0);

    private static final MapCodec<? extends HorizontalDirectionalBlock> CODEC = AbstractItemBlock.simpleCodec(LapisLazuliItemBlock::new);

    public LapisLazuliItemBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected IntegerProperty getItemProperty() {
        return ModProperties.GEMSTONES;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        int currItemCount = state.getValue(getItemProperty());

        return switch (currItemCount) {
            case 1 -> switch (state.getValue(FACING)) {
                case NORTH, SOUTH -> NORTH_SOUTH_SHAPE_1;
                case EAST, WEST -> EAST_WEST_SHAPE_1;
                default -> throw new IllegalStateException("Unexpected value: " + state.getValue(FACING));
            };
            case 2 -> SHAPE_2;
            case 3 -> SHAPE_3;
            case 4 -> SHAPE_4;
            default -> throw new IllegalStateException("Unexpected value: " + currItemCount);
        };
    }
}
