package items;

import player.Player;

import java.util.function.Consumer;

public class ItemBuilder {
    private String name;
    private int damage;
    private Consumer<Player> use;

    public ItemBuilder(String name, int damage, Consumer<Player> use) {
        this.name = name;
        this.damage = damage;
        this.use = use;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public ItemBuilder setUse(Consumer<Player> use) {
        this.use = use;
        return this;
    }

    public Item build() {
        return new Item(name, damage, use);
    }
}
