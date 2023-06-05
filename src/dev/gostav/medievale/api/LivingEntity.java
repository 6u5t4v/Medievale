package dev.gostav.medievale.api;

import dev.gostav.medievale.utils.Direction;

public interface LivingEntity extends Damageable {

    void setSwimming(boolean swimming);

    boolean isSwimming();

    void setDirection(Direction direction);

    Direction getDirection();

    boolean isSleeping();

    void setSleeping(boolean sleeping);

    void setCanPickupItems(boolean pickup);

    boolean canPickupItems();
}
