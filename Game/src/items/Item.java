package items;

import player.Player;

import java.util.function.Consumer;

public class Item {
    private String name;
    private int maxAmount;
    private int damage;
    private Consumer<Player> use;

    public Item(String name, int damage, Consumer<Player> use) {
        this.name = name;
        this.damage = damage;
        this.use = use;
        this.maxAmount = 16;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public Consumer<Player> getUse() {
        return use;
    }
}
