package dev.gostav.medievale.inventory;

import dev.gostav.medievale.entity.interfaces.InventoryHolder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Inventory implements Iterable<ItemStack> {
    ItemStack[] items;
    private InventoryHolder holder;
    private int size;
    private boolean changed;

    public Inventory(InventoryHolder holder, int slots) {
        this.holder = holder;
        this.size = 0;
        this.items = new ItemStack[slots];
    }

    public ItemStack[] getItems() {
        return items;
    }

    public int getSize() {
        return size;
    }

    public HashMap<Integer, ItemStack> addItem(ItemStack... items) {
        if (Arrays.stream(items).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("ItemStack cannot be null");
        }

        HashMap<Integer, ItemStack> remaining = new HashMap<>();
        changed = true;

        for (ItemStack item : items) {
            int index = firstEmpty();
            if (index == -1) {
                remaining.put(remaining.size(), item);
            } else {
                setItem(index, item);
            }
        }

        return remaining;
    }


    public int firstEmpty() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                return i;
            }
        }

        return -1;
    }

    public int first(ItemStack item) {
        if (item == null) throw new IllegalArgumentException("ItemStack cannot be null");

        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    public void setItem(int index, ItemStack item) {
        if (index < 0 || index >= items.length) throw new IllegalArgumentException("Index out of bounds");
        changed = true;

        if (item == null) {
            size--;
        } else {
            size++;
        }

        items[index] = item;
    }

    public ItemStack getItem(int index) {
        if (index < 0 || index >= items.length) throw new IllegalArgumentException("Index out of bounds");
        return items[index];
    }

    public boolean contains(ItemStack item) {
        if (item == null) return false;

        for (ItemStack itemStack : items) {
            if (itemStack.equals(item)) {
                return true;
            }
        }

        return false;
    }

    public boolean contains(ItemStack item, int amount) {
        if (item == null) return false;

        int count = 0;
        for (ItemStack itemStack : items) {
            if (itemStack.equals(item)) {
                count++;
            }
        }

        return count >= amount;
    }

    public boolean contains(Item item) {
        if (item == null) return false;

        for (ItemStack itemStack : items) {
            if (itemStack.getItem().equals(item)) {
                return true;
            }
        }

        return false;
    }

    public boolean contains(Item item, int amount) {
        if (item == null) return false;

        int count = 0;
        for (ItemStack itemStack : items) {
            if (itemStack.getItem().equals(item)) {
                count += itemStack.getAmount();

                if (count >= amount) return true;
            }
        }

        return false;
    }

    public void removeItem(ItemStack item) {
        if (item == null) throw new IllegalArgumentException("ItemStack cannot be null");
        changed = true;

        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                items[i] = null;
                size--;
            }
        }
    }

    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) {
        if (Arrays.stream(items).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("ItemStack cannot be null");
        }

        HashMap<Integer, ItemStack> remaining = new HashMap<>();
        changed = true;

        for (ItemStack item : items) {
            for (int i = 0; i < this.items.length; i++) {
                if (Objects.equals(this.items[i], item)) {
                    this.items[i] = null;
                    size--;
                    break;
                }

                if (i == this.items.length - 1) {
                    remaining.put(remaining.size(), item);
                }
            }
        }

        return remaining;
    }

    public void clear() {
        changed = true;
        Arrays.fill(items, null);
    }

    public void clear(int index) {
        if (index < 0 || index >= items.length) throw new IllegalArgumentException("Index out of bounds");
        changed = true;
        size = 0;

        items[index] = null;
    }

    public void setHolder(InventoryHolder holder) {
        this.holder = holder;
    }

    public InventoryHolder getHolder() {
        return holder;
    }

    @Override
    public Iterator<ItemStack> iterator() {
        changed = false;
        return new InventoryIterator();
    }

    private class InventoryIterator implements Iterator<ItemStack> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        @Override
        public ItemStack next() {
            if (index >= items.length) throw new IndexOutOfBoundsException("Index out of bounds");

            if (changed) {
                throw new IllegalStateException("Inventory has been modified");
            }

            return items[index++];
        }
    }
}
