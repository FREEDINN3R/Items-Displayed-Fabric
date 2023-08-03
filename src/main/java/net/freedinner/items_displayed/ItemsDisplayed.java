package net.freedinner.items_displayed;

import net.fabricmc.api.ModInitializer;

import net.freedinner.items_displayed.block.ModBlocks;
import net.freedinner.items_displayed.entity.ModEntities;
import net.freedinner.items_displayed.item.ModItemGroups;
import net.freedinner.items_displayed.item.ModItems;
import net.freedinner.items_displayed.item.ModTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemsDisplayed implements ModInitializer {
	public static final String MOD_ID = "items_displayed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
		ModTags.registerTags();
		ModEntities.registerEntities();
	}
}