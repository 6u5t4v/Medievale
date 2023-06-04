package dev.gostav.medievale.location;

import dev.gostav.medievale.utils.Direction;

public class Location {
    private int x, y;
    private Level level;
    private Direction direction;

    public Location(int x, int y, Level level, Direction direction) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.direction = direction;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction cannot be null");
        }
        this.direction = direction;
    }
}
