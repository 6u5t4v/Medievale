package dev.gostav.medievale.utils;

import java.awt.event.KeyListener;
import java.util.Arrays;

public class Keyboard {
    private static Keyboard instance;

    public static Keyboard getInstance() {
        if (instance == null) {
            instance = new Keyboard();
        }
        return instance;
    }

    private boolean[] keys = new boolean[256];

    public Keyboard() {
        Arrays.fill(keys, false);
    }

    public KeyListener getKeyListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                setKey(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                setKey(e.getKeyCode(), false);
            }
        };
    }

    public void setKey(int key, boolean pressed) {
        keys[key] = pressed;
    }

    public boolean isKeyPressed(int key) {
        return keys[key];
    }
}
