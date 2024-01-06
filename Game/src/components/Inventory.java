package components;

import items.Item;
import items.ItemStack;

import java.util.Iterator;

public class Inventory implements Iterable<ItemStack> {
    private final static int MAX_INVENTORY_SIZE = 16;
    private int itemsInInv;
    private final ItemStack[] inventory;

    public Inventory() {
        this.inventory = new ItemStack[MAX_INVENTORY_SIZE];
        this.itemsInInv = 0;
    }

    public ItemStack getItem(int slot) {
        try {
            return inventory[slot];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public ItemStack[] getItems() {
        return inventory.clone();
    }

    public ItemStack[] addItems(ItemStack... items) {
        ItemStack[] noRoomFor = new ItemStack[items.length];
        int noRoomForIndex = 0;

        for (ItemStack item : items) {
            // Might be redundant
            if (item.getAmount() > item.getItem().getMaxAmount()) {
                throw new RuntimeException("Amount exceeds max amount");
            }

            if (itemsInInv >= MAX_INVENTORY_SIZE) {
                noRoomFor[noRoomForIndex++] = item;
                continue;
            }

            int remaining = addToExistingStack(item);
            if (remaining > 0) {
                item.setAmount(remaining);
                if (!addItem(item)) {
                    noRoomFor[noRoomForIndex++] = item;
                }
            }
        }

        return noRoomFor;
    }


    private int addToExistingStack(ItemStack stackToAdd) {

//        final int existingItemSlot = contains(stackToAdd.getItem());
//        if (existingItemSlot != -1) {
//            final ItemStack existingStack = inventory[existingItemSlot];
//
//            int newAmount = existingStack.getAmount() + stackToAdd.getAmount();
//            int remaining = 0;
//            if (newAmount > existingStack.getItem().getMaxAmount()) {
//                newAmount = existingStack.getItem().getMaxAmount();
//                remaining = stackToAdd.getAmount() - newAmount;
//            }
//
//            existingStack.setAmount(newAmount);
//            stackToAdd.setAmount(remaining);
//            return remaining;
//        }
//
//        return stackToAdd.getAmount();


        for (int i = 0; i < itemsInInv; i++) {
            ItemStack curr = inventory[i];
            if (curr.getItem() == stackToAdd.getItem()) {
                int remaining = curr.getItem().getMaxAmount() - curr.getAmount();
                if (remaining >= stackToAdd.getAmount()) {
                    curr.setAmount(curr.getAmount() + stackToAdd.getAmount());
                    return 0;
                } else {
                    curr.setAmount(curr.getItem().getMaxAmount());
                    return stackToAdd.getAmount() - remaining;
                }
            }
        }

        return stackToAdd.getAmount();
    }

    private boolean addItem(ItemStack item) {
        if (itemsInInv >= MAX_INVENTORY_SIZE) return false;

        inventory[itemsInInv] = item;
        itemsInInv++;
        return true;
    }

    public void setItem(int slot, ItemStack item) {

    }

    public boolean contains(Item item) {
        for (int i = 0; i < itemsInInv; i++) {
            if (inventory[i].getItem() == item) return true;
        }

        return false;
    }

    @Override
    public Iterator<ItemStack> iterator() {
        return new InventoryIterator();
    }

    private class InventoryIterator implements Iterator<ItemStack> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < itemsInInv;
        }

        @Override
        public ItemStack next() {
            return inventory[index++];
        }
    }
}
