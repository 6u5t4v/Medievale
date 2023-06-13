package dev.gostav.medievale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Window {
    private JFrame frame;

    public Window(Canvas canvas) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        frame = new JFrame("Medievale");
        frame.setPreferredSize(new Dimension(screen.width / 2, screen.height / 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent e) {
                canvas.requestFocusInWindow();
            }

            public void windowLostFocus(WindowEvent e) {
                GameLoop.getInstance().windowFocusLost();
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
