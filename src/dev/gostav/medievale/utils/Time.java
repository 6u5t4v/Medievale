package dev.gostav.medievale.utils;

public class Time {
    public static final long FRAME_TIME = 1000000000L;
    public static final long TICK_TIME = 1000000L;

    private static final int TPS = 120;
    public static final long FRAMES_PER_TICK = FRAME_TIME / TPS;

    public static long now() {
        return System.nanoTime();
    }
}
