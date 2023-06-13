package dev.gostav.medievale.level;

import java.awt.*;

public class LevelManager {
    private final Level overworld;

    private Level currentLevel;

    public LevelManager() {
        overworld = new Level(100, 100, 0);
        currentLevel = overworld;
    }

    public void tick() {
        currentLevel.update();
    }

    public void render(Graphics g) {
        currentLevel.render(g);
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }
}
