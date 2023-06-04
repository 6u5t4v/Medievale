package dev.gostav.medievale.inventory;

public class Item {
    private String name;
    private int id;

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Item(String name) {
        this.name = name;
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
