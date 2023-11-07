package net.freedinner.items_displayed.mixin;

import net.freedinner.items_displayed.config.ModConfigs;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Inject(method = "appendTooltip", at = @At("TAIL"))
    private void onAppendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        Item currentItem = (Item)(Object)this;

        if (ModConfigs.APPEND_ITEM_TOOLTIPS && BlockItemMapper.getBlockOrNull(currentItem) != null) {
            tooltip.add(Text.translatable("item.items_displayed.tooltip.shift_place").formatted(Formatting.GRAY));
        }
    }
}
