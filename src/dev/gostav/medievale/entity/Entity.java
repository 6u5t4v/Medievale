package dev.gostav.medievale.entity;

import dev.gostav.medievale.utils.Collider;

import java.awt.*;

public abstract class Entity {
    protected float x, y;
    protected int width, height;
    protected Collider collider;

    protected Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        loadAnimations();
    }

    protected abstract void tick();

    protected abstract void render(Graphics g);

    protected abstract void loadAnimations();

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }
}
