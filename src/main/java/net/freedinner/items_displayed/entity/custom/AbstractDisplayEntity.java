package net.freedinner.items_displayed.entity.custom;

import net.freedinner.items_displayed.item.ModTags;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractDisplayEntity extends LivingEntity {
    protected static final float DEFAULT_ENTITY_ROTATION = 0.0f;
    public static final EntityDataAccessor<Float> ENTITY_ROTATION_TRACKER = SynchedEntityData.defineId(AbstractDisplayEntity.class, EntityDataSerializers.FLOAT);
    protected static final Predicate<Entity> RIDEABLE_MINECART_PREDICATE= entity->entity instanceof Minecart;
    protected static final String DISPLAYED_ITEM_NBT_KEY = "displayed_item";
    protected static final String ENTITY_ROTATION_NBT_KEY = "display_entity_rotation";

    protected ItemStack displayedItem = ItemStack.EMPTY;
    protected float entityRotation = DEFAULT_ENTITY_ROTATION;
    public long lastHitTime;

    protected AbstractDisplayEntity(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }


    protected abstract Item getEntityItem();

    protected abstract void spawnBreakParticles();

    protected abstract void playBreakSound();

    protected abstract void playPutSound();

    protected abstract SoundEvent getHitSound();


    protected boolean tryDisplayItem(Player player, ItemStack stack, InteractionHand hand) {
        if (stack.isEmpty()) {
            if (displayedItem.isEmpty()) {
                return false;
            }

            player.setItemInHand(hand, displayedItem);
            setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
            return true;
        }

        if (!displayedItem.isEmpty() || !canTakeItem(stack)) {
            return false;
        }

        setItemSlot(EquipmentSlot.MAINHAND, stack.copyWithCount(1));
        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }

        playPutSound();
        return true;
    }

    public boolean canTakeItem(ItemStack stack) {
        return stack.is(ModTags.SHERD_SHAPED) || stack.is(ModTags.TEMPLATE_SHAPED) || stack.is(ModTags.DISC_SHAPED);
    }

    protected void breakAndDropItem(ServerLevel world, DamageSource damageSource) {
        ItemStack itemStack = new ItemStack(this.getEntityItem());
        Block.popResource(level(), blockPosition(), itemStack);
        onBreak(world, damageSource);
    }
    
    protected void updateHealth(ServerLevel world, DamageSource damageSource, float amount) {
        float f = getHealth() - amount;
        if (f <= 0.5f) {
            onBreak(world, damageSource);
            kill(world);
        } else {
            setHealth(f);
            gameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getEntity());
        }
    }

    protected void onBreak(ServerLevel world, DamageSource damageSource) {
        playBreakSound();
        dropAllDeathLoot(world, damageSource);

        if (!displayedItem.isEmpty()) {
            Block.popResource(level(), blockPosition(), displayedItem);
            displayedItem = ItemStack.EMPTY;
        }
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ENTITY_ROTATION_TRACKER, DEFAULT_ENTITY_ROTATION);
    }

    @Override
    public void tick() {
        super.tick();

        float angle = entityData.get(ENTITY_ROTATION_TRACKER);
        if (entityRotation != angle) {
            setEntityRotation(angle);
        }
    }

    public void setEntityRotation(float angle) {
        entityRotation = angle;
        entityData.set(ENTITY_ROTATION_TRACKER, angle);
    }

    public float getEntityRotation() {
        return entityRotation;
    }

    @Override
    protected float tickHeadTurn(float bodyRotation, float headRotation) {
        yBodyRotO = yRotO;
        yBodyRot = getYRot();
        return 0.0f;
    }
    
    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);

        if (!displayedItem.isEmpty()) {
            nbt.put(DISPLAYED_ITEM_NBT_KEY, displayedItem.saveOptional(this.registryAccess()));
        }

        if (entityRotation != DEFAULT_ENTITY_ROTATION) {
            nbt.putFloat(ENTITY_ROTATION_NBT_KEY, entityRotation);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);

        if (nbt.contains(DISPLAYED_ITEM_NBT_KEY)) {
            CompoundTag heldItemNbt = nbt.getCompound(DISPLAYED_ITEM_NBT_KEY);
            displayedItem = ItemStack.parseOptional(this.registryAccess(), heldItemNbt);
        }

        if (nbt.contains(ENTITY_ROTATION_NBT_KEY)) {
            setEntityRotation(nbt.getFloat(ENTITY_ROTATION_NBT_KEY));
        }
    }

    @Override
    public Iterable<ItemStack> getHandSlots() {
        return NonNullList.withSize(1, displayedItem);
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return NonNullList.create();
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) {
        return (slot == EquipmentSlot.MAINHAND) ? displayedItem : ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {
        verifyEquippedItem(stack);

        if (slot == EquipmentSlot.MAINHAND) {
            ItemStack oldStack = displayedItem;
            displayedItem = stack;
            onEquipItem(slot, oldStack, stack);
        }
    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }

    @Override
    public void refreshDimensions() {
        double x = getX();
        double y = getY();
        double z = getZ();

        super.refreshDimensions();
        setPos(x, y, z);
    }

    @Override
    public float maxUpStep() {
        return 0.0f;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(Entity entity) {
    }

    @Override
    protected void pushEntities() {
        List<Entity> otherEntities = level().getEntities(this, getBoundingBox(), RIDEABLE_MINECART_PREDICATE);
        for (Entity entity : otherEntities) {
            if (distanceToSqr(entity) <= 0.2) {
                entity.push(this);
            }
        }
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel,DamageSource source,float amount){
        if(this.isRemoved()){
            return false;
        }

        if(source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)){
            kill(serverLevel);
            return false;
        }

        if(this.isInvulnerableTo(serverLevel,source)){
            return false;
        }

        if(source.is(DamageTypeTags.IS_EXPLOSION)){
            breakAndDropItem(serverLevel,source);
            kill(serverLevel);
            return false;
        }

        if(source.is(DamageTypeTags.IGNITES_ARMOR_STANDS)){
            if(this.isOnFire()){
                updateHealth(serverLevel,source,0.15f);
            }else{
                igniteForSeconds(5);
            }

            return false;
        }

        if(source.is(DamageTypeTags.BURNS_ARMOR_STANDS)&&getHealth()>0.5f){
            updateHealth(serverLevel,source,4.0f);
            return false;
        }

        boolean isProjectile=source.getDirectEntity() instanceof AbstractArrow;
        boolean hasPiercing=isProjectile&&((AbstractArrow)source.getDirectEntity()).getPierceLevel()>0;
        boolean fromPlayer=source.getEntity() instanceof Player;

        if(!fromPlayer&&!isProjectile){
            return false;
        }

        Entity attacker=source.getEntity();

        if(attacker instanceof Player playerEntity){
            if(!playerEntity.getAbilities().mayBuild){
                return false;
            }
        }

        if(source.isCreativePlayer()){
            playBreakSound();
            spawnBreakParticles();
            kill(serverLevel);
            return hasPiercing;
        }

        long currTime=level().getGameTime();

        if(currTime-lastHitTime<=5L||isProjectile){
            breakAndDropItem(serverLevel,source);
            spawnBreakParticles();
            kill(serverLevel);
        }else{
            level().broadcastEntityEvent(this,EntityEvent.ARMORSTAND_WOBBLE);
            gameEvent(GameEvent.ENTITY_DAMAGE,source.getEntity());
            lastHitTime=currTime;
        }

        return true;
    }

    @Override
    public void handleEntityEvent(byte status) {
        if (status == EntityEvent.ARMORSTAND_WOBBLE) {
            if (level().isClientSide) {
                level().playLocalSound(getX(), getY(), getZ(), this.getHitSound(), getSoundSource(), 0.3f, 1.0f, false);
                lastHitTime = level().getGameTime();
            }
        } else {
            super.handleEntityEvent(status);
        }
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        double d = getBoundingBox().getSize() * 4.0;
        if (Double.isNaN(d) || d == 0.0) {
            d = 4.0;
        }

        return distance < (d *= 64.0) * d;
    }

    @Override
    public void kill(ServerLevel serverLevel){
        remove(RemovalReason.KILLED);
        gameEvent(GameEvent.ENTITY_DIE);
    }
    @Override
    public boolean skipAttackInteraction(Entity attacker) {
        return attacker instanceof Player && !level().mayInteract((Player)attacker, blockPosition());
    }

    @Override
    public void thunderHit(ServerLevel world, LightningBolt lightning) {
    }

    @Override
    public boolean isAffectedByPotions() {
        return false;
    }

    @Override
    public boolean attackable() {
        return false;
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(this.getEntityItem());
    }
}
