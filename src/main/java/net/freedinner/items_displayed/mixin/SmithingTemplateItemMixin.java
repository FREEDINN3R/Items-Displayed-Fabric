package net.freedinner.items_displayed.mixin;

import net.freedinner.items_displayed.block.ModBlocks;
import net.freedinner.items_displayed.item.custom.PlaceableSmithingTemplateItem;
import net.freedinner.items_displayed.util.BlockAssociations;
import net.minecraft.block.Block;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SmithingTemplateItem.class)
public abstract class SmithingTemplateItemMixin {
    @Redirect(method = "createNetheriteUpgrade", at = @At(value = "NEW", target = "Lnet/minecraft/item/SmithingTemplateItem;*"))
    private static SmithingTemplateItem onNew(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        return new PlaceableSmithingTemplateItem("netherite_upgrade", appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
    }

    @Unique
    private static RegistryKey<ArmorTrimPattern> currTrimPattern = null;

    @Inject(method = "of(Lnet/minecraft/registry/RegistryKey;)Lnet/minecraft/item/SmithingTemplateItem;", at = @At("HEAD"))
    private static void trimPatternSaver(RegistryKey<ArmorTrimPattern> trimPattern, CallbackInfoReturnable<SmithingTemplateItem> cir) {
        currTrimPattern = trimPattern;
    }

    @Redirect(method = "of(Lnet/minecraft/util/Identifier;)Lnet/minecraft/item/SmithingTemplateItem;", at = @At(value = "NEW", target = "Lnet/minecraft/item/SmithingTemplateItem;*"))
    private static SmithingTemplateItem onOf(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        String blockName = BlockAssociations.getStringFor(currTrimPattern);
        return new PlaceableSmithingTemplateItem(blockName, appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
    }
}
