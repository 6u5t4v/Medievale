package dev.gostav.medievale.gfx;

public class Color {
    public static int map(int d) {
        if (d < 0) {
            return 0;
        }

        return ((d / 100) % 10) * 36 + ((d / 10) % 10) * 6 + (d % 10);
    }
}
