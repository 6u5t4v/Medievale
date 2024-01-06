package com.gustavhaavik.engine.gfx;

import com.gustavhaavik.engine.math.MathF;

public class Camera {
    private int x = 0, y = 0;

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void center(int x, int y, int minX, int minY, int maxX, int maxY) {
        this.x = MathF.clamp(x - 640 / 2, minX, maxX - 640);
        this.y = MathF.clamp(y - 480 / 2, minY, maxY - 480);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
