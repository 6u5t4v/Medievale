package dev.gostav.medievale;

import dev.gostav.medievale.entity.Player;
import dev.gostav.medievale.utils.Time;

import java.awt.*;

public class GameLoop implements Runnable {
    private final Window window;
    private final Canvas canvas;

    private Thread thread;

    private Player player;

    public GameLoop() {
        initEntities();

        canvas = new Canvas(player);
        canvas.setFocusable(true);
        canvas.requestFocus();
        window = new Window(canvas);

        startGameLoop();
    }

    private void initEntities() {
        player = new Player(100, 100);
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

            if (tickElapsedTime >= Time.TICK_TIME) {
                // Perform game logic here
                tick();
                lastTickTime = currentTime;
            }

            // Calculate the elapsed time since the last frame
            long frameElapsedTime = currentTime - lastFrameTime;

            if (frameElapsedTime >= Time.FRAMES_PER_TICK) {
                // Render the game here
                render();
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

    public void render() {
        // Render graphics
        Graphics g = canvas.getGraphics();

        player.render(g);

        canvas.repaint();
    }

    private void tick() {
        // Game logic
        player.update();
    }

    public Player getPlayer() {
        return player;
    }
}
