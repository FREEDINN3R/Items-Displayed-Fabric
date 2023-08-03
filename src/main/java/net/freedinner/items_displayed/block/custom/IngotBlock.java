package net.freedinner.items_displayed.block.custom;

import net.freedinner.items_displayed.util.BlockAssociations;
import net.freedinner.items_displayed.util.ModProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class IngotBlock extends AbstractItemBlock {
    public static final int MAX_INGOT_AMOUNT = 3;
    public static final IntProperty INGOTS = ModProperties.INGOTS;
    public static final VoxelShape NORTH_SOUTH_SHAPE_1 =
            Block.createCuboidShape(5.5, 0.0, 3.0, 10.5, 3.0, 13.0);
    public static final VoxelShape EAST_WEST_SHAPE_1 =
            Block.createCuboidShape(3.0, 0.0, 5.5, 13.0, 3.0, 10.5);
    public static final VoxelShape NORTH_SOUTH_SHAPE_2 =
            Block.createCuboidShape(1.0, 0.0, 2.5, 15.0, 3.0, 13.5);
    public static final VoxelShape EAST_WEST_SHAPE_2 =
            Block.createCuboidShape(2.5, 0.0, 1.0, 13.5, 3.0, 15.0);
    public static final VoxelShape NORTH_SOUTH_SHAPE_3 =
            VoxelShapes.union(
                    Block.createCuboidShape(2.0, 0.0, 3.0, 14.0, 3.0, 13.0),
                    Block.createCuboidShape(5.5, 3.0, 3.0, 10.5, 6.0, 13.0)
            );
    public static final VoxelShape EAST_WEST_SHAPE_3 =
            VoxelShapes.union(
                    Block.createCuboidShape(3.0, 0.0, 2.0, 13.0, 3.0, 14.0),
                    Block.createCuboidShape(3.0, 3.0, 5.5, 13.0, 6.0, 10.5)
            );

    public IngotBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(INGOTS, 1));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(INGOTS)) {
            case 1 -> switch (state.get(FACING)) {
                case NORTH, SOUTH -> NORTH_SOUTH_SHAPE_1;
                case EAST, WEST -> EAST_WEST_SHAPE_1;
                default -> throw new IllegalStateException("Unexpected value: " + state.get(FACING));
            };
            case 2 -> switch (state.get(FACING)) {
                case NORTH, SOUTH -> NORTH_SOUTH_SHAPE_2;
                case EAST, WEST -> EAST_WEST_SHAPE_2;
                default -> throw new IllegalStateException("Unexpected value: " + state.get(FACING));
            };
            case 3 -> switch (state.get(FACING)) {
                case NORTH, SOUTH -> NORTH_SOUTH_SHAPE_3;
                case EAST, WEST -> EAST_WEST_SHAPE_3;
                default -> throw new IllegalStateException("Unexpected value: " + state.get(FACING));
            };
            default -> throw new IllegalStateException("Unexpected value: " + state.get(INGOTS));
        };
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        boolean sameItem = BlockAssociations.getStackFor(state.getBlock()).isOf(context.getStack().getItem()) || context.getStack().isOf(this.asItem());

        if (!context.shouldCancelInteraction() && sameItem && state.get(INGOTS) < MAX_INGOT_AMOUNT) {
            return true;
        }

        return super.canReplace(state, context);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            return blockState.cycle(INGOTS);
        }

        return super.getPlacementState(ctx);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(INGOTS);
    }
}
