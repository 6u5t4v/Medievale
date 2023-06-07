package dev.gostav.medievale;

import dev.gostav.medievale.entity.Player;

import java.awt.*;

public class GameLoop implements Runnable {
    private static GameLoop instance;

    public static GameLoop getInstance() {
        if (instance == null) {
            instance = new GameLoop();
        }

        return instance;
    }

    private final Window window;
    private final Canvas canvas;

    private Thread thread;

    private Player player;

    public GameLoop() {
        instance = this;
        initEntities();

        canvas = new Canvas();
        canvas.setFocusable(true);
        canvas.requestFocus();
        window = new Window(canvas);

        startGameLoop();
    }

    private void initEntities() {
        player = new Player(0, 0);
    }

    private void startGameLoop() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000 / 120;
        double timePerTick = 1000000000 / 120;

        long previousTime = System.nanoTime();

        int frames = 0;
        int ticks = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaTick = 0, deltaFrame = 0;

        while (true) {
            long currentTime = System.nanoTime();
            deltaTick += (currentTime - previousTime) / timePerTick;
            deltaFrame += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaTick >= 1) {
                tick();
                ticks++;
                deltaTick--;
            }

            if (deltaFrame >= 1) {
                canvas.repaint();
                frames++;
                deltaFrame--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                System.out.println("FPS: " + frames + " TPS: " + ticks);
                frames = 0;
                ticks = 0;
                lastCheck = System.currentTimeMillis();
            }
        }

    }

    public void render(Graphics g) {
        // Render graphics
        player.render(g);
    }

    private void tick() {
        // Game logic
        player.update();
    }

    public Player getPlayer() {
        return player;
    }

    public void windowFocusLost() {
        player.setVelocity(0, 0);
    }
}
