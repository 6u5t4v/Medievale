package dev.gostav.medievale.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class SpriteSheet {
    private int width, height;
    private int size;
    private int sizeSprites;
    private int[] pixels;

    public SpriteSheet(String path, int size) {
        this.size = size;

        BufferedImage image;

        try {
            image = ImageIO.read(Objects.requireNonNull(SpriteSheet.class.getResource(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.width = image.getWidth();
        this.height = image.getHeight();
        this.pixels = new int[width * height];

        assert (width == height);
        this.sizeSprites = width / size;

        int[] imagePixels = image.getRGB(0, 0, width, height, null, 0, width);

        for (int i = 0; i < imagePixels.length; i++) {
            int pixel = imagePixels[i];
            int r = (pixel >> 16) & 0xff;
            int g = (pixel >> 8) & 0xff;
            int b = pixel & 0xff;

            pixels[i] = r << 16 | g << 8 | b;
        }

    }
}
