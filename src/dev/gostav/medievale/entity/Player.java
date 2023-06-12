package dev.gostav.medievale.entity;

import dev.gostav.medievale.handlers.AnimationHandler;
import dev.gostav.medievale.handlers.ControlHandler;
import dev.gostav.medievale.math.Vector;
import dev.gostav.medievale.utils.Collider;
import dev.gostav.medievale.utils.Direction;

import java.awt.*;

public class Player extends Entity {
    enum State {
        IDLE,
        RUN,
        DEATH
    }

    private AnimationHandler[] animations;
    private AnimationHandler currentAnimation;

    private State state;

    protected Vector direction, velocity;
    protected float movementSpeed = 4;
    private Direction facing;

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);

        this.velocity = Vector.Zero();
        this.direction = Vector.Zero();

        facing = Direction.EAST;

        setCollider(new Collider((int) x, (int) y, width, height));
        setAnimation();
    }

    @Override
    public void tick() {
        processInput();
        updatePos();

        setAnimation();

        currentAnimation.update();
        collider.update((int) x, (int) y);
    }


    @Override
    public void render(Graphics g) {
        currentAnimation.render(g, (int) x, (int) y, facing == Direction.WEST);
        collider.render(g);
    }

    private void processInput() {
        if (ControlHandler.UP.down()) {
            direction.setY(-1);
        } else if (ControlHandler.DOWN.down()) {
            direction.setY(1);
        } else {
            direction.setY(0);
        }

        if (ControlHandler.LEFT.down()) {
            direction.setX(-1);
        } else if (ControlHandler.RIGHT.down()) {
            direction.setX(1);
        } else
            direction.setX(0);

    }

    private void updatePos() {
        double magnitude = direction.magnitude();

        if (magnitude == 0) {
            velocity.setX(0);
            velocity.setY(0);
            return;
        }

        if (direction.getX() > 0) {
            facing = Direction.EAST;
        } else if (direction.getX() < 0) {
            facing = Direction.WEST;
        }

        velocity = direction.normalized().multiply(movementSpeed);

        x += velocity.getX();
        y += velocity.getY();
    }

    private void setAnimation() {
        if (velocity.equals(Vector.Zero())) {
            state = State.IDLE;
        } else {
            state = State.RUN;
        }

        currentAnimation = animations[state.ordinal()];
    }

    @Override
    public void loadAnimations() {
        animations = new AnimationHandler[State.values().length];

        animations[0] = new AnimationHandler("/Player/Idle-Sheet.png", 32, 32, 20, 0);
        animations[1] = new AnimationHandler("/Player/Run-Sheet.png", 64, 32, 15, 32);

        animations[2] = new AnimationHandler("/Player/Death-Sheet.png", 48, 32, 15, 0);
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
