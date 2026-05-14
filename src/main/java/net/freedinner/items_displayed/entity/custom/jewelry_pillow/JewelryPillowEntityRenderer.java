package net.freedinner.items_displayed.entity.custom.jewelry_pillow;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.ItemsDisplayedClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class JewelryPillowEntityRenderer extends LivingEntityRenderer<JewelryPillowEntity, JewelryPillowEntityModel> {

    public JewelryPillowEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new JewelryPillowEntityModel(context.bakeLayer(ItemsDisplayedClient.JEWELRY_PILLOW_MODEL_LAYER)), 0.0f);
        addLayer(new JewelryPillowItemRenderer(this, context.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(JewelryPillowEntity entity) {
        String color = entity.getColor().getName();
        return ItemsDisplayed.id( "textures/entity/jewelry_pillow/" + color + "_jewelry_pillow.png");
    }

    @Override
    protected void setupRotations(JewelryPillowEntity entity, PoseStack matrices, float animationProgress, float bodyYaw, float tickDelta, float scale) {
        matrices.mulPose(Axis.YP.rotationDegrees(180.0f - entity.getEntityRotation()));

        float i = (float)(entity.level().getGameTime() - entity.lastHitTime) + tickDelta;
        if (i < 5.0f) {
            matrices.mulPose(Axis.YP.rotationDegrees(Mth.sin(i / 1.5f * (float)Math.PI) * 3.0f));
        }
    }

    @Override
    protected boolean shouldShowName(JewelryPillowEntity livingEntity) {
        return false;
    }
}
