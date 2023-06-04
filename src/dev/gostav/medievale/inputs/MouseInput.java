package dev.gostav.medievale.inputs;

import dev.gostav.medievale.Canvas;

import java.awt.event.*;

public class MouseInput implements MouseListener, MouseMotionListener, MouseWheelListener {
    private final Canvas canvas;

    public MouseInput(Canvas canvas) {
        this.canvas = canvas;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

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
        canvas.move(e.getX(), e.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
