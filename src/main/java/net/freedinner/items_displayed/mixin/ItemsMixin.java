package net.freedinner.items_displayed.mixin;

import net.freedinner.items_displayed.block.ModBlocks;
import net.freedinner.items_displayed.item.custom.PlaceableItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public abstract class ItemsMixin {
    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=angler_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item anglerSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.ANGLER_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=archer_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item archerSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.ARCHER_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=arms_up_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item armsUpSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.ARMS_UP_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=blade_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item bladeSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.BLADE_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=brewer_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item brewerSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.BREWER_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=burn_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item burnSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.BURN_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=danger_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item dangerSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.DANGER_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=explorer_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item explorerSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.EXPLORER_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=friend_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item friendSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.FRIEND_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=heart_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item heartSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.HEART_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=heartbreak_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item heartbreakSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.HEARTBREAK_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=howl_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item howlSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.HOWL_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=miner_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item minerSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.MINER_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=mourner_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item mournerSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.MOURNER_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=plenty_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item plentySherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.PLENTY_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=prize_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item prizeSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.PRIZE_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=sheaf_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item sheafSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.SHEAF_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=shelter_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item shelterSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.SHELTER_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=skull_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item skullSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.SKULL_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=snort_pottery_sherd"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item snortSherd(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.SNORT_POTTERY_SHERD, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=iron_ingot"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item ironIngot(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.IRON_INGOT, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=copper_ingot"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item copperIngot(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.COPPER_INGOT, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=gold_ingot"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item goldIngot(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.GOLD_INGOT, settings);
    }

    @Redirect(
            method = "<clinit>",
            at = @At(
                    value = "NEW",
                    target = "Lnet/minecraft/item/Item;*",
                    ordinal = 0
            ),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args= {
                                    "stringValue=netherite_ingot"
                            },
                            ordinal = 0
                    )
            )
    )
    private static Item netheriteIngot(Item.Settings settings) {
        return new PlaceableItem(ModBlocks.NETHERITE_INGOT, settings);
    }
}