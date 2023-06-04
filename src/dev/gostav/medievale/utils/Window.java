package dev.gostav.medievale.utils;

import dev.gostav.medievale.gfx.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Window {
    private static Window instance;

    public static Window getInstance() {
        if (instance == null) {
            instance = new Window("Medievale", 800, 600);
        }
        return instance;
    }

    private static BufferedImage image;
    private int[] buffer;

    private static BufferedImage palletteImage;
    private int[] palette;

    private JFrame frame;
    private Canvas canvas;
    private BufferStrategy bufferStrategy;

    private int width, height;

    private boolean focused;

    // frame/tick tracking
    private int frames, ticks, fps, tps;
    private long lastSecond, lastFrame, frameTime, tickTimeRemaining;

    // if true, window will exit
    private boolean close;

    public Window(String title, int width, int height) {
        this.height = height;
        this.width = width;
        instance = this;

        frame = new JFrame(title);

        init();
    }

    private void init() {
        lastSecond = Time.now();
        lastFrame = Time.now();

        // create graphics device compatible buffered image
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
        image = gc.createCompatibleImage(width, height, Transparency.OPAQUE);
        buffer = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        // generate palette
        int[] rendererPalette = Renderer.getInstance().getPalette();
        palletteImage = gc.createCompatibleImage(256, 1);
        palette = ((DataBufferInt) palletteImage.getRaster().getDataBuffer()).getData();

        for (int i = 0; i < palette.length; i++) {
            palletteImage.setRGB(i, 0, rendererPalette[i]);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                close = true;
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {
                super.windowGainedFocus(e);
                focused = true;
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                super.windowLostFocus(e);
                focused = false;
            }
        });
        frame.setIgnoreRepaint(true);

        canvas = new Canvas(gc);
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setSize(width, height);
        canvas.addKeyListener(Keyboard.getInstance().getKeyListener());
        canvas.setIgnoreRepaint(true);

        frame.add(canvas);
        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        canvas.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
    }

    public void renderFrame() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();

        // clear screen
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        // draw image
        g.drawImage(image, 0, 0, width, height, null);

        // draw fps
        g.setColor(Color.WHITE);
        g.drawString("FPS: " + fps, 10, 20);

        // draw tps
        g.setColor(Color.WHITE);
        g.drawString("TPS: " + tps, 10, 40);

        // draw frame/tick
        g.setColor(Color.WHITE);
        g.drawString("Frame: " + frames, 10, 60);
        g.drawString("Tick: " + ticks, 10, 80);

        g.dispose();
        bufferStrategy.show();
    }

    public void loop(Runnable init, Runnable update) {
        init.run();

        while (!close) {
            long now = Time.now();
            long passed = now - lastFrame;
            lastFrame = now;

            // update frame/tick
            frameTime += passed;
            tickTimeRemaining += passed;

            // update fps/tps
            if (now - lastSecond >= 1000) {
                lastSecond = now;
                fps = frames;
                tps = ticks;
                frames = 0;
                ticks = 0;
            }

            // update frame
            if (frameTime >= Time.FRAME_TIME) {
                frameTime = 0;
                frames++;
                renderFrame();
            }

            // update tick
            if (tickTimeRemaining >= Time.TICK_TIME) {
                tickTimeRemaining = 0;
                ticks++;
                update.run();
            }

            // sleep
            long sleepTime = Time.TICK_TIME - (Time.now() - lastFrame);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        frame.dispose();
        System.exit(0);
    }

    public boolean isFocused() {
        return frame.isActive();
    }
}
