package level.generators;

import level.Level;
import level.noise.OpenSimplexNoise;

import java.util.Random;

public abstract class LevelGenerator {
    protected Level level;
    protected OpenSimplexNoise osn;
    protected Random random;

    public LevelGenerator(Level level) {
        this.level = level;
        this.osn = new OpenSimplexNoise(level.getSeed());
        this.random = new Random(level.getSeed());
    }

    public static LevelGenerator getGenerator(Level level) {
        return switch (level.getDepth()) {
            case 0 -> new Overworld(level);
            default -> throw new IllegalStateException("Unexpected value: " + level.getDepth());
        };
    }

    protected void setProgress(String text, double progress) {
        System.out.println(text + " " + progress);
    }

    public abstract void generate();
}
