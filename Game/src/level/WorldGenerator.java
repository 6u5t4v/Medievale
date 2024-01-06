package level;

import level.noise.OpenSimplexNoise;

public class WorldGenerator {
    public static double[][] generateWorld(int width, int height, double scale, int octaves, double persistence, double lacunarity, long seed) {
        double[][] world = new double[width][height];
        OpenSimplexNoise noise = new OpenSimplexNoise(seed);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double amplitude = 1.0;
                double frequency = 1.0;
                double noiseHeight = 0.0;

                for (int k = 0; k < octaves; k++) {
                    double sampleX = i / scale * frequency;
                    double sampleY = j / scale * frequency;
                    double perlinValue = noise.eval(sampleX, sampleY);
                    noiseHeight += perlinValue * amplitude;

                    amplitude *= persistence;
                    frequency *= lacunarity;
                }

                world[i][j] = noiseHeight;
            }
        }

        return world;
    }
}
