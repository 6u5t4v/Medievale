package api;

import items.Item;
import items.ItemStack;

public interface IInventory {
    ItemStack getItem(int slot);

    ItemStack[] getItems();

    ItemStack[] addItems(ItemStack... items);

    void setItem(int slot, ItemStack item);

    boolean contains(Item item);
}
