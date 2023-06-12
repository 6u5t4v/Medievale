package dev.gostav.medievale;

import dev.gostav.medievale.handlers.InputHandler;
import dev.gostav.medievale.inputs.Keyboard;
import dev.gostav.medievale.inputs.PlayerMouseInput;
import dev.gostav.medievale.managers.EventManager;
import dev.gostav.medievale.managers.ResourceManager;

import javax.swing.*;
import java.awt.*;


public class Canvas extends JPanel {
    private final InputHandler inputHandler;
    private final EventManager eventManager;
    private final ResourceManager resourceManager;
    private final GameLoop gameLoop;

    public Canvas() {
        this.gameLoop = GameLoop.getInstance();

        this.inputHandler = new InputHandler();
        this.eventManager = new EventManager();
        this.resourceManager = new ResourceManager();

        registerInputListeners();

        addKeyListener(inputHandler);
        addMouseListener(inputHandler);
        addMouseMotionListener(inputHandler);
        addMouseWheelListener(inputHandler);

        setPreferredSize(new Dimension(800, 600));
    }

    private void registerInputListeners() {
        inputHandler.addKeyListener(Keyboard.getListener());
        inputHandler.addMouseListener(new PlayerMouseInput(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameLoop.render(g);
    }
}
