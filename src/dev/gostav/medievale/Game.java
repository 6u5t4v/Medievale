package dev.gostav.medievale;

import dev.gostav.medievale.utils.Time;

public class Game implements Runnable {
    private Window window;
    private Canvas canvas;

    private Thread thread;

    public Game() {
        canvas = new Canvas();
        canvas.requestFocus();
        window = new Window(canvas);

        startGameLoop();
    }

    private void startGameLoop() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
//        long now = Time.now();
        long lastSecond = Time.now(), lastFrame = lastSecond, frameTime, tickTimeRemaining = 0;
//
        int frames = 0, ticks = 0, fps, tps;

        while (true) {
            long now = Time.now(), start = now;

            if (now - lastSecond >= Time.FRAME_TIME) {
                lastSecond = now;
                fps = frames;
                tps = ticks;
                frames = 0;
                ticks = 0;
                System.out.println(fps + " | " + tps);
            }

            frameTime = now - lastFrame;
            lastFrame = now;

            long tickTime = frameTime + tickTimeRemaining;
            while (tickTime >= Time.FRAMES_PER_TICK) {
//                tick.run();
                tickTime -= Time.FRAMES_PER_TICK;
                ticks++;
            }

            tickTimeRemaining = tickTime;

            // update
            // render
            canvas.repaint();
            frames++;

            long sleepTime = Time.FRAMES_PER_TICK - (Time.now() - start);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime / 1000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            now = Time.now();
//            if (now - lastFrame >= Time.FRAME_TIME) {
//                canvas.repaint();
//                lastFrame = now;
//                frames++;
//            }
//
//            if (System.currentTimeMillis() - lastCheck >= 1000) {
//                System.out.println(frames);
//                frames = 0;
//                lastCheck = Time.now();
//            }
        }
    }
}
