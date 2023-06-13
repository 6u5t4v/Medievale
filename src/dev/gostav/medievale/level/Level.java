package dev.gostav.medievale.level;

import dev.gostav.medievale.managers.ResourceManager;

import java.awt.*;

public class Level {
    private final long seed;
    private final int width, height;
    private int depth;
    private int[] tiles;

    public Level(int width, int height, int seed) {
        ResourceManager rm = ResourceManager.getInstance();

        this.width = width;
        this.height = height;
        this.seed = seed;
        tiles = new int[width * height];
    }

    public static int ToTile(int pixel) {
        return pixel / 16;
    }

    public static int ToPixel(int tile) {
        return tile * 16;
    }

    public static int ToCenter(int tile) {
        return tile * 16 + 8;
    }

    public int getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= this.width || y >= this.height) {
            return 0;
        }

        return this.tiles[y * this.width + x];
    }

    public void setTile(int x, int y, int t) {
        if (x >= 0 && y >= 0 && x < this.width && y < this.height) {
            this.tiles[y * this.width + x] = t;
        }
    }

    public boolean trySetTile(int x, int y, int t) {
        int ot = this.getTile(x, y);

        // try to set the tile
        this.setTile(x, y, t);

        // TODO: check if the tile collides with anything

        return true;
    }

    public void render(Graphics g) {

    }

    public void update() {
        // TODO update all loaded entities
    }

    public long getSeed() {
        return seed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getTiles() {
        return tiles;
    }

    public int getDepth() {
        return depth;
    }
}
