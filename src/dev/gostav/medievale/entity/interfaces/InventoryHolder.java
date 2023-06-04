package dev.gostav.medievale.entity.interfaces;

import dev.gostav.medievale.inventory.Inventory;

public interface InventoryHolder {
    Inventory getInventory();

    void setInventory(Inventory inventory);
}
