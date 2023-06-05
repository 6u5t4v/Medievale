package dev.gostav.medievale.api;

public interface Mob extends LivingEntity {
    public Entity getTarget();

    public void setTarget(Entity target);
}
