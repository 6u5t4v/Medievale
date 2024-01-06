package com.gustavhaavik.engine.managers;

import com.gustavhaavik.engine.GameEvent;
import com.gustavhaavik.engine.handlers.EventHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<Class<? extends GameEvent>, List<EventHandler>> eventHandlers;

    public EventManager() {
        eventHandlers = new HashMap<>();
    }

    public void registerEventHandler(Class<? extends GameEvent> eventType, EventHandler handler) {
        List<EventHandler> handlers = eventHandlers.getOrDefault(eventType, new ArrayList<>());
        handlers.add(handler);
        eventHandlers.put(eventType, handlers);
    }

    public void unregisterEventHandler(Class<? extends GameEvent> eventType, EventHandler handler) {
        List<EventHandler> handlers = eventHandlers.getOrDefault(eventType, new ArrayList<>());
        handlers.remove(handler);
        eventHandlers.put(eventType, handlers);
    }

    public void fireEvent(GameEvent event) {
        List<EventHandler> handlers = eventHandlers.getOrDefault(event.getClass(), new ArrayList<>());
        for (EventHandler handler : handlers) {
            handler.handleEvent(event);
        }
    }
}
