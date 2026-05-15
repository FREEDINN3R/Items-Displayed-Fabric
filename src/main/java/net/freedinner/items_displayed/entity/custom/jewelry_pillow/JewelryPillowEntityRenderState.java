package net.freedinner.items_displayed.entity.custom.jewelry_pillow;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

public class JewelryPillowEntityRenderState extends LivingEntityRenderState {
    public JewelryPillowEntity entity;
    public ItemStack stack=ItemStack.EMPTY;
    public float entityRotation;
    public float hitTicks;
    public DyeColor color=DyeColor.WHITE;
}