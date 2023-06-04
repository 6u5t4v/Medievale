package dev.gostav.medievale;

import dev.gostav.medievale.inputs.KeyboardInput;
import dev.gostav.medievale.inputs.MouseInput;
import dev.gostav.medievale.utils.Time;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private MouseInput mouseInput;
    private int xDelta = 100, yDelta = 100;


    public Canvas() {
        mouseInput = new MouseInput(this);
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
        addMouseWheelListener(mouseInput);
    }

    public void move(int x, int y) {
        xDelta = x;
        yDelta = y;
        repaint();
    }

    long lastCheck = 0;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(xDelta, yDelta, 200, 50);
    }
}
