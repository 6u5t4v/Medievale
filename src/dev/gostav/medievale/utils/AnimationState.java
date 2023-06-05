package dev.gostav.medievale.utils;

public enum AnimationState {
    IDLE(0),
    RUN(1),
    DEAD(2);

    private final int index;

    AnimationState(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
