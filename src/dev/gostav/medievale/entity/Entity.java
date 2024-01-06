package dev.gostav.medievale.entity;

import dev.gostav.medievale.level.Level;
import dev.gostav.medievale.location.Location;
import dev.gostav.medievale.utils.Collider;
import dev.gostav.medievale.utils.Direction;

import java.awt.*;

public abstract class Entity {
    protected Location location;

    protected int width, height;
    protected Collider collider;

    protected Entity(double x, double y, int width, int height, Level level) {
        this.location = new Location((int) x, (int) y, level, Direction.WEST);

        this.width = width;
        this.height = height;
        loadAnimations();
    }

    protected abstract void tick();

    protected abstract void render(Graphics g);

    protected abstract void loadAnimations();

    public double getX() {
        return location.getX();
    }

    public double getY() {
        return location.getY();
    }

    public Location location() {
        return location;
    }

    public Direction getFacing() {
        return location.getDirection();
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }
}
