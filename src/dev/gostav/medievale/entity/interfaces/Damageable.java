package dev.gostav.medievale.entity.interfaces;

public abstract class Damageable extends Entity {
    private int health;
    private int maxHealth;

    public Damageable(int maxHealth) {
        super();
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void resetMaxHealth() {
        setHealth(getMaxHealth());
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void damage(int damage) {
        health -= damage;

        if (isDead()) {
            kill();
        }
    }

    public void damage(int damage, Entity damager) {

    }

    public void heal(int heal) {
        health += heal;

        if (health > maxHealth) {
            resetMaxHealth();
        }
    }

    public void kill() {
        health = 0;
        // TODO play death animation
    }

    public boolean isDead() {
        return health <= 0;
    }
}
