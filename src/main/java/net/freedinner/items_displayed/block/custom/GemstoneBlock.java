package net.freedinner.items_displayed.block.custom;

import net.freedinner.items_displayed.util.BlockItemMapper;
import net.freedinner.items_displayed.util.BlockPlacer;
import net.freedinner.items_displayed.util.ModProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GemstoneBlock extends AbstractItemBlock {
    public static final int MAX_GEMSTONE_AMOUNT = 4;
    public static final IntProperty GEMSTONES = ModProperties.GEMSTONES;
    public static final VoxelShape NORTH_SOUTH_SHAPE_1 =
            Block.createCuboidShape(6.0, 0.0, 5.0, 10.0, 2.0, 11.0);
    public static final VoxelShape EAST_WEST_SHAPE_1 =
            Block.createCuboidShape(5.0, 0.0, 6.0, 11.0, 2.0, 10.0);
    public static final VoxelShape NORTH_SOUTH_SHAPE_2 =
            Block.createCuboidShape(3.0, 0.0, 2.0, 13.0, 2.0, 14.0);
    public static final VoxelShape EAST_WEST_SHAPE_2 =
            Block.createCuboidShape(2.0, 0.0, 3.0, 14.0, 2.0, 13.0);
    public static final VoxelShape SHAPE_3 =
            Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 2.0, 14.0);
    public static final VoxelShape SHAPE_4 =
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);

    public GemstoneBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(GEMSTONES, 1));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(GEMSTONES)) {
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
            case 3 -> SHAPE_3;
            case 4 -> SHAPE_4;
            default -> throw new IllegalStateException("Unexpected value: " + state.get(GEMSTONES));
        };
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.shouldCancelInteraction() && shouldAddGemstone(player.getStackInHand(hand), state)) {
            return BlockPlacer.place(state.getBlock(), player, hand, hit);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        if (!context.shouldCancelInteraction() && shouldAddGemstone(context.getStack(), state)) {
            return true;
        }

        return super.canReplace(state, context);
    }

    private boolean shouldAddGemstone(ItemStack heldItemStack, BlockState state) {
        boolean sameItem = heldItemStack.isOf(BlockItemMapper.getItemOrNull(state.getBlock()));
        return sameItem && state.get(GEMSTONES) < MAX_GEMSTONE_AMOUNT;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            return blockState.cycle(GEMSTONES);
        }

        return super.getPlacementState(ctx);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(GEMSTONES);
    }
}
