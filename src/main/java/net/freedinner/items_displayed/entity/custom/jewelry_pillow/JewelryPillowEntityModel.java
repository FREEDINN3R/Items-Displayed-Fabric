package net.freedinner.items_displayed.entity.custom.jewelry_pillow;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.HumanoidArm;

public class JewelryPillowEntityModel extends EntityModel<LivingEntityRenderState> implements ArmedModel {
    private final ModelPart root;

    public JewelryPillowEntityModel(ModelPart root) {
        super(root);
        this.root=root;
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition modelData=new MeshDefinition();
        PartDefinition modelPartData=modelData.getRoot();

		PartDefinition main = modelPartData.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -1.001F, 2.75F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		main.addOrReplaceChild("support1", CubeListBuilder.create().texOffs(4, 13).addBox(-2.999F, -1.0F, -1.001F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -3.0F, 3.75F, 1.5708F, 0.0F, -1.5708F));
		main.addOrReplaceChild("support2", CubeListBuilder.create().texOffs(4, 13).addBox(-2.999F, -1.0F, -0.999F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.0F, 3.75F, 1.5708F, 0.0F, -1.5708F));
		main.addOrReplaceChild("support3", CubeListBuilder.create().texOffs(0, 13).addBox(-7.0F, -1.0F, -1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.0F, 3.25F, 0.0F, -1.5708F, 0.0F));
		main.addOrReplaceChild("support4", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -0.5F, 0.25F, 0.0F, -1.5708F, 3.1416F));
		main.addOrReplaceChild("pillow", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -2.9727F, -0.027F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.3F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(modelData, 64, 64);
	}

    @Override
    public void setupAnim(LivingEntityRenderState state) {
    }

    @Override
    public void translateToHand(HumanoidArm arm, PoseStack matrices) {
    }
}