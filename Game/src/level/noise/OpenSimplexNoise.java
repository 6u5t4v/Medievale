package level.noise;

import java.util.Random;

public class OpenSimplexNoise {
    private int[] perm = new int[512];
    private double[] gradients = new double[512 * 3];

    private static final long DEFAULT_SEED = 0;

    public OpenSimplexNoise() {
        this(DEFAULT_SEED);
    }

    public OpenSimplexNoise(long seed) {
        setSeed(seed);
    }


    public void setSeed(long seed) {
        perm = generatePerm(seed);
        gradients = generateGradients(seed);
    }

    private int[] generatePerm(long seed) {
        int[] perm = new int[512];
        int[] p = new int[256];
        for (int i = 0; i < 256; i++) {
            p[i] = i;
        }
        Random random = new Random(seed);
        for (int i = 0; i < 256; i++) {
            int j = random.nextInt(i + 1);
            int temp = p[i];
            p[i] = p[j];
            p[j] = temp;
        }
        System.arraycopy(p, 0, perm, 0, 256);
        System.arraycopy(p, 0, perm, 256, 256);
        return perm;
    }

    private double[] generateGradients(long seed) {
        double[] gradients = new double[512 * 3];
        Random random = new Random(seed);
        for (int i = 0; i < 256; i++) {
            double x = random.nextDouble() * 2 - 1;
            double y = random.nextDouble() * 2 - 1;
            double z = random.nextDouble() * 2 - 1;
            double len = Math.sqrt(x * x + y * y + z * z);
            x /= len;
            y /= len;
            z /= len;
            gradients[i * 3] = x;
            gradients[i * 3 + 1] = y;
            gradients[i * 3 + 2] = z;
            gradients[(i + 256) * 3] = x;
            gradients[(i + 256) * 3 + 1] = y;
            gradients[(i + 256) * 3 + 2] = z;
        }
        return gradients;
    }

    public double eval(double x, double y) {
        double stretchOffset = (x + y) * 0.366025403784439f;
        double xs = x + stretchOffset;
        double ys = y + stretchOffset;

        int xsb = fastFloor(xs);
        int ysb = fastFloor(ys);

        double squishOffset = (xsb + ysb) * 0.211324865405187f;
        double dx0 = x - (xsb - squishOffset);
        double dy0 = y - (ysb - squishOffset);

        double xins = xs - xsb;
        double yins = ys - ysb;

        double inSum = xins + yins;

        int hash = ((int) (xins - yins) + 1) | ((int) inSum << 1) | ((int) (inSum + yins + 2));

        double[] gradients = this.gradients;

        double value = 0;
        if (hash < 0 || hash >= gradients.length / 3) {
            return value;
        }

        double dx1 = dx0 - 1 - 2 * squishOffset;
        double dy1 = dy0 - 0 - 2 * squishOffset;

        double attn0 = 2 - dx0 * dx0 - dy0 * dy0;
        if (attn0 > 0) {
            attn0 *= attn0;
            value += attn0 * attn0 * dot(gradients, hash, dx0, dy0);
        }

        double attn1 = 2 - dx1 * dx1 - dy1 * dy1;
        if (attn1 > 0) {
            attn1 *= attn1;
            value += attn1 * attn1 * dot(gradients, hash + 1, dx1, dy1);
        }

        return value;
    }

    private static int fastFloor(double x) {
        int xi = (int) x;
        return x < xi ? xi - 1 : xi;
    }

    private static double dot(double[] gradients, int hash, double x, double y) {
        int g = hash * 3;
        return gradients[g] * x + gradients[g + 1] * y;
    }
}

