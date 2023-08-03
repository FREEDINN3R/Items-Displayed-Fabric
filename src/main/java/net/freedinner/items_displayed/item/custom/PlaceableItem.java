package net.freedinner.items_displayed.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlaceableItem extends Item {
    private final Block assignedBlock;

    public PlaceableItem(Block block, Settings settings) {
        super(settings);
        assignedBlock = block;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemPlacementContext placementContext = new ItemPlacementContext(context);
        BlockItem blockItem = (BlockItem) assignedBlock.asItem();

        return blockItem.place(placementContext);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.items_displayed.tooltip.place").formatted(Formatting.GRAY));
    }
}
