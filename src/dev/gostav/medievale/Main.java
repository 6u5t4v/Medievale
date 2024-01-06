package dev.gostav.medievale;

import dev.gostav.medievale.inputs.Keyboard;

import java.awt.*;

public class Main {

    static Window window;

    public static void main(String[] args) {
//        window = new Window(new Canvas());
//        new Thread(new Main()).start();
        new GameLoop();
    }

//    @Override
//    public void run() {
//        try {
//            Canvas.loop(
//                    this::init,
//                    this::update,
//                    this::render
//            );
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.exit(1);
//        }
//    }

    private void init() {

    }

    private void destroy() {

    }

    private void tick() {
        Keyboard.tick();
    }

    private void update() {
        Keyboard.update();
    }

    private void render() {

    }

}