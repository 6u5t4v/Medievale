import com.gustavhaavik.engine.GameLoop;
import factories.EntityFactory;
import factories.ItemFactory;
import factories.LevelFactory;
import level.generators.LevelGenerator;
import player.Player;

import java.awt.*;

public class Medievale extends GameLoop {
    static ItemFactory itemFactory = new ItemFactory();
    static EntityFactory entityFactory = new EntityFactory();
    static LevelFactory levelFactory = new LevelFactory();

    static Player player;

    public static void main(String[] args) {
        levelFactory = new LevelFactory();
        LevelGenerator.getGenerator(levelFactory.getCurrentLevel()).generate();

        itemFactory.generateItems();
        player = entityFactory.spawnPlayer("Gustav", levelFactory.getCurrentLevel());


        new Medievale().startGameLoop();
    }

    @Override
    public void render(Graphics g) {
        levelFactory.render(g);
        player.render(g);
    }

    @Override
    public void tick() {
        levelFactory.tick();
        player.tick();
    }

    @Override
    public void windowFocusLost() {
        // TODO: Pause game here
    }
}
