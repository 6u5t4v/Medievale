package dev.gostav.medievale.entity.interfaces;

import dev.gostav.medievale.utils.Direction;

public abstract class LivingEntity extends Damageable {
    boolean swimming, sleeping, canPickupItems;
    Direction direction;

    public LivingEntity() {
        super(20);
        this.swimming = false;
        this.sleeping = false;
        this.canPickupItems = true;
        this.direction = Direction.NORTH;
    }

    void setSwimming(boolean swimming) {
        this.swimming = swimming;
    }

    boolean isSwimming() {
        return swimming;
    }

    void setDirection(Direction direction) {
        this.direction = direction;
    }

    Direction getDirection() {
        return direction;
    }

    boolean isSleeping() {
        return sleeping;
    }

    void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    void setCanPickupItems(boolean pickup) {
        this.canPickupItems = pickup;
    }

    boolean canPickupItems() {
        return canPickupItems;
    }
}
