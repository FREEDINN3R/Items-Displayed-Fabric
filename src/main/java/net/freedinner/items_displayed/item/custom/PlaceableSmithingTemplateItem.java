package net.freedinner.items_displayed.item.custom;

import net.freedinner.items_displayed.config.ModConfigs;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlaceableSmithingTemplateItem extends SmithingTemplateItem {
    private final Block assignedBlock;

    public PlaceableSmithingTemplateItem(Block block, Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
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

        if (!ModConfigs.APPEND_ITEM_TOOLTIP) {
            return;
        }

        tooltip.add(Text.translatable("item.items_displayed.tooltip.place").formatted(Formatting.GRAY));
    }
}
