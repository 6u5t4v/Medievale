package dev.gostav.medievale;

import dev.gostav.medievale.entity.Player;
import dev.gostav.medievale.handlers.InputHandler;
import dev.gostav.medievale.inputs.PlayerKeyboardInput;
import dev.gostav.medievale.inputs.PlayerMouseInput;
import dev.gostav.medievale.managers.EventManager;
import dev.gostav.medievale.managers.ResourceManager;

import javax.swing.*;
import java.awt.*;


public class Canvas extends JPanel {
    private final InputHandler inputHandler;
    private final EventManager eventManager;
    private final ResourceManager resourceManager;

    private final Player player;

    public Canvas(Player player) {
        this.player = player;
        this.inputHandler = new InputHandler();
        this.eventManager = new EventManager();
        this.resourceManager = new ResourceManager();

        addKeyListener(inputHandler);
        addMouseListener(inputHandler);
        addMouseMotionListener(inputHandler);
        addMouseWheelListener(inputHandler);

        setPreferredSize(new Dimension(800, 600));
    }

    private void registerInputListeners() {
        inputHandler.addKeyListener(new PlayerKeyboardInput(player));
        inputHandler.addMouseListener(new PlayerMouseInput(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
