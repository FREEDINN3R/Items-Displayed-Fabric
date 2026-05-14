package net.freedinner.items_displayed.entity.custom.item_display;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.ItemsDisplayedClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ItemDisplayEntityRenderer extends LivingEntityRenderer<ItemDisplayEntity, ItemDisplayEntityModel> {

    public ItemDisplayEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ItemDisplayEntityModel(context.bakeLayer(ItemsDisplayedClient.ITEM_DISPLAY_MODEL_LAYER)), 0.0f);
        addLayer(new ItemDisplayItemRenderer(this, context.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(ItemDisplayEntity entity) {
        return ItemsDisplayed.id( "textures/entity/item_display.png");
    }

    @Override
    protected void setupRotations(ItemDisplayEntity entity, PoseStack matrices, float animationProgress, float bodyYaw, float tickDelta, float scale) {
        matrices.mulPose(Axis.YP.rotationDegrees(180.0f - entity.getEntityRotation()));

        float i = (float)(entity.level().getGameTime() - entity.lastHitTime) + tickDelta;
        if (i < 5.0f) {
            matrices.mulPose(Axis.YP.rotationDegrees(Mth.sin(i / 1.5f * (float)Math.PI) * 3.0f));
        }
    }

    @Override
    protected boolean shouldShowName(ItemDisplayEntity livingEntity) {
        return false;
    }
}
