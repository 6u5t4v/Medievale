package dev.gostav.medievale.inputs;

import dev.gostav.medievale.GameLoop;
import dev.gostav.medievale.entity.Player;
import dev.gostav.medievale.utils.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerKeyboardInput extends KeyAdapter {
    private final Player player;

    public PlayerKeyboardInput() {
        this.player = GameLoop.getInstance().getPlayer();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed " + e.getKeyCode() + " key");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setDirection(Direction.NORTH);
            case KeyEvent.VK_S -> player.setDirection(Direction.SOUTH);
            case KeyEvent.VK_A -> player.setDirection(Direction.WEST);
            case KeyEvent.VK_D -> player.setDirection(Direction.EAST);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Released " + e.getKeyCode() + " key");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D -> player.setMoving(false);
        }
    }
}
