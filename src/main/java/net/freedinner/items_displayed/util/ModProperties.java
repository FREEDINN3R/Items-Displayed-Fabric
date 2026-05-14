package net.freedinner.items_displayed.util;

import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModProperties {
    public static final IntegerProperty INGOTS = IntegerProperty.create("ingots", 1, 3);
    public static final IntegerProperty GEMSTONES = IntegerProperty.create("gemstones", 1, 4);
    public static final IntegerProperty FRAGMENTS = IntegerProperty.create("fragments", 1, 9);
}
