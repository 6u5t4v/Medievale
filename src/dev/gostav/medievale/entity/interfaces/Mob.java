package dev.gostav.medievale.entity.interfaces;

public interface Mob extends LivingEntity {
    public Entity getTarget();

    public void setTarget(Entity target);
}
