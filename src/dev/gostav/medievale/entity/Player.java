package dev.gostav.medievale.entity;

import dev.gostav.medievale.entity.interfaces.InventoryHolder;
import dev.gostav.medievale.entity.interfaces.LivingEntity;
import dev.gostav.medievale.inventory.Inventory;

public class Player extends LivingEntity implements InventoryHolder {
    private Inventory inventory;

    public Player() {
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
}
