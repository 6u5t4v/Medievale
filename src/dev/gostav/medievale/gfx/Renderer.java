package dev.gostav.medievale.gfx;

import java.util.Arrays;
import java.util.Stack;

public class Renderer {
    private static Renderer instance;

    public static Renderer getInstance() {
        if (instance == null) {
            instance = new Renderer();
        }
        return instance;
    }

    public static final int WIDTH = 256, HEIGHT = 144;
    public static int[] pixels = new int[WIDTH * HEIGHT];
    public static SpriteSheet spritesheet = new SpriteSheet("/tiles.png", 8);
    private int[] palette;

    private Stack<Camera> cameraStack = new Stack<Camera>();
    private Camera camera;

    private int[] generatePalette() {
        int[] palette = new int[256];
        for (int i = 0; i < 256; i++) {
            int r = (i >> 5) * 36;
            int g = ((i >> 2) & 7) * 36;
            int b = (i & 3) * 85;
            palette[i] = r << 16 | g << 8 | b;
        }

        return palette;
    }

    public Renderer() {
        pushCamera();
        palette = generatePalette();
    }

    public void reset() {
        cameraStack.clear();
        pushCamera();
    }

    public void pushCamera() {
        cameraStack.push(camera);
        camera = new Camera();
    }

    public void popCamera() {
        camera = cameraStack.pop();
    }

    private boolean inBounds(int x, int y) {
        int xt = x - camera.getTx(), yt = y - camera.getTy();
        return xt >= 0 && xt < WIDTH && yt >= 0 && yt < HEIGHT;
    }

    private void clear() {
        Arrays.fill(pixels, 0);
    }

    private void fill(int x, int y, int w, int h, int color) {
        for (int yy = y; yy < y + h; yy++) {
            for (int xx = x; xx < x + w; xx++) {
                if (inBounds(xx, yy)) {
                    pixels[xx + yy * WIDTH] = Color.map(color);
                }
            }
        }
    }


    public static int[] getPixels() {
        return pixels;
    }

    public static SpriteSheet getSpritesheet() {
        return spritesheet;
    }

    public int[] getPalette() {
        return palette;
    }

    public Camera getCamera() {
        return camera;
    }
}
