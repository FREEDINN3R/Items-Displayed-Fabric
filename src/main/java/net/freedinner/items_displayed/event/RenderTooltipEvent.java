package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.freedinner.items_displayed.config.ModConfigs;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class RenderTooltipEvent implements ItemTooltipCallback {
    @Override
    public void getTooltip(ItemStack stack, Item.TooltipContext tooltipContext, TooltipFlag tooltipType, List<Component> lines) {
        if (ModConfigs.APPEND_ITEM_TOOLTIPS && BlockItemMapper.getBlockOrNull(stack.getItem()) != null) {
            lines.add(Component.translatable("item.items_displayed.tooltip.shift_place").withStyle(ChatFormatting.GRAY));
        }
    }
}
