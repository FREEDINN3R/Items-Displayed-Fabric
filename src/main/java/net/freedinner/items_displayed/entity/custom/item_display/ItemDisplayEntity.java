package net.freedinner.items_displayed.entity.custom.item_display;

import net.freedinner.items_displayed.entity.custom.AbstractDisplayEntity;
import net.freedinner.items_displayed.item.ModItems;
import net.freedinner.items_displayed.item.ModTags;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class ItemDisplayEntity extends AbstractDisplayEntity {
    public ItemDisplayEntity(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (player.isSpectator()) {
            return InteractionResult.SUCCESS;
        }

        if (player.level().isClientSide()) {
            return InteractionResult.CONSUME;
        }

        if (tryDisplayItem(player, itemStack, hand)) {
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean canTakeItem(ItemStack stack) {
        return stack.is(ModTags.SHERD_SHAPED) || stack.is(ModTags.TEMPLATE_SHAPED) || stack.is(ModTags.DISC_SHAPED);
    }

    @Override
    protected Item getEntityItem() {
        return ModItems.ITEM_DISPLAY;
    }

    @Override
    protected void spawnBreakParticles() {
        if (level() instanceof ServerLevel serverWorld) {
            BlockParticleOption particles = new BlockParticleOption(ParticleTypes.BLOCK, Blocks.OAK_WOOD.defaultBlockState());
            serverWorld.sendParticles(particles, getX(), getY(0.6666666666666666), getZ(), 10, getBbWidth() / 4.0f, getBbHeight() / 4.0f, getBbWidth() / 4.0f, 0.05);
        }
    }

    @Override
    protected void playBreakSound() {
        level().playSound(null, getX(), getY(), getZ(), SoundEvents.ARMOR_STAND_BREAK, getSoundSource(), 1.0f, 1.0f);
    }

    @Override
    protected void playPutSound() {
        level().playSound(null, getX(), getY(), getZ(), SoundEvents.CHISELED_BOOKSHELF_PLACE, getSoundSource(), 1.0f, 1.0f);
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.ARMOR_STAND_HIT;
    }

    @Override
    public Fallsounds getFallSounds() {
        return new Fallsounds(SoundEvents.ARMOR_STAND_FALL, SoundEvents.ARMOR_STAND_FALL);
    }

    @Override
    @Nullable
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ARMOR_STAND_HIT;
    }

    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.ARMOR_STAND_BREAK;
    }
}
