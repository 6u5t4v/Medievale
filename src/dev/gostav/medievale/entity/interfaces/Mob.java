package dev.gostav.medievale.entity.interfaces;

public abstract class Mob extends LivingEntity {
    private Entity target;

    public Entity getTarget() {
        return target;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }
}
