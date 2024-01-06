package components;

import level.Direction;
import level.Level;

public class Location {
    private double x, y;
    private Level level;
    private Direction direction;

    public Location(Level level, double x, double y, Direction direction) {
        this.level = level;
        this.x = x;
        this.y = y;
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
