package tabular;

import java.util.Arrays;

public final class DataRow {
    private final double y;
    private final double[] x;

    public DataRow(double y, double[] x) {
        this.y = y;
        this.x = Arrays.copyOf(x, x.length);
    }

    public double getY() { return y; }

    public double[] getX() { return Arrays.copyOf(x, x.length); }

    @Override
    public String toString() {
        return "y=" + y + ", x=" + Arrays.toString(x);
    }
}
