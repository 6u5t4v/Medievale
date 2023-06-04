package dev.gostav.medievale.location;

public class Location {
    private int x, y;
    private Level level;

    public Location(int x, int y, Level level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Level getLevel() {
        return level;
    }
}
