package dev.gostav.medievale.entity;

import java.awt.*;

public abstract class Entity {
    protected float x, y;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
        loadAnimations();
    }

    public abstract void update();

    public abstract void render(Graphics g);

    abstract void loadAnimations();

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
