package dev.gostav.medievale;

import javax.swing.*;

public class Window {
    private JFrame frame;

    public Window(Canvas canvas) {
        frame = new JFrame("Medievale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
