package dev.gostav.medievale;

import dev.gostav.medievale.entity.Player;
import dev.gostav.medievale.levels.LevelManager;
import dev.gostav.medievale.utils.Time;

import java.awt.*;

public class GameLoop implements Runnable {
    private static GameLoop instance;

    public static GameLoop getInstance() {
        if (instance == null) {
            instance = new GameLoop();
        }

        return instance;
    }

    private final Canvas canvas;

    private Thread thread;

    private Player player;
    private LevelManager levelManager;

    public final static int SCALE = 3;

    public GameLoop() {
        instance = this;
        initEntities();

        canvas = new Canvas();
        canvas.setFocusable(true);
        canvas.requestFocus();
        new Window(canvas);

        startGameLoop();
    }

    private void initEntities() {
        player = new Player(0, 0, 64, 64);
        levelManager = new LevelManager();
    }

    private void startGameLoop() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double timePerFrame = Time.FRAMES_PER_TICK;
        double timePerTick = Time.FRAMES_PER_TICK;

        long previousTime = System.nanoTime();

        int frames = 0;
        int ticks = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaTick = 0, deltaFrame = 0;

        while (true) {
            long currentTime = Time.now();
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
        levelManager.render(g);
        player.render(g);
    }

    private void tick() {
        // Game logic
        levelManager.tick();
        player.tick();
    }

    public Player getPlayer() {
        return player;
    }

    public void windowFocusLost() {
        player.setVelocity(0, 0);
    }
}
