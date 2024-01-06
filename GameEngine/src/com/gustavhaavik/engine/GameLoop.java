package com.gustavhaavik.engine;


import java.awt.*;

public abstract class GameLoop implements Runnable {
    private final Canvas canvas;

    private Thread thread;

    public GameLoop() {
        canvas = new Canvas(this);
        canvas.setFocusable(true);
        canvas.requestFocus();
        new Window(canvas, this);
    }

    public void startGameLoop() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double timePerFrame = Time.FRAMES_PER_TICK;
        double timePerTick = Time.FRAMES_PER_TICK;

        long previousTime = System.nanoTime();

        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaTick = 0, deltaFrame = 0;

        while (true) {
            long currentTime = Time.now();
            deltaTick += (currentTime - previousTime) / timePerTick;
            deltaFrame += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaTick >= 1) {
                tick();
                deltaTick--;
            }

            if (deltaFrame >= 1) {
                canvas.repaint();
                frames++;
                deltaFrame--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                lastCheck = System.currentTimeMillis();
            }
        }

    }

    public abstract void render(Graphics g);

    public abstract void tick();


    public abstract void windowFocusLost();
}
