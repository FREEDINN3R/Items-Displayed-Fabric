package net.freedinner.items_displayed.util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.freedinner.items_displayed.block.custom.*;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlockTemplates {
    public static Block getDefaultSherdBlock() {
        return new SherdBlock(defaultSettings()
                .mapColor(MapColor.TERRACOTTA_RED)
                .sounds(BlockSoundGroup.DECORATED_POT));
    }

    public static Block getDefaultNetheriteUpgradeBlock() {
        return new NetheriteUpgradeBlock(defaultSettings()
                .mapColor(MapColor.DARK_RED)
                .sounds(BlockSoundGroup.NETHERRACK));
    }

    public static Block getDefaultArmorTrimBlock(BlockSoundGroup soundGroup) {
        return new ArmorTrimBlock(defaultSettings()
                .mapColor(MapColor.STONE_GRAY)
                .sounds(soundGroup));
    }

    public static Block getDefaultIngotBlock(MapColor mapColor) {
        return new IngotBlock(defaultSettings()
                .mapColor(mapColor)
                .sounds(BlockSoundGroup.NETHERITE));
    }

    public static Block getDefaultGemstoneBlock(MapColor mapColor) {
        return new GemstoneBlock(defaultSettings()
                .mapColor(mapColor)
                .sounds(BlockSoundGroup.METAL));
    }

    private static FabricBlockSettings defaultSettings() {
        return FabricBlockSettings
                .of()
                .breakInstantly()
                .noBlockBreakParticles()
                .nonOpaque()
                .pistonBehavior(PistonBehavior.DESTROY);
    }
}
