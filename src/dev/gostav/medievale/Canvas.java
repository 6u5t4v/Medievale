package dev.gostav.medievale;

import dev.gostav.medievale.inputs.KeyboardInput;
import dev.gostav.medievale.inputs.MouseInput;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Canvas extends JPanel {
    private MouseInput mouseInput;
    private int xDelta = 100, yDelta = 100;

    private BufferedImage image;
    private BufferedImage[][] playerAnimations;

    private int animationTick = 0, animationFrame = 0, animationSpeed = 20;

    public Canvas() {
        importImage();
        loadAnimations();

        mouseInput = new MouseInput(this);
        setPanelSize();
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
        addMouseWheelListener(mouseInput);
    }

    private void loadAnimations() {
        playerAnimations = new BufferedImage[4][4 * 3];

        for (int i = 0; i < playerAnimations.length; i++) {
            for (int j = 0; j < playerAnimations[i].length; j++) {
                playerAnimations[i][j] = image.getSubimage(i * 32, 0, 32, 32);
            }
        }
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/Heroes/Knight/Idle/Idle-Sheet.png");

        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        setPreferredSize(new Dimension(800, 600));
    }


    public void move(int x, int y) {
        xDelta = x;
        yDelta = y;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();

//        g.drawImage(playerAnimations[0][animationFrame], 0, 0, null);
    }

    private void updateAnimationTick() {
        animationTick++;

        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationFrame++;

            if (animationFrame >= 4) {
                animationFrame = 0;
            }
        }

        if (animationFrame >= 4) {
            animationFrame = 0;
        }
    }
}
