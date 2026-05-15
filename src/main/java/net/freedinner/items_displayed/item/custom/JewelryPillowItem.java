package net.freedinner.items_displayed.item.custom;

import net.freedinner.items_displayed.config.ModConfigs;
import net.freedinner.items_displayed.entity.ModEntities;
import net.freedinner.items_displayed.entity.custom.jewelry_pillow.JewelryPillowEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.function.Consumer;

public class JewelryPillowItem extends Item {
    private final DyeColor color;

    public JewelryPillowItem(Properties settings, DyeColor color) {
        super(settings);
        this.color = color;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, tooltip, flag);

        if (!ModConfigs.APPEND_EXTRA_TOOLTIPS) {
            return;
        }

        if (Screen.hasShiftDown()) {
            tooltip.accept(Component.translatable("item.items_displayed.tooltip.can_be_used_to").withStyle(ChatFormatting.GRAY));
            tooltip.accept(Component.translatable("item.items_displayed.tooltip.jewelry_pillow_0").withStyle(ChatFormatting.GRAY));
            tooltip.accept(Component.translatable("item.items_displayed.tooltip.jewelry_pillow_1").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.accept(Component.translatable("item.items_displayed.tooltip.shift_more_info").withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.FAIL;
        }

        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos().relative(context.getClickedFace());

        if (!enoughSpaceAt(blockPos, world)) {
            return InteractionResult.FAIL;
        }

        if (world instanceof ServerLevel serverWorld) {
            JewelryPillowEntity jewelryPillowEntity = createJewelryPillow(serverWorld, context, blockPos);

            if (jewelryPillowEntity == null) {
                return InteractionResult.FAIL;
            }

            setJewelryPillowRotation(jewelryPillowEntity, context);
            jewelryPillowEntity.setColor(color);
            summonJewelryPillow(serverWorld, jewelryPillowEntity, context.getPlayer());
        }

        context.getItemInHand().shrink(1);
        return InteractionResult.SUCCESS;
    }

    private boolean enoughSpaceAt(BlockPos blockPos, Level world) {
        Vec3 vec3d = Vec3.atBottomCenterOf(blockPos);
        AABB box = ModEntities.JEWELRY_PILLOW.getDimensions().makeBoundingBox(vec3d.x(), vec3d.y(), vec3d.z());

        return world.noCollision(box) && world.getEntities(null, box).isEmpty();
    }

    private JewelryPillowEntity createJewelryPillow(ServerLevel serverWorld, UseOnContext context, BlockPos blockPos) {
        Consumer<JewelryPillowEntity> consumer = EntityType.createDefaultStackConfig(serverWorld, context.getItemInHand(), context.getPlayer());
        return ModEntities.JEWELRY_PILLOW.create(serverWorld, consumer, blockPos, EntitySpawnReason.SPAWN_ITEM_USE, true, false);
    }

    private void setJewelryPillowRotation(JewelryPillowEntity entity, UseOnContext context) {
        float angle = Mth.wrapDegrees(context.getRotation() - 180.0f);
        float minRotation = ModConfigs.ENTITY_ROTATION_ANGLE;
        angle = Mth.floor((angle + minRotation / 2.0) / minRotation) * minRotation;

        entity.setEntityRotation(angle);
    }

    private void summonJewelryPillow(ServerLevel serverWorld, JewelryPillowEntity entity, Player player) {
        serverWorld.addFreshEntityWithPassengers(entity);
        serverWorld.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 0.75f, 0.8f);
        entity.gameEvent(GameEvent.ENTITY_PLACE, player);
    }
}
