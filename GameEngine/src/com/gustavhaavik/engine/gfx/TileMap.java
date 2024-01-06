package com.gustavhaavik.engine.gfx;


import com.gustavhaavik.engine.managers.ResourceManager;

import java.awt.image.BufferedImage;

public class TileMap {
    private final int width, height;

    private final BufferedImage[] tiles;

    public TileMap(String path, int width, int height) {
        BufferedImage spriteSheet = ResourceManager.getInstance().loadImage(path);

        if (spriteSheet == null) {
            throw new IllegalStateException("TileMap sprite sheet is null!");
        }

        int tilesAcross = spriteSheet.getWidth() / width;
        int tilesDown = spriteSheet.getHeight() / height;

        this.tiles = new BufferedImage[tilesAcross * tilesDown];

        for (int y = 0; y < tilesDown; y++) {
            for (int x = 0; x < tilesAcross; x++) {
                this.tiles[y * tilesAcross + x] = spriteSheet.getSubimage(x * width, y * height, width, height);
            }
        }

        this.width = width;
        this.height = height;
    }
}
