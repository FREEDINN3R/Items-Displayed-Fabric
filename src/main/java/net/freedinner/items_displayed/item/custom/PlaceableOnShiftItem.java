package net.freedinner.items_displayed.item.custom;

import net.freedinner.items_displayed.config.ModConfigs;
import net.freedinner.items_displayed.util.BlockAssociations;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlaceableOnShiftItem extends Item {
    private final String assignedBlockName;

    public PlaceableOnShiftItem(String blockName, Settings settings) {
        super(settings);
        assignedBlockName = blockName;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();

        if (player == null || !player.isSneaking()) {
            return super.useOnBlock(context);
        }

        ItemPlacementContext placementContext = new ItemPlacementContext(context);
        BlockItem blockItem = (BlockItem) BlockAssociations.getBlockFor(assignedBlockName).asItem();

        return blockItem.place(placementContext);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        if (!ModConfigs.APPEND_ITEM_TOOLTIP) {
            return;
        }

        tooltip.add(Text.translatable("item.items_displayed.tooltip.shift_place").formatted(Formatting.GRAY));
    }
}
