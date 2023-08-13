package net.freedinner.items_displayed.config;

import net.freedinner.items_displayed.ItemsDisplayed;
import net.minecraft.util.math.MathHelper;

import java.util.ArrayList;

public class ModConfigs {
    public static SimpleConfig CONFIG;

    public static boolean APPEND_ITEM_TOOLTIP;
    private static final String APPEND_ITEM_TOOLTIP_KEY = "append_item_tooltip";
    private static final boolean APPEND_ITEM_TOOLTIP_DEFAULT = true;

    public static boolean APPEND_EXTRA_TOOLTIP;
    private static final String APPEND_EXTRA_TOOLTIP_KEY = "append_extra_tooltip";
    private static final boolean APPEND_EXTRA_TOOLTIP_DEFAULT = true;

    public static int ITEM_DISPLAY_ROTATION_ANGLE;
    private static final String ITEM_DISPLAY_ROTATION_ANGLE_KEY = "item_display_rotation_angle";
    private static final int ITEM_DISPLAY_ROTATION_ANGLE_DEFAULT = 5;

    /*public static ArrayList<String> BLACKLISTED_ITEMS;
    private static final String BLACKLISTED_ITEMS_KEY = "blacklisted_items";
    private static final String BLACKLISTED_ITEMS_DEFAULT = "[ 'minecraft:air', 'minecraft:another_item' ]";*/

    public static void registerConfigs() {
        ItemsDisplayed.LOGGER.info("Registering configs");

        ModConfigProvider configProvider = new ModConfigProvider();
        initializeConfig(configProvider);

        CONFIG = SimpleConfig.of(ItemsDisplayed.MOD_ID + "_config").provider(configProvider).request();
        assignConfigs();
    }

    private static void initializeConfig(ModConfigProvider configProvider) {
        configProvider.addComment("Should append a helper tooltip to all placeable items");
        configProvider.addComment("Value = true or false");
        configProvider.addField(APPEND_ITEM_TOOLTIP_KEY, APPEND_ITEM_TOOLTIP_DEFAULT);

        configProvider.addComment("Should append a helper tooltip to other items added by the mod");
        configProvider.addComment("Value = true or false");
        configProvider.addField(APPEND_EXTRA_TOOLTIP_KEY, APPEND_EXTRA_TOOLTIP_DEFAULT);

        configProvider.addComment("The min angle by which Item Display entity can be rotated");
        configProvider.addComment("Example: for Armor Stands this value is 45, and its rotation snaps to the closest 45-degree angle");
        configProvider.addComment("Min value = 1, max value = 90");
        configProvider.addField(ITEM_DISPLAY_ROTATION_ANGLE_KEY, ITEM_DISPLAY_ROTATION_ANGLE_DEFAULT);

        /*configProvider.addComment("Blacklisted items which the player shouldn't be able to place");
        configProvider.addComment("Use this option in case of incompatibilities with other mods");
        configProvider.addField(BLACKLISTED_ITEMS_KEY, BLACKLISTED_ITEMS_DEFAULT);*/
    }

    private static void assignConfigs() {
        APPEND_ITEM_TOOLTIP = CONFIG.getOrDefault(APPEND_ITEM_TOOLTIP_KEY, APPEND_ITEM_TOOLTIP_DEFAULT);
        APPEND_EXTRA_TOOLTIP = CONFIG.getOrDefault(APPEND_EXTRA_TOOLTIP_KEY, APPEND_EXTRA_TOOLTIP_DEFAULT);
        ITEM_DISPLAY_ROTATION_ANGLE = MathHelper.clamp(
                CONFIG.getOrDefault(ITEM_DISPLAY_ROTATION_ANGLE_KEY, ITEM_DISPLAY_ROTATION_ANGLE_DEFAULT), 1, 90
        );
        /*BLACKLISTED_ITEMS = configArrayToList(
                CONFIG.getOrDefault(BLACKLISTED_ITEMS_KEY, BLACKLISTED_ITEMS_DEFAULT)
        );*/
    }

    private static ArrayList<String> configArrayToList(String s) {
        ArrayList<String> list = new ArrayList<>();

        int searchPos = 0;
        while (searchPos < s.length() && s.indexOf("'", searchPos) != -1) {
            int startPos = s.indexOf("'", searchPos) + 1;
            int endPos = s.indexOf("'", startPos);

            if (endPos == -1) {
                break;
            }

            list.add(s.substring(startPos, endPos));
            searchPos = endPos + 1;
        }

        return list;
    }
}