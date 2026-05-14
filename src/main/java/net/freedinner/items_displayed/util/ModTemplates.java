package net.freedinner.items_displayed.util;

import net.freedinner.items_displayed.block.custom.ArmorTrimBlock;
import net.freedinner.items_displayed.block.custom.MusicDiskBlock;
import net.freedinner.items_displayed.block.custom.NetheriteUpgradeBlock;
import net.freedinner.items_displayed.block.custom.SherdBlock;
import net.freedinner.items_displayed.block.custom.stackable.DiscFragmentItemBlock;
import net.freedinner.items_displayed.block.custom.stackable.IngotItemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModTemplates {
    public static Block defaultSherdBlock() {
        return new SherdBlock(defaultSettings()
                .mapColor(MapColor.TERRACOTTA_RED)
                .sound(SoundType.DECORATED_POT));
    }

    public static Block defaultUpgradeBlock() {
        return new NetheriteUpgradeBlock(defaultSettings()
                .mapColor(MapColor.NETHER)
                .sound(SoundType.NETHERRACK));
    }

    public static Block defaultArmorTrimBlock(SoundType soundGroup) {
        return new ArmorTrimBlock(defaultSettings()
                .mapColor(MapColor.STONE)
                .sound(soundGroup));
    }

    public static Block defaultIngotBlock(MapColor mapColor, boolean metal) {
        SoundType soundGroup = metal ? SoundType.NETHERITE_BLOCK : SoundType.STONE;

        return new IngotItemBlock(defaultSettings()
                .mapColor(mapColor)
                .sound(soundGroup));
    }

    public static Block defaultDiscBlock(SoundType soundGroup) {
        return new MusicDiskBlock(defaultSettings()
                .mapColor(MapColor.COLOR_BLACK)
                .sound(soundGroup));
    }

    public static Block defaultDiscFragmentBlock() {
        return new DiscFragmentItemBlock(defaultSettings()
                .mapColor(MapColor.COLOR_BLACK)
                .sound(SoundType.BAMBOO_WOOD));
    }

    public static BlockBehaviour.Properties defaultGemstoneSettings(MapColor mapColor) {
        return defaultSettings()
                .mapColor(mapColor)
                .sound(SoundType.METAL);
    }

    private static BlockBehaviour.Properties defaultSettings() {
        return BlockBehaviour.Properties
                .of()
                .instabreak()
                .noTerrainParticles()
                .noOcclusion()
                .pushReaction(PushReaction.DESTROY);
    }
}
