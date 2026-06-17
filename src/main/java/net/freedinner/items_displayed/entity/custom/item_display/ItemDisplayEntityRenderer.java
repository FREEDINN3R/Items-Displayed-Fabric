package net.freedinner.items_displayed.entity.custom.item_display;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.ItemsDisplayedClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class ItemDisplayEntityRenderer extends LivingEntityRenderer<ItemDisplayEntity, ItemDisplayEntityRenderState, ItemDisplayEntityModel> {

    public ItemDisplayEntityRenderer(EntityRendererProvider.Context context) {
        super(context,new ItemDisplayEntityModel(context.bakeLayer(ItemsDisplayedClient.ITEM_DISPLAY_MODEL_LAYER)),0.0f);
        addLayer(new ItemDisplayItemRenderer(this,Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer()));
    }

    @Override
    public ItemDisplayEntityRenderState createRenderState() {
        return new ItemDisplayEntityRenderState();
    }

    @Override
    public void extractRenderState(ItemDisplayEntity entity, ItemDisplayEntityRenderState state, float partialTick) {
        super.extractRenderState(entity,state,partialTick);
        state.entity=entity;
        state.stack=entity.getMainHandItem();
        state.entityRotation=entity.getEntityRotation();
        state.hitTicks=(float)(entity.level().getGameTime()-entity.lastHitTime)+partialTick;
    }

    @Override
    public Identifier getTextureLocation(ItemDisplayEntityRenderState state) {
        return ItemsDisplayed.id("textures/entity/item_display.png");
    }

    @Override
    protected void setupRotations(ItemDisplayEntityRenderState state, PoseStack matrices, float bodyYaw, float scale) {
        matrices.mulPose(Axis.YP.rotationDegrees(180.0f-state.entityRotation));

        if(state.hitTicks<5.0f){
            matrices.mulPose(Axis.YP.rotationDegrees(Mth.sin(state.hitTicks/1.5f*(float)Math.PI)*3.0f));
        }
    }

    @Override
    protected boolean shouldShowName(ItemDisplayEntity entity,double distance) {
        return false;
    }
}