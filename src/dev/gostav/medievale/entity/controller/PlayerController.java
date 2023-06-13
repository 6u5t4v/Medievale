package dev.gostav.medievale.entity.controller;

import dev.gostav.medievale.entity.Player;
import dev.gostav.medievale.gfx.Renderer;
import dev.gostav.medievale.handlers.ControlHandler;
import dev.gostav.medievale.level.Level;

public class PlayerController extends Player {
    public PlayerController(Level level, int width, int height) {
        super(level, width, height);
    }

    private void processInput() {
        if (ControlHandler.UP.down()) {
            velocity.setY(-movementSpeed);
        } else if (ControlHandler.DOWN.down()) {
            velocity.setY(movementSpeed);
        } else {
            velocity.setY(0);
        }

        if (ControlHandler.LEFT.down()) {
            velocity.setX(-movementSpeed);
        } else if (ControlHandler.RIGHT.down()) {
            velocity.setX(movementSpeed);
        } else
            velocity.setX(0);
    }

//    private void updateCamera() {
//        Renderer.Camera.center((int) (getX() + (width / 2)), (int) (getY() + (height / 2)), 0, 0, location.getLevel().getWidth(), location.getLevel().getHeight());
//    }

    public void tick() {
        processInput();
        updateCamera();
    }

    public void render() {

    }
}
