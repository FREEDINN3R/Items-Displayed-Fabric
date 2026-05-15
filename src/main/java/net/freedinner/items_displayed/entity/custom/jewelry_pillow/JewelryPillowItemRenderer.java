package net.freedinner.items_displayed.entity.custom.jewelry_pillow;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class JewelryPillowItemRenderer extends RenderLayer<JewelryPillowEntityRenderState, JewelryPillowEntityModel> {
    private final ItemInHandRenderer heldItemRenderer;

    public JewelryPillowItemRenderer(RenderLayerParent<JewelryPillowEntityRenderState, JewelryPillowEntityModel> context, ItemInHandRenderer heldItemRenderer) {
        super(context);
        this.heldItemRenderer = heldItemRenderer;
    }

    @Override
    public void submit(PoseStack matrices, SubmitNodeCollector collector, int light, JewelryPillowEntityRenderState state, float yRot, float xRot) {
        ItemStack itemStack = state.stack;

        if (itemStack.isEmpty()) {
            return;
        }

        renderItem(state.entity, itemStack, matrices, collector, light, state);
    }

    protected void renderItem(LivingEntity entity, ItemStack itemStack, PoseStack matrices, SubmitNodeCollector collector, int light, JewelryPillowEntityRenderState state) {
        matrices.pushPose();

        getParentModel().translateToHand(state.entityRenderState, HumanoidArm.RIGHT, matrices);
        matrices.mulPose(Axis.XP.rotationDegrees(-157.5f));
        matrices.mulPose(Axis.YP.rotationDegrees(180.0f));

        matrices.translate(0f, -0.62f, -0.51f);

        Block block = BlockItemMapper.getBlockOrNull(itemStack.getItem(), true);
        ItemStack blockItemStack = new ItemStack(block == null ? Blocks.AIR : block.asItem());
        heldItemRenderer.renderItem(entity, blockItemStack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, matrices, collector, light);

        matrices.popPose();
    }
}