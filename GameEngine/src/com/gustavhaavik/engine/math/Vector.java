package com.gustavhaavik.engine.math;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    public Vector subtract(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }

    public Vector multiply(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar);
    }

    public Vector divide(double scalar) {
        if (scalar != 0) {
            return new Vector(this.x / scalar, this.y / scalar);
        }
        throw new IllegalArgumentException("Cannot divide by zero.");
    }

    public double dotProduct(Vector other) {
        return this.x * other.x + this.y * other.y;
    }

    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector normalize() {
        double magnitude = magnitude();
        if (magnitude != 0) {
            return divide(magnitude);
        }
        throw new ArithmeticException("Cannot normalize zero vector.");
    }

    public Vector normalized() {
        return new Vector(x, y).normalize();
    }

    public double distance(Vector other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double angle() {
        return Math.atan2(this.y, this.x);
    }

    public Vector rotate(double angle) {
        double cosTheta = Math.cos(angle);
        double sinTheta = Math.sin(angle);
        double newX = this.x * cosTheta - this.y * sinTheta;
        double newY = this.x * sinTheta + this.y * cosTheta;
        return new Vector(newX, newY);
    }

    public static Vector Zero() {
        return new Vector(0, 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector other) {
            return this.x == other.x && this.y == other.y;
        }

        return false;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
