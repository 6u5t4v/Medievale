package level.generators;

import level.Level;
import level.WorldGenerator;

public class Overworld extends LevelGenerator {
    public Overworld(Level level) {
        super(level);
    }

    private void base() {
        double[][] heightMap = WorldGenerator.generateWorld(
                this.level.getWidth(),
                this.level.getHeight(),
                64,
                3,
                0.5,
                2.0,
                this.level.getSeed()
        );

        for (int y = 0; y < this.level.getHeight(); y++) {
            for (int x = 0; x < this.level.getWidth(); x++) {
                double height = heightMap[y][x];

                if (height < 0.5) {
                    if(height < 0.1){
                        this.level.setTile(x, y, 0);
                    } else {
                        this.level.setTile(x, y, 1);
                    }
                } else {
                    this.level.setTile(x, y, 2);
                }

//                if (height < 0.2) {
//                    // WATER
//                    this.level.setTile(x, y, 0);
//                } else if (height < 0.3) {
//                    // SAND
//                    this.level.setTile(x, y, 1);
//                } else if (height < 0.5) {
//                    // GRASS
//                    this.level.setTile(x, y, 2);
//                } else if (height < 0.7) {
//                    // DIRT
//                    this.level.setTile(x, y, 3);
//                } else {
//                    // STONE
//                    this.level.setTile(x, y, 4);
//                }
            }
        }
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
