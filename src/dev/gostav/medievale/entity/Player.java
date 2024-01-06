package dev.gostav.medievale.entity;

import dev.gostav.medievale.gfx.Renderer;
import dev.gostav.medievale.handlers.AnimationHandler;
import dev.gostav.medievale.handlers.ControlHandler;
import dev.gostav.medievale.level.Level;
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

    private State state;

    private AnimationHandler[] animations;
    private AnimationHandler currentAnimation;

    protected Vector direction, velocity;
    protected float movementSpeed = 4;


    public Player(Level level, int width, int height) {
        super(0, 0, width, height, level);

        location.setX(Level.ToPixel(level.getWidth() / 2));
        location.setY(Level.ToPixel((level.getHeight() / 2) + 1));

        this.velocity = Vector.Zero();
        this.direction = Vector.Zero();

        setCollider(new Collider((int) getX(), (int) getY(), width, height));
        setAnimation();
    }

    @Override
    public void tick() {
        processInput();
        updatePos();

        setAnimation();

        currentAnimation.update();
        collider.update((int) getX(), (int) getY());

        updateCamera();
    }

    @Override
    public void render(Graphics g) {
        currentAnimation.render(g, (int) getX(), (int) getY(), getFacing() == Direction.WEST);
        collider.render(g);
    }

    public void updateCamera() {
        Renderer.Camera.center((int) (getX() + (width / 2)), (int) (getY() + (height / 2)), 0, 0, location.getLevel().getWidth(), location.getLevel().getHeight());
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
            location.setDirection(Direction.EAST);
        } else if (direction.getX() < 0) {
            location.setDirection(Direction.WEST);
        }

        velocity = direction.normalized().multiply(movementSpeed);

        location.translate(velocity.getX(), velocity.getY());
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
