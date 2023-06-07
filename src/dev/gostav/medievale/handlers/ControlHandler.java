package dev.gostav.medievale.handlers;

import dev.gostav.medievale.inputs.Control;
import dev.gostav.medievale.inputs.Keyboard;

public class ControlHandler {
    public static final Control UP = new Control(Keyboard.KEY_W, Keyboard.KEY_UP);
    public static final Control DOWN = new Control(Keyboard.KEY_S, Keyboard.KEY_DOWN);
    public static final Control LEFT = new Control(Keyboard.KEY_A, Keyboard.KEY_LEFT);
    public static final Control RIGHT = new Control(Keyboard.KEY_D, Keyboard.KEY_RIGHT);
    public static final Control HIT = new Control(Keyboard.KEY_SPACE, Keyboard.KEY_ENTER);
    public static final Control INTERACT = new Control(Keyboard.KEY_E);
    public static final Control DROP = new Control(Keyboard.KEY_Q);
}
