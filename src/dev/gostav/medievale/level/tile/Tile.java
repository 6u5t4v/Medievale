package dev.gostav.medievale.level.tile;

import dev.gostav.medievale.level.Level;

public abstract class Tile {
    public static final int TILE_MAX = 256;
    public static final Tile[] TILES = new Tile[TILE_MAX];

    private final int ID;

    public Tile(int ID) {
        this.ID = ID;
        if (TILES[ID] != null) {
            throw new IllegalStateException("Tile with ID " + ID + " already exists!");
        }
        TILES[ID] = this;
    }

    public boolean collides(Level level, int x, int y) {
        return false;
    }

    public abstract void render(Level level, int x, int y);

    public int getID() {
        return ID;
    }
}
