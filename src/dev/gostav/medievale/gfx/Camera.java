package dev.gostav.medievale.gfx;

public class Camera {
    private int tx = 0, ty = 0;

    public void centerOn(int x, int y, int minX, int minY, int maxX, int maxY) {
        tx = x - Renderer.WIDTH / 2;
        ty = y - Renderer.HEIGHT / 2;

        if (tx < minX) tx = minX;
        if (ty < minY) ty = minY;
        if (tx > maxX) tx = maxX;
        if (ty > maxY) ty = maxY;
    }

    public int getTx() {
        return tx;
    }

    public int getTy() {
        return ty;
    }
}
