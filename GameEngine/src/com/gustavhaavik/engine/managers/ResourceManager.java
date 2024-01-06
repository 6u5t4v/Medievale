package com.gustavhaavik.engine.managers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
    private static ResourceManager instance;

    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }

    private Map<String, BufferedImage> imageCache;

    public ResourceManager() {
        instance = this;
        imageCache = new HashMap<>();
    }

    public BufferedImage loadImage(String path) {
        if (imageCache.containsKey(path)) {
            return imageCache.get(path);
        } else {
            BufferedImage image = loadImageFromFile(path);
            imageCache.put(path, image);
            return image;
        }
    }

    private BufferedImage loadImageFromFile(String path) {
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
