package factories;

import level.Level;
import player.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerFactory {
    private static final Set<Player> PLAYERS = new HashSet<>();

    public Player createPlayer(String name, Level level) {
        Player player = new Player(name, 20, 20, level, 0, 0);
        PLAYERS.add(player);
        return player;
    }

    public static List<Player> getPlayers() {
        return new ArrayList<>(PLAYERS);
    }
}
