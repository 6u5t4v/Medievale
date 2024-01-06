package entities;

import com.gustavhaavik.engine.math.Vector;
import components.Location;
import level.Direction;
import level.Level;

public abstract class Entity {
    private final String name;
    protected int width, height;

    protected Vector direction, velocity;

    protected Location location;

    public Entity(String name, int width, int height, Level level, float x, float y) {
        this.name = name;
        this.location = new Location(level, x, y, Direction.DOWN);

        this.width = width;
        this.height = height;

        this.velocity = Vector.Zero();
        this.direction = Vector.Zero();
    }

    public String getName() {
        return this.name;
    }

    public double getX() {
        return location.getX();
    }

    public double getY() {
        return location.getY();
    }

    public Location getLocation() {
        return location;
    }

    public Direction getFacing() {
        return location.getDirection();
    }
}
