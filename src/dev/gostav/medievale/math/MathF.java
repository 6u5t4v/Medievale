package dev.gostav.medievale.math;

public class MathF {
    public static int clamp(int x, int min, int max) {
        return Math.max(min, Math.min(max, x));
    }
}
