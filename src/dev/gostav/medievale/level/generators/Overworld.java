package dev.gostav.medievale.level.generators;

import dev.gostav.medievale.level.Level;

public class Overworld extends LevelGenerator {
    public Overworld(Level level) {
        super(level);
    }

    private void base() {

    }

    private void erode() {

    }

    private void smooth() {

    }

    private void decorate() {

    }

    @Override
    public void generate() {
        this.setProgress("LEVEL " + this.level.getDepth() + ":FORMING...", 0.0);
        this.base();

        this.setProgress("LEVEL " + this.level.getDepth() + ":ERODING...", 0.0);
        this.erode();

        this.setProgress("LEVEL " + this.level.getDepth() + ":PLANTING...", 0.0);
        this.decorate();
    }
}
