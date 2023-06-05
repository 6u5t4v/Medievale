package dev.gostav.medievale.inputs;

import dev.gostav.medievale.Canvas;

import java.awt.event.*;

public class PlayerMouseInput implements MouseListener, MouseMotionListener, MouseWheelListener {
    private final Canvas canvas;

    public PlayerMouseInput(Canvas canvas) {
        this.canvas = canvas;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked " + e.getButton() + " button");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Rotate player");
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println("Wheel moved " + e.getWheelRotation() + " times");
    }
}
