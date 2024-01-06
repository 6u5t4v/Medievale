package player;

import com.gustavhaavik.engine.Collider;
import com.gustavhaavik.engine.ITickable;
import com.gustavhaavik.engine.gfx.Renderer;
import com.gustavhaavik.engine.handlers.ControlHandler;
import components.Inventory;
import components.Living;
import entities.Entity;
import items.Item;
import items.ItemStack;
import level.Direction;
import level.Level;

import java.awt.*;

public class Player extends Entity implements ITickable {

    private final int MOVEMENT_SPEED = 5;

    private final Inventory inventory;
    private Collider collider;
    private Living health;

    public Player(String name, int width, int height, Level level, float x, float y) {
        super(name, width, height, level, x, y);
        this.inventory = new Inventory();
        this.collider = new Collider((int) getX(), (int) getY(), width, height);
        this.health = new Living(100f);
    }

    public boolean damage(float damage) {
        health.damage(damage);
        return health.isDead();
    }

    public void updateCamera() {
        Renderer.Camera.center((int) (getX() + (width / 2)), (int) (getY() + (height / 2)), 0, 0, location.getLevel().getWidth(), location.getLevel().getHeight());
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

        velocity = direction.normalized().multiply(MOVEMENT_SPEED);

        location.translate(velocity.getX(), velocity.getY());
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


    @Override
    public void tick() {
        processInput();
        updatePos();

        collider.update((int) getX(), (int) getY());

        updateCamera();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect((int) getX(), (int) getY(), width, height);
        collider.render(g);
    }

    public void addItem(Item item, int amount) {
        inventory.addItems(new ItemStack(item, amount));
    }

    public Inventory getInventory() {
        return inventory;
    }
}
