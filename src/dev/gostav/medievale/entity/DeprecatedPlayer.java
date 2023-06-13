package dev.gostav.medievale.entity;

import dev.gostav.medievale.api.Entity;
import dev.gostav.medievale.api.InventoryHolder;
import dev.gostav.medievale.api.LivingEntity;
import dev.gostav.medievale.inventory.Inventory;
import dev.gostav.medievale.level.Level;
import dev.gostav.medievale.location.Location;
import dev.gostav.medievale.math.Vector;
import dev.gostav.medievale.utils.Direction;

public class DeprecatedPlayer implements LivingEntity, InventoryHolder {
    private String name;
    private Inventory inventory;
    private int health, maxHealth;
    private int width, height;

    private Location location;

    private boolean swimming, sleeping, canPickupItems;

    public DeprecatedPlayer() {
        super();
        inventory = new Inventory(this, 36);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void setInventory(Inventory inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null");
        }

        this.inventory = inventory;

        if (inventory.getHolder() != this) {
            inventory.setHolder(this);
        }
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public void resetMaxHealth() {
        health = maxHealth;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void damage(int damage) {
        health -= damage;

        if (isDead()) {
            kill();
        }
    }

    @Override
    public void damage(int damage, Entity damager) {
        health -= damage;

        if (isDead()) {
            kill();
        }
    }

    @Override
    public void heal(int heal) {
        health += heal;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    @Override
    public void kill() {
        health = 0;
        // TODO: implement
    }

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public Level getLevel() {
        return location.getLevel();
    }

    @Override
    public double getX() {
        return location.getX();
    }

    @Override
    public double getY() {
        return location.getY();
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void playEffect() {
        // TODO: implement
    }

    @Override
    public Vector getVelocity() {
        // TODO: implement
        return null;
    }

    @Override
    public void setVelocity(Vector velocity) {
        // TODO: implement
    }

    @Override
    public void setSwimming(boolean swimming) {
        this.swimming = swimming;
    }

    @Override
    public boolean isSwimming() {
        return swimming;
    }

    @Override
    public void setDirection(Direction direction) {
        location.setDirection(direction);
    }

    @Override
    public Direction getDirection() {
        return location.getDirection();
    }

    @Override
    public boolean isSleeping() {
        return sleeping;
    }

    @Override
    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    @Override
    public void setCanPickupItems(boolean pickup) {
        this.canPickupItems = pickup;
    }

    @Override
    public boolean canPickupItems() {
        return canPickupItems;
    }
}
