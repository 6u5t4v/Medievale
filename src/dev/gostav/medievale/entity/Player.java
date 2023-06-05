package dev.gostav.medievale.entity;

import dev.gostav.medievale.AnimationHandler;
import dev.gostav.medievale.utils.AnimationState;
import dev.gostav.medievale.utils.Direction;

import java.awt.*;

public class Player extends Entity {
    private AnimationHandler[] animations;
    private AnimationHandler currentAnimation;

    private AnimationState animState;

    private boolean moving = false;
    private Direction direction;

    public Player(float x, float y) {
        super(x, y);
        direction = Direction.SOUTH;
    }

    @Override
    public void update() {
        setAnimation();

        currentAnimation.update();

        updatePos();
    }

    @Override
    public void render(Graphics g) {
        currentAnimation.render(g, (int) x, (int) y);
    }

    private void updatePos() {
        if (moving) {
            switch (direction) {
                case NORTH -> y -= 5;
                case SOUTH -> y += 5;
                case WEST -> x -= 5;
                case EAST -> x += 5;
            }
        }
    }

    private void setAnimation() {
        if (moving) {
            animState = AnimationState.RUN;
        } else {
            animState = AnimationState.IDLE;
        }

        currentAnimation = animations[animState.getIndex()];
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public AnimationState getAnimState() {
        return animState;
    }

    public boolean isMoving() {
        return moving;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    void loadAnimations() {
        animations = new AnimationHandler[AnimationState.values().length];

        animations[0] = new AnimationHandler("/Heroes/Knight/Idle-Sheet.png", 32, 32, 20, 0);
        animations[1] = new AnimationHandler("/Heroes/Knight/Run-Sheet.png", 64, 64, 15, 0);
        animations[2] = new AnimationHandler("/Heroes/Knight/Death-Sheet.png", 48, 32, 15, 0);
    }
}
