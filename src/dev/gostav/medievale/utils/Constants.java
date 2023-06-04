package dev.gostav.medievale.utils;

public class Constants {
    // TODO make this an enum
    public static class PlayerConstants {
        public static final int RUNNING = 0;
        public static final int IDLE = 1;
        public static final int ATTACKING = 2;
        public static final int DEATH = 3;

        public static int GetSpriteFrames(int animation) {
            return switch (animation) {
                case RUNNING, ATTACKING, DEATH, IDLE -> 4;
                default -> 0;
            };
        }
    }
}
