package net.freedinner.items_displayed.entity.custom.item_display;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.item.ItemStack;

public class ItemDisplayEntityRenderState extends LivingEntityRenderState {
    public ItemDisplayEntity entity;
    public ItemStack stack=ItemStack.EMPTY;
    public float entityRotation;
    public float hitTicks;
}