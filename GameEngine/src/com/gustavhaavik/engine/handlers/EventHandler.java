package com.gustavhaavik.engine.handlers;

import com.gustavhaavik.engine.GameEvent;

public interface EventHandler {
    void handleEvent(GameEvent event);
}
