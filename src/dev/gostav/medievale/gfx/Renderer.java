package dev.gostav.medievale.gfx;

import dev.gostav.medievale.utils.Collider;

public class Renderer {
    public static final int WIDTH = 256, HEIGHT = 144;

    // Pixels on screen
    private final int[] pixels = new int[WIDTH * HEIGHT];
    private final TileMap tileMap = new TileMap("/Tiles.png", 16, 16);

    public static Camera Camera = new Camera();

    public static Collider getCameraView() {
        return new Collider(Camera.getX(), Camera.getY(), WIDTH, HEIGHT);
    }

    public boolean inBounds(int x, int y) {
        int xt = x - Camera.getX(), yt = y - Camera.getY();
        return xt >= 0 && yt >= 0 && xt < WIDTH && yt < HEIGHT;
    }
}
