package dev.gostav.medievale.utils;

public class Collider {
    private int minX, minY, maxX, maxY;

    public Collider(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX - 1;
        this.maxY = maxY - 1;
    }

    public boolean containsPoint(int x, int y) {
        return x >= minX && x <= maxX && y >= minY && y <= maxY;
    }

    public boolean isColliding(Collider other) {
        return containsPoint(other.minX, other.minY) || containsPoint(other.maxX, other.maxY) || containsPoint(other.minX, other.maxY) || containsPoint(other.maxX, other.minY);
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
