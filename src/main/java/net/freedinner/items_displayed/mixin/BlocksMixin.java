package net.freedinner.items_displayed.mixin;

import net.freedinner.items_displayed.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Blocks.class)
public abstract class BlocksMixin {
    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void onStaticBlock(CallbackInfo ci) {
        //removing this may corrupt your world under certain circumstances
        //gl figuring out why
        Block block = ModBlocks.ANGLER_POTTERY_SHERD;
    }
}
