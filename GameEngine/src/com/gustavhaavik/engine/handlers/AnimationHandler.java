package com.gustavhaavik.engine.handlers;

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
//    private boolean flipped;


    public AnimationHandler(String animationFilePath, int frameWidth, int frameHeight, int frameDelay, int yOffset) {
        loadFrames(animationFilePath, frameWidth, frameHeight, yOffset);
        this.currentFrame = 0;
        this.frameDelay = frameDelay;
        this.delayCounter = 0;
    }

    private void loadFrames(String animationFilePath, int frameWidth, int frameHeight, int yOffset) {
        InputStream is = getClass().getResourceAsStream(animationFilePath);
        BufferedImage fullSheet;
        try {
            fullSheet = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException("Could not load animation file: " + animationFilePath);
        }

        BufferedImage scaled = fullSheet.getSubimage(0, yOffset, fullSheet.getWidth(), fullSheet.getHeight() - yOffset);

        int numFrames = scaled.getWidth() / frameWidth;
        frames = new BufferedImage[numFrames];

        for (int i = 0; i < numFrames; i++) {
            frames[i] = scaled.getSubimage(i * frameWidth, 0, frameWidth, frameHeight);
        }

        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
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

    public void render(Graphics g, int x, int y, boolean facingLeft) {
        if (facingLeft) {
            g.drawImage(frames[currentFrame], x + frameWidth, y, -frameWidth, frameHeight, null);
            return;
        }

        g.drawImage(frames[currentFrame], x, y, frameWidth, frameHeight, null);
        g.dispose();
    }

//    public void setFlipped(boolean flipped) {
//        this.flipped = flipped;
//    }
}
