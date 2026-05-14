package net.freedinner.items_displayed.util;

import net.freedinner.items_displayed.block.custom.ArmorTrimBlock;
import net.freedinner.items_displayed.block.custom.MusicDiskBlock;
import net.freedinner.items_displayed.block.custom.NetheriteUpgradeBlock;
import net.freedinner.items_displayed.block.custom.SherdBlock;
import net.freedinner.items_displayed.block.custom.stackable.DiscFragmentItemBlock;
import net.freedinner.items_displayed.block.custom.stackable.IngotItemBlock;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModTemplates{
    public static Block defaultSherdBlock(ResourceKey<Block> key){
        return new SherdBlock(defaultSettings(key)
                .mapColor(MapColor.TERRACOTTA_RED)
                .sound(SoundType.DECORATED_POT));
    }

    public static Block defaultUpgradeBlock(ResourceKey<Block> key){
        return new NetheriteUpgradeBlock(defaultSettings(key)
                .mapColor(MapColor.NETHER)
                .sound(SoundType.NETHERRACK));
    }

    public static Block defaultArmorTrimBlock(ResourceKey<Block> key,SoundType soundGroup){
        return new ArmorTrimBlock(defaultSettings(key)
                .mapColor(MapColor.STONE)
                .sound(soundGroup));
    }

    public static Block defaultIngotBlock(ResourceKey<Block> key,MapColor mapColor,boolean metal){
        SoundType soundGroup=metal?SoundType.NETHERITE_BLOCK:SoundType.STONE;

        return new IngotItemBlock(defaultSettings(key)
                .mapColor(mapColor)
                .sound(soundGroup));
    }

    public static Block defaultDiscBlock(ResourceKey<Block> key,SoundType soundGroup){
        return new MusicDiskBlock(defaultSettings(key)
                .mapColor(MapColor.COLOR_BLACK)
                .sound(soundGroup));
    }

    public static Block defaultDiscFragmentBlock(ResourceKey<Block> key){
        return new DiscFragmentItemBlock(defaultSettings(key)
                .mapColor(MapColor.COLOR_BLACK)
                .sound(SoundType.BAMBOO_WOOD));
    }

    public static BlockBehaviour.Properties defaultGemstoneSettings(ResourceKey<Block> key,MapColor mapColor){
        return defaultSettings(key)
                .mapColor(mapColor)
                .sound(SoundType.METAL);
    }

    private static BlockBehaviour.Properties defaultSettings(ResourceKey<Block> key){
        return BlockBehaviour.Properties.of()
                .setId(key)
                .instabreak()
                .noTerrainParticles()
                .noOcclusion()
                .pushReaction(PushReaction.DESTROY);
    }
}