package dev.gostav.medievale;

import javax.swing.*;

public class Window {
    private JFrame frame;

    public Window(Canvas canvas) {
        frame = new JFrame("Medievale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(canvas);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
