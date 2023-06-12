package dev.gostav.medievale.levels;

import java.awt.*;

public class LevelManager {
    private final Level overworld;

    private Level currentLevel;

    public LevelManager() {
        overworld = new Level();
        currentLevel = overworld;
    }

    public void tick() {
        currentLevel.update();
    }

    public void render(Graphics g) {
        currentLevel.render(g);
    }

    public Level getOverworld() {
        return overworld;
    }
}
