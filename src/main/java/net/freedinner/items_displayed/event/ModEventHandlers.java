package net.freedinner.items_displayed.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.freedinner.items_displayed.ItemsDisplayed;

public class ModEventHandlers {
    public static void registerEventHandlers() {
        ItemsDisplayed.LOGGER.info("Registering event handlers");

        UseBlockCallback.EVENT.register(new UseBlockHandler());
        ServerWorldEvents.LOAD.register(new ServerWorldLoadHandler());
        ServerPlayConnectionEvents.JOIN.register(new ServerJoinHandler());
    }
}
