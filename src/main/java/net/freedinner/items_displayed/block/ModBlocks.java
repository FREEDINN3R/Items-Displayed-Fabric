package net.freedinner.items_displayed.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.freedinner.items_displayed.ItemsDisplayed;
import net.freedinner.items_displayed.item.custom.DebugBlockItem;
import net.freedinner.items_displayed.util.BlockItemMapper;
import net.freedinner.items_displayed.util.ModBlockTemplates;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ANGLER_POTTERY_SHERD = registerBlock("angler_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block ARCHER_POTTERY_SHERD = registerBlock("archer_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block ARMS_UP_POTTERY_SHERD = registerBlock("arms_up_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block BLADE_POTTERY_SHERD = registerBlock("blade_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block BREWER_POTTERY_SHERD = registerBlock("brewer_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block BURN_POTTERY_SHERD = registerBlock("burn_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block DANGER_POTTERY_SHERD = registerBlock("danger_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block EXPLORER_POTTERY_SHERD = registerBlock("explorer_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block FRIEND_POTTERY_SHERD = registerBlock("friend_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block HEART_POTTERY_SHERD = registerBlock("heart_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block HEARTBREAK_POTTERY_SHERD = registerBlock("heartbreak_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block HOWL_POTTERY_SHERD = registerBlock("howl_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block MINER_POTTERY_SHERD = registerBlock("miner_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block MOURNER_POTTERY_SHERD = registerBlock("mourner_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block PLENTY_POTTERY_SHERD = registerBlock("plenty_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block PRIZE_POTTERY_SHERD = registerBlock("prize_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block SHEAF_POTTERY_SHERD = registerBlock("sheaf_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block SHELTER_POTTERY_SHERD = registerBlock("shelter_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block SKULL_POTTERY_SHERD = registerBlock("skull_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());
    public static final Block SNORT_POTTERY_SHERD = registerBlock("snort_pottery_sherd",
            ModBlockTemplates.getDefaultSherdBlock());

    public static final Block NETHERITE_UPGRADE = registerBlock("netherite_upgrade",
            ModBlockTemplates.getDefaultNetheriteUpgradeBlock());
    public static final Block COAST_ARMOR_TRIM = registerBlock("coast_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.STONE));
    public static final Block DUNE_ARMOR_TRIM = registerBlock("dune_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.DRIPSTONE_BLOCK));
    public static final Block EYE_ARMOR_TRIM = registerBlock("eye_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.CALCITE));
    public static final Block HOST_ARMOR_TRIM = registerBlock("host_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.GRAVEL));
    public static final Block RAISER_ARMOR_TRIM = registerBlock("raiser_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.GRAVEL));
    public static final Block RIB_ARMOR_TRIM = registerBlock("rib_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.NETHER_BRICKS));
    public static final Block SENTRY_ARMOR_TRIM = registerBlock("sentry_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.STONE));
    public static final Block SHAPER_ARMOR_TRIM = registerBlock("shaper_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.GRAVEL));
    public static final Block SILENCE_ARMOR_TRIM = registerBlock("silence_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.DEEPSLATE));
    public static final Block SNOUT_ARMOR_TRIM = registerBlock("snout_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.POLISHED_DEEPSLATE));
    public static final Block SPIRE_ARMOR_TRIM = registerBlock("spire_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.DEEPSLATE_BRICKS));
    public static final Block TIDE_ARMOR_TRIM = registerBlock("tide_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.DEEPSLATE_BRICKS));
    public static final Block VEX_ARMOR_TRIM = registerBlock("vex_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.STONE));
    public static final Block WARD_ARMOR_TRIM = registerBlock("ward_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.DEEPSLATE));
    public static final Block WAYFINDER_ARMOR_TRIM = registerBlock("wayfinder_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.GRAVEL));
    public static final Block WILD_ARMOR_TRIM = registerBlock("wild_armor_trim",
            ModBlockTemplates.getDefaultArmorTrimBlock(BlockSoundGroup.STONE));

    public static final Block IRON_INGOT = registerBlock("iron_ingot",
            ModBlockTemplates.getDefaultIngotBlock(MapColor.IRON_GRAY));
    public static final Block COPPER_INGOT = registerBlock("copper_ingot",
            ModBlockTemplates.getDefaultIngotBlock(MapColor.ORANGE));
    public static final Block GOLD_INGOT = registerBlock("gold_ingot",
            ModBlockTemplates.getDefaultIngotBlock(MapColor.GOLD));
    public static final Block NETHERITE_INGOT = registerBlock("netherite_ingot",
            ModBlockTemplates.getDefaultIngotBlock(MapColor.BLACK));

    private static Block registerBlock(String name, Block block) {
        Block registeredBlock = Registry.register(Registries.BLOCK, new Identifier(ItemsDisplayed.MOD_ID, name), block);
        registerDebugItem(name, registeredBlock);

        return registeredBlock;
    }

    private static void registerDebugItem(String name, Block block) {
        DebugBlockItem debugBlockItem = new DebugBlockItem(block, new FabricItemSettings());
        Registry.register(Registries.ITEM, new Identifier(ItemsDisplayed.MOD_ID, name), debugBlockItem);
    }

    public static void registerBlocks() {
        ItemsDisplayed.LOGGER.info("Registering blocks");
    }
}
