package factories;

import items.Item;
import items.ItemBuilder;
import player.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public final class ItemFactory {
    private static final Set<Item> ITEM_SET = new HashSet<>();

    public void generateItems() {
        createItem("Sword", 10, ItemAction::swing);

        createItem("Bow", 5, ItemAction::shoot);

        createItem("Potion", 0, (player) -> {
            ItemAction.throwItem(player, (p) -> {
                p.damage(10);
            });
        });

        createItem("Bomb", 100, (player) -> {
            ItemAction.throwItem(player, (p) -> {
                p.damage(100);
            });
        });
    }

    private Item createItem(String name, int damage, Consumer<Player> use) {
        ItemBuilder itemBuilder = new ItemBuilder(name, damage, use);
        Item item = itemBuilder.build();
        ITEM_SET.add(item);
        return item;
    }

    static class ItemAction {
        public static void swing(Player player) {
            System.out.println(player.getName() + " swings their sword!");
        }

        public static void shoot(Player player) {
            System.out.println(player.getName() + " shoots their bow!");
        }

        public static void throwItem(Player player, Consumer<Player> action) {
            System.out.println(player.getName() + " throws their item!");
            action.accept(player);
        }
    }
}
