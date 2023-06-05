package dev.gostav.medievale.managers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
    private Map<String, Image> imageCache;

    public ResourceManager() {
        imageCache = new HashMap<>();
    }

    public Image loadImage(String path) {
        if (imageCache.containsKey(path)) {
            return imageCache.get(path);
        } else {
            Image image = loadImageFromFile(path);
            imageCache.put(path, image);
            return image;
        }
    }

    private Image loadImageFromFile(String path) {
        // Load the image from file using ImageIO or any other image loading library
        try {
            InputStream is = getClass().getResourceAsStream(path);
            return ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // TODO: Add similar methods for sound loading/unloading

    // TODO: Add methods for unloading resources when they are no longer needed
}
