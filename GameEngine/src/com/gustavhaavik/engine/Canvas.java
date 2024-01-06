package com.gustavhaavik.engine;

import com.gustavhaavik.engine.handlers.InputHandler;
import com.gustavhaavik.engine.inputs.Keyboard;
import com.gustavhaavik.engine.inputs.PlayerMouseInput;
import com.gustavhaavik.engine.managers.EventManager;

import javax.swing.*;
import java.awt.*;


public class Canvas extends JPanel {
    private final InputHandler inputHandler;
    private final EventManager eventManager;
    private final GameLoop gameLoop;

    public Canvas(GameLoop gameLoop) {
        this.gameLoop = gameLoop;

        this.inputHandler = new InputHandler();
        this.eventManager = new EventManager();

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
