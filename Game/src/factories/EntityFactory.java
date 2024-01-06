package factories;

import level.Level;
import player.Player;

public class EntityFactory {
    public Player spawnPlayer(String name, Level level) {
        Player player = new Player(name, 20, 20, level, 0, 0);
        player.updateCamera();
        return player;
    }

    public void spawnEntity() {

    }
}
