package dev.gostav.medievale.levels;

import dev.gostav.medievale.managers.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Level {
    private final BufferedImage groundTiles, propTiles, treeTiles;

    public Level() {
        ResourceManager rm = ResourceManager.getInstance();
        groundTiles = (BufferedImage) rm.loadImage("/Tiles.png");
        propTiles = (BufferedImage) rm.loadImage("/Props.png");
        treeTiles = (BufferedImage) rm.loadImage("/Trees.png");
    }

    public void render(Graphics g) {
        g.drawImage(groundTiles, 0, 0, null);
        g.drawImage(propTiles, groundTiles.getWidth(), 0, null);
        g.drawImage(treeTiles, groundTiles.getWidth(), propTiles.getHeight(), null);
    }

    public void update() {
    }
}
