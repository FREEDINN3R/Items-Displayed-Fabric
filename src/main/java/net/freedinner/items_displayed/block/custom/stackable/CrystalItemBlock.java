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

public class CrystalItemBlock extends AbstractStackableItemBlock {
    public static final VoxelShape NORTH_SOUTH_SHAPE_1 =
            Block.box(5.0, 0.0, 4.0, 11.0, 3.0, 12.0);
    public static final VoxelShape EAST_WEST_SHAPE_1 =
            Block.box(4.0, 0.0, 5.0, 12.0, 3.0, 11.0);
    public static final VoxelShape NORTH_SOUTH_SHAPE_2 =
            Block.box(3.0, 0.0, 1.5, 13.0, 3.0, 14.5);
    public static final VoxelShape EAST_WEST_SHAPE_2 =
            Block.box(1.5, 0.0, 3.0, 14.5, 3.0, 13.0);
    public static final VoxelShape NORTH_SOUTH_SHAPE_3 =
            Block.box(3.0, 0.0, 1.5, 13.0, 6.0, 14.5);
    public static final VoxelShape EAST_WEST_SHAPE_3 =
            Block.box(1.5, 0.0, 3.0, 14.5, 6.0, 13.0);
    public static final VoxelShape NORTH_SOUTH_SHAPE_4 =
            Block.box(3.0, 0.0, 1.5, 13.0, 6.0, 14.5);
    public static final VoxelShape EAST_WEST_SHAPE_4 =
            Block.box(1.5, 0.0, 3.0, 14.5, 6.0, 13.0);

    private static final MapCodec<? extends HorizontalDirectionalBlock> CODEC = AbstractItemBlock.simpleCodec(CrystalItemBlock::new);

    public CrystalItemBlock(Properties settings) {
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

        return switch (state.getValue(FACING)) {
            case NORTH, SOUTH -> switch (currItemCount) {
                case 1 -> NORTH_SOUTH_SHAPE_1;
                case 2 -> NORTH_SOUTH_SHAPE_2;
                case 3 -> NORTH_SOUTH_SHAPE_3;
                case 4 -> NORTH_SOUTH_SHAPE_4;
                default -> throw new IllegalStateException("Unexpected value: " + currItemCount);
            };
            case EAST, WEST -> switch (currItemCount) {
                case 1 -> EAST_WEST_SHAPE_1;
                case 2 -> EAST_WEST_SHAPE_2;
                case 3 -> EAST_WEST_SHAPE_3;
                case 4 -> EAST_WEST_SHAPE_4;
                default -> throw new IllegalStateException("Unexpected value: " + currItemCount);
            };
            default -> throw new IllegalStateException("Unexpected value: " + state.getValue(FACING));
        };
    }
}
