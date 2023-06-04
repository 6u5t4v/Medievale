package dev.gostav.medievale.entity.interfaces;

import dev.gostav.medievale.location.Level;
import dev.gostav.medievale.location.Location;
import dev.gostav.medievale.math.Vector;
import dev.gostav.medievale.utils.Direction;


public abstract class Entity {
    private int id;
    private String customName;
    private Location location;
    private Direction direction;
    private int height, width;

    public Entity(int id, String customName, Location location, int height, int width) {
        this.id = id;
        this.customName = customName;
        this.location = location;
        this.direction = Direction.NORTH;
        this.height = height;
        this.width = width;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    int getId() {
        return id;
    }

    Location getLocation() {
        return location;
    }

    Level getLevel() {
        return location.getLevel();
    }

    double getX() {
        return location.getX();
    }

    double getY() {
        return location.getY();
    }

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

    Direction getDirection() {
        return direction;
    }

    void playEffect() {
        // TODO implement
    }

    Vector getVelocity() {
        return null;
    }

    void setVelocity(Vector velocity) {
        // TODO implement
    }
}
