package dev.gostav.medievale.utils;

import dev.gostav.medievale.math.Vector;

public enum Direction {
    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    public static final Direction
            UP = NORTH,
            DOWN = SOUTH,
            RIGHT = EAST,
            LEFT = WEST;

    private int x, y;

    private Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Direction getDirection(Vector velocity) {
        return Direction.get(velocity.getX(), velocity.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getOpposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
        };
    }

    public Direction getClockwise() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public Direction getCounterClockwise() {
        return switch (this) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }

    public Direction getClockwise(int times) {
        Direction direction = this;
        for (int i = 0; i < times; i++) {
            direction = direction.getClockwise();
        }
        return direction;
    }

    public Direction getCounterClockwise(int times) {
        Direction direction = this;
        for (int i = 0; i < times; i++) {
            direction = direction.getCounterClockwise();
        }
        return direction;
    }

    public static Direction get(double x, double y) {
        if (Math.abs(x) >= Math.abs(y)) {
            return x < 0 ? Direction.WEST : Direction.EAST;
        }

        return y < 0 ? Direction.NORTH : Direction.SOUTH;
    }

    public static Direction get(int x, int y) {
        return Direction.get((double) x, (double) y);
    }
}
