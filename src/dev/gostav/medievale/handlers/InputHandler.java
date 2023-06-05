package dev.gostav.medievale.handlers;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
    private Map<Integer, Boolean> keyStates;
    private List<KeyListener> keyListeners;
    private List<MouseListener> mouseListeners;
    private List<MouseMotionListener> mouseMotionListeners;
    private List<MouseWheelListener> mouseWheelListeners;
    private int mouseX;
    private int mouseY;

    public InputHandler() {
        keyStates = new HashMap<>();
        keyListeners = new ArrayList<>();
        mouseListeners = new ArrayList<>();
        mouseMotionListeners = new ArrayList<>();
        mouseWheelListeners = new ArrayList<>();
        mouseX = 0;
        mouseY = 0;
    }

    public void addKeyListener(KeyListener listener) {
        keyListeners.add(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        keyListeners.remove(listener);
    }

    public void addMouseListener(MouseListener listener) {
        mouseListeners.add(listener);
    }

    public void removeMouseListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }

    public void addMouseMotionListener(MouseMotionListener listener) {
        mouseMotionListeners.add(listener);
    }

    public void removeMouseMotionListener(MouseMotionListener listener) {
        mouseMotionListeners.remove(listener);
    }

    public boolean isKeyPressed(int keyCode) {
        return keyStates.containsKey(keyCode) && keyStates.get(keyCode);
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    private void notifyKeyPressed(KeyEvent e) {
        keyStates.put(e.getKeyCode(), true);
        for (KeyListener listener : keyListeners) {
            listener.keyPressed(e);
        }
    }

    private void notifyKeyReleased(KeyEvent e) {
        keyStates.put(e.getKeyCode(), false);
        for (KeyListener listener : keyListeners) {
            listener.keyReleased(e);
        }
    }

    private void notifyMouseClicked(MouseEvent e) {
        for (MouseListener listener : mouseListeners) {
            listener.mouseClicked(e);
        }
    }

    private void notifyMousePressed(MouseEvent e) {
        for (MouseListener listener : mouseListeners) {
            listener.mousePressed(e);
        }
    }

    private void notifyMouseReleased(MouseEvent e) {
        for (MouseListener listener : mouseListeners) {
            listener.mouseReleased(e);
        }
    }

    private void notifyMouseEntered(MouseEvent e) {
        for (MouseListener listener : mouseListeners) {
            listener.mouseEntered(e);
        }
    }

    private void notifyMouseExited(MouseEvent e) {
        for (MouseListener listener : mouseListeners) {
            listener.mouseExited(e);
        }
    }

    private void notifyMouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        for (MouseMotionListener listener : mouseMotionListeners) {
            listener.mouseMoved(e);
        }
    }

    private void notifyMouseDragged(MouseEvent e) {
        for (MouseMotionListener listener : mouseMotionListeners) {
            listener.mouseDragged(e);
        }
    }

    private void notifyMouseWheelMoved(MouseWheelEvent e) {
        for (MouseWheelListener listener : mouseWheelListeners) {
            listener.mouseWheelMoved(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        notifyKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        notifyKeyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this example
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        notifyMouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        notifyMousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        notifyMouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        notifyMouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        notifyMouseExited(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        notifyMouseMoved(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        notifyMouseDragged(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        notifyMouseWheelMoved(e);
    }
}


