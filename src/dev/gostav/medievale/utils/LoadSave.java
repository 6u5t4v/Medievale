package dev.gostav.medievale.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {
    public static final String PLAYERATLAS = "/textures/player/player.png";

    public static BufferedImage getSpriteAtlas(String fileName) {
        BufferedImage spriteAtlas = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);

        try {
            spriteAtlas = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return spriteAtlas;
    }
}
