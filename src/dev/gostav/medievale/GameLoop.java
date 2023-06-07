package dev.gostav.medievale;

import dev.gostav.medievale.entity.Player;
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
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//                tick();
//                render();
//            }
//        }, 0, 20);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        long lastTickTime = Time.now();
        long lastFrameTime = Time.now();
        int framesPerSecond = 0;
        long startTime = Time.now();

        while (true) {
            long currentTime = Time.now();

            // Calculate the elapsed time since the last tick
            long tickElapsedTime = currentTime - lastTickTime;

            if (tickElapsedTime >= Time.FRAMES_PER_TICK) {
                // Perform game logic here
                tick();
                lastTickTime = currentTime;
            }

            // Calculate the elapsed time since the last frame
            long frameElapsedTime = currentTime - lastFrameTime;

            if (frameElapsedTime >= Time.TICK_TIME) {
                // Render the game here
                canvas.repaint();
                lastFrameTime = currentTime;
                framesPerSecond++;
            }

            // Calculate the elapsed time since the start
            long elapsedTime = currentTime - startTime;

            // Display FPS every second
            if (elapsedTime >= Time.FRAME_TIME) {
                System.out.println("FPS: " + framesPerSecond);
                framesPerSecond = 0;
                startTime = currentTime;
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
}
