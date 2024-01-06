package factories;

import com.gustavhaavik.engine.ITickable;
import level.Level;

import java.awt.*;

public class LevelFactory implements ITickable {
    private final Level overworld;

    private Level currentLevel;

    public LevelFactory() {
        overworld = new Level(100, 100, 0);
        currentLevel = overworld;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void tick() {
        currentLevel.tick();
    }

    @Override

    public void render(Graphics g) {
        currentLevel.render(g);
    }
}
