package dev.gostav.medievale.api;

import dev.gostav.medievale.location.Level;
import dev.gostav.medievale.location.Location;
import dev.gostav.medievale.math.Vector;
import dev.gostav.medievale.utils.Direction;


public interface Entity {
    public String getName();

    int getId();

    Location getLocation();

    Level getLevel();

    double getX();

    double getY();

    int getHeight();

    int getWidth();

    Direction getDirection();

    void playEffect();

    Vector getVelocity();

    void setVelocity(Vector velocity);
}
