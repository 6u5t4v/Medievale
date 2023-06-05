package dev.gostav.medievale.handlers;

import dev.gostav.medievale.events.GameEvent;

public interface EventHandler {
    void handleEvent(GameEvent event);
}
