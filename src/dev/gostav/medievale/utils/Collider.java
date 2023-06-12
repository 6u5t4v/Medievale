package dev.gostav.medievale.utils;

import java.awt.*;

public class Collider {
    private int x, y, width, height;

    public Collider(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean containsPoint(int x, int y) {
        return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
    }

    public boolean isColliding(Collider other) {
        return other.containsPoint(x, y) ||
                other.containsPoint(x + width, y) ||
                other.containsPoint(x, y + height) ||
                other.containsPoint(x + width, y + height);
    }

    public void update(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(x, y, width, height);

        g.dispose();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
