package dev.gostav.medievale.api;

public interface Animal extends Mob {
    public boolean isTamed();

    public void setTamed(boolean tamed);
}
