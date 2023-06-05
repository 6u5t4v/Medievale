package dev.gostav.medievale;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class AnimationHandler {
    private BufferedImage[] frames;
    private int currentFrame;
    private final int frameDelay;
    private int delayCounter;
    private int frameWidth;
    private int frameHeight;

    public AnimationHandler(String animationFilePath, int frameWidth, int frameHeight, int frameDelay, int yOffset) {
        loadFrames(animationFilePath, frameWidth, frameHeight, yOffset);
        this.currentFrame = 0;
        this.frameDelay = frameDelay;
        this.delayCounter = 0;
    }

    private void loadFrames(String animationFilePath, int frameWidth, int frameHeight, int yOffset) {
        try {
            InputStream is = getClass().getResourceAsStream(animationFilePath);
            BufferedImage fullSheet = ImageIO.read(is);
            int numFrames = fullSheet.getWidth() / frameWidth;
            frames = new BufferedImage[numFrames];

            for (int i = 0; i < numFrames; i++) {
                frames[i] = fullSheet.getSubimage(i * frameWidth, yOffset, frameWidth + yOffset, frameHeight);
            }

            this.frameWidth = frameWidth;
            this.frameHeight = frameHeight;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        delayCounter++;
        if (delayCounter >= frameDelay) {
            currentFrame++;
            if (currentFrame >= frames.length) {
                currentFrame = 0;
            }
            delayCounter = 0;
        }
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(frames[currentFrame], x, y, frameWidth * 3, frameHeight * 3, null);
    }
}
