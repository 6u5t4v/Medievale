package dev.gostav.medievale.entity;

import dev.gostav.medievale.AnimationHandler;
import dev.gostav.medievale.handlers.ControlHandler;
import dev.gostav.medievale.math.Vector;
import dev.gostav.medievale.utils.AnimationState;
import dev.gostav.medievale.utils.Direction;

import java.awt.*;

public class Player extends Entity {
    private AnimationHandler[] animations;
    private AnimationHandler currentAnimation;

    private AnimationState animState;

    private Vector velocity;

    private float movementSpeed = 4;

    public Player(float x, float y) {
        super(x, y);
        this.velocity = new Vector(0, 0);
        setAnimation();
    }

    @Override
    public void update() {
        setAnimation();

        currentAnimation.update();

        processInput();
        updatePos();
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
        } else {
            velocity.setX(0);
        }
    }

    @Override
    public void render(Graphics g) {
        currentAnimation.render(g, (int) x, (int) y);
    }

    private void updatePos() {
        x += velocity.getX();
        y += velocity.getY();
    }

    private void setAnimation() {
        if (velocity.equals(Vector.Zero())) {
            animState = AnimationState.IDLE;
        } else {
            animState = AnimationState.RUN;
        }

        currentAnimation = animations[animState.getIndex()];
    }

    public AnimationState getAnimState() {
        return animState;
    }

    @Override
    void loadAnimations() {
        animations = new AnimationHandler[AnimationState.values().length];

        animations[0] = new AnimationHandler("/Heroes/Knight/Idle-Sheet.png", 32, 32, 20, 0);
        animations[1] = new AnimationHandler("/Heroes/Knight/Run-Sheet.png", 64, 64, 15, 32);
        animations[2] = new AnimationHandler("/Heroes/Knight/Death-Sheet.png", 48, 32, 15, 0);
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(int x, int y) {
        this.velocity = new Vector(x, y);
    }

    public Direction getDirection() {
        return Direction.getDirection(velocity);
    }
}
