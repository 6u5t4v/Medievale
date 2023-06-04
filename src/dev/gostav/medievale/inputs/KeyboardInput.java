package dev.gostav.medievale.inputs;

import dev.gostav.medievale.Canvas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    private final Canvas canvas;

    public KeyboardInput(Canvas canvas) {
        this.canvas = canvas;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
