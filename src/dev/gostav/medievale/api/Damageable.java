package dev.gostav.medievale.api;

public interface Damageable extends Entity {

    public int getHealth();

    public int getMaxHealth();

    public void setMaxHealth(int maxHealth);

    public void resetMaxHealth();

    public void setHealth(int health);

    public void damage(int damage);

    public void damage(int damage, Entity damager);

    public void heal(int heal);

    public void kill();

    public boolean isDead();
}
