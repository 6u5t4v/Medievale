package dev.gostav.medievale.location;

import dev.gostav.medievale.level.Level;
import dev.gostav.medievale.utils.Direction;

public class Location {
    private double x, y;
    private Level level;
    private Direction direction;

    public Location(double x, double y, Level level, Direction direction) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.direction = direction;
    }

    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
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
