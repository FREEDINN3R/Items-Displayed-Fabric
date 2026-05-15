package net.freedinner.items_displayed.entity.custom.jewelry_pillow;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.ItemsDisplayedClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class JewelryPillowEntityRenderer extends LivingEntityRenderer<JewelryPillowEntity, JewelryPillowEntityRenderState, JewelryPillowEntityModel> {

    public JewelryPillowEntityRenderer(EntityRendererProvider.Context context) {
        super(context,new JewelryPillowEntityModel(context.bakeLayer(ItemsDisplayedClient.JEWELRY_PILLOW_MODEL_LAYER)),0.0f);
        addLayer(new JewelryPillowItemRenderer(this,context.getEntityRenderDispatcher().getItemInHandRenderer()));
    }

    @Override
    public JewelryPillowEntityRenderState createRenderState() {
        return new JewelryPillowEntityRenderState();
    }

    @Override
    public void extractRenderState(JewelryPillowEntity entity, JewelryPillowEntityRenderState state, float partialTick) {
        super.extractRenderState(entity,state,partialTick);
        state.entity=entity;
        state.stack=entity.getMainHandItem();
        state.color=entity.getColor();
        state.entityRotation=entity.getEntityRotation();
        state.hitTicks=(float)(entity.level().getGameTime()-entity.lastHitTime)+partialTick;
    }

    @Override
    public ResourceLocation getTextureLocation(JewelryPillowEntityRenderState state) {
        return ItemsDisplayed.id("textures/entity/jewelry_pillow/"+state.color.getName()+"_jewelry_pillow.png");
    }

    @Override
    protected void setupRotations(JewelryPillowEntityRenderState state, PoseStack matrices, float bodyYaw, float scale) {
        matrices.mulPose(Axis.YP.rotationDegrees(180.0f-state.entityRotation));

        if(state.hitTicks<5.0f){
            matrices.mulPose(Axis.YP.rotationDegrees(Mth.sin(state.hitTicks/1.5f*(float)Math.PI)*3.0f));
        }
    }

    @Override
    protected boolean shouldShowName(JewelryPillowEntity entity,double distance) {
        return false;
    }
}