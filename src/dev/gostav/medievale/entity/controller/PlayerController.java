package dev.gostav.medievale.entity.controller;

import dev.gostav.medievale.entity.Player;
import dev.gostav.medievale.handlers.ControlHandler;

public class PlayerController extends Player {
    public PlayerController(float x, float y, int width, int height) {
        super(x, y, width, height);
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

    public void tick() {
        processInput();
    }

    public void render() {

    }
}
