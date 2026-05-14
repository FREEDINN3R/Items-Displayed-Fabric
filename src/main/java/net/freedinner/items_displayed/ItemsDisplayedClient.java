package net.freedinner.items_displayed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.freedinner.items_displayed.entity.ModEntities;
import net.freedinner.items_displayed.entity.custom.item_display.ItemDisplayEntityModel;
import net.freedinner.items_displayed.entity.custom.item_display.ItemDisplayEntityRenderer;
import net.freedinner.items_displayed.entity.custom.jewelry_pillow.JewelryPillowEntityModel;
import net.freedinner.items_displayed.entity.custom.jewelry_pillow.JewelryPillowEntityRenderer;
import net.freedinner.items_displayed.event.ModEventHandlers;
import net.freedinner.items_displayed.networking.S2CLoadMapsPacket;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class ItemsDisplayedClient implements ClientModInitializer {
	public static final ModelLayerLocation ITEM_DISPLAY_MODEL_LAYER = new ModelLayerLocation(
			ItemsDisplayed.id("item_display"),
			"item_display_model_layer"
	);
	public static final ModelLayerLocation JEWELRY_PILLOW_MODEL_LAYER = new ModelLayerLocation(
			ItemsDisplayed.id("jewelry_pillow"),
			"main"
	);

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.ITEM_DISPLAY, ItemDisplayEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ITEM_DISPLAY_MODEL_LAYER, ItemDisplayEntityModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.JEWELRY_PILLOW, JewelryPillowEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(JEWELRY_PILLOW_MODEL_LAYER, JewelryPillowEntityModel::getTexturedModelData);

		ModEventHandlers.registerClientEventHandlers();
		ClientPlayNetworking.registerGlobalReceiver(S2CLoadMapsPacket.ID, S2CLoadMapsPacket::receive);
	}
}