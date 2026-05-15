package net.freedinner.items_displayed.entity.custom.jewelry_pillow;

import net.freedinner.items_displayed.entity.custom.AbstractDisplayEntity;
import net.freedinner.items_displayed.item.ModItems;
import net.freedinner.items_displayed.item.ModTags;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class JewelryPillowEntity extends AbstractDisplayEntity {
    private static final EntityDataAccessor<Byte> PILLOW_COLOR_TRACKER = SynchedEntityData.defineId(JewelryPillowEntity.class, EntityDataSerializers.BYTE);
    private static final String PILLOW_COLOR_NBT_KEY = "pillow_color";

    public JewelryPillowEntity(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(PILLOW_COLOR_TRACKER, (byte) 0);
    }

    public DyeColor getColor() {
        return DyeColor.byId(this.entityData.get(PILLOW_COLOR_TRACKER) & 15);
    }

    public void setColor(DyeColor color) {
        byte b = this.entityData.get(PILLOW_COLOR_TRACKER);
        this.entityData.set(PILLOW_COLOR_TRACKER, (byte)(b & 240 | color.getId() & 15));
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (player.isSpectator()) {
            return InteractionResult.SUCCESS;
        }

        if (itemStack.getItem() instanceof DyeItem dye && this.getColor() != dye.getDyeColor()) {
            this.level().playSound(player, this, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);

            if (!this.level().isClientSide) {
                this.setColor(dye.getDyeColor());
                itemStack.shrink(1);
            }

            return InteractionResult.SUCCESS;
        }

        if (player.level().isClientSide) {
            return InteractionResult.CONSUME;
        }

        if (tryDisplayItem(player, itemStack, hand)) {
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean canTakeItem(ItemStack stack) {
        return stack.is(ModTags.GEMSTONE_SHAPED) || stack.is(ModTags.CRYSTAL_SHAPED);
    }

    @Override
    protected Item getEntityItem() {
        return switch (this.getColor()) {
            case WHITE -> ModItems.WHITE_JEWELRY_PILLOW;
            case ORANGE -> ModItems.ORANGE_JEWELRY_PILLOW;
            case MAGENTA -> ModItems.MAGENTA_JEWELRY_PILLOW;
            case LIGHT_BLUE -> ModItems.LIGHT_BLUE_JEWELRY_PILLOW;
            case YELLOW -> ModItems.YELLOW_JEWELRY_PILLOW;
            case LIME -> ModItems.LIME_JEWELRY_PILLOW;
            case PINK -> ModItems.PINK_JEWELRY_PILLOW;
            case GRAY -> ModItems.GRAY_JEWELRY_PILLOW;
            case LIGHT_GRAY -> ModItems.LIGHT_GRAY_JEWELRY_PILLOW;
            case CYAN -> ModItems.CYAN_JEWELRY_PILLOW;
            case PURPLE -> ModItems.PURPLE_JEWELRY_PILLOW;
            case BLUE -> ModItems.BLUE_JEWELRY_PILLOW;
            case BROWN -> ModItems.BROWN_JEWELRY_PILLOW;
            case GREEN -> ModItems.GREEN_JEWELRY_PILLOW;
            case RED -> ModItems.RED_JEWELRY_PILLOW;
            case BLACK -> ModItems.BLACK_JEWELRY_PILLOW;
        };
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);

        nbt.putByte(PILLOW_COLOR_NBT_KEY, (byte) this.getColor().getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);

        nbt.getByte(PILLOW_COLOR_NBT_KEY).ifPresent(color ->
                this.setColor(DyeColor.byId(color))
        );
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
        level().playSound(null, getX(), getY(), getZ(), SoundEvents.WOOL_BREAK, getSoundSource(), 1.0f, 1.0f);
    }

    @Override
    protected void playPutSound() {
        level().playSound(null, getX(), getY(), getZ(), SoundEvents.WOOL_PLACE, getSoundSource(), 1.0f, 1.0f);
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.WOOL_HIT;
    }

    @Override
    public Fallsounds getFallSounds() {
        return new Fallsounds(SoundEvents.WOOL_FALL, SoundEvents.WOOL_FALL);
    }

    @Override
    @Nullable
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.WOOL_HIT;
    }

    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOOL_BREAK;
    }
}
