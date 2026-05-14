package net.freedinner.items_displayed.entity.custom.item_display;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.freedinner.items_displayed.item.ModTags;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ItemDisplayItemRenderer extends RenderLayer<ItemDisplayEntity, ItemDisplayEntityModel> {
    private final ItemInHandRenderer heldItemRenderer;
    
    public ItemDisplayItemRenderer(RenderLayerParent<ItemDisplayEntity, ItemDisplayEntityModel> context, ItemInHandRenderer heldItemRenderer) {
        super(context);
        this.heldItemRenderer = heldItemRenderer;
    }

    @Override
    public void render(PoseStack matrices, MultiBufferSource vertexConsumers, int light, ItemDisplayEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemStack itemStack = entity.getMainHandItem();

        if (itemStack.isEmpty()) {
            return;
        }

        renderItem(entity, itemStack, matrices, vertexConsumers, light);
    }

    protected void renderItem(LivingEntity entity, ItemStack itemStack, PoseStack matrices, MultiBufferSource vertexConsumers, int light) {
        matrices.pushPose();

        ((ArmedModel) getParentModel()).translateToHand(HumanoidArm.RIGHT, matrices);
        matrices.mulPose(Axis.XP.rotationDegrees(-120.0f));
        matrices.mulPose(Axis.YP.rotationDegrees(180.0f));

        if (itemStack.is(ModTags.SHERD_SHAPED)) {
            matrices.translate(0f, -0.11f, -0.94f);
        }
        else if (itemStack.is(ModTags.TEMPLATE_SHAPED)) {
            matrices.translate(0f, -0.11f, -1.01f);
        }
        else if (itemStack.is(ModTags.DISC_SHAPED)) {
            matrices.translate(0f, -0.11f, -1.01f);
        }

        Block block = BlockItemMapper.getBlockOrNull(itemStack.getItem(), true);
        ItemStack blockItemStack = new ItemStack(block == null ? Blocks.AIR : block.asItem());
        this.heldItemRenderer.renderItem(entity, blockItemStack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, false, matrices, vertexConsumers, light);

        matrices.popPose();
    }
}
