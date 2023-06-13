package dev.gostav.medievale;

import dev.gostav.medievale.inputs.Keyboard;

import java.awt.*;

public class Main implements Runnable {

    static Window window;

    public static void main(String[] args) {
//            new GameLoop();

        window = new Window(new Canvas());

        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        try {
            Canvas.loop(
                    this::init,
                    this::update,
                    this::render
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void init() {
//        Global.mainMenu = new MainMenuState();
//        Global.currentState = Global.mainMenu;
    }

    private void destroy() {

    }

    private void tick() {
        Keyboard.tick();
//        Global.currentState.tick();
    }

    private void update() {
        Keyboard.update();
//        Global.currentState.update();
    }

    private void render() {
//        Global.frames++;
//        Renderer.clear();
//        Global.currentState.render();
    }

}