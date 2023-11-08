package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.freedinner.items_displayed.ItemsDisplayed;

public class ModEventHandlers {
    public static void registerEventHandlers() {
        ItemsDisplayed.LOGGER.info("Registering event handlers");

        UseBlockCallback.EVENT.register(new UseBlockHandler());
    }
}
