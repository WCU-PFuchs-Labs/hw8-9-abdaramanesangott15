package gp;

public final class Const implements Node {
    private final double value;

    public Const(double v) { value = v; }
    public double eval(double[] x) { return value; }
    public Node clone() { return new Const(value); }
    public String toString() { return String.format("%.3f", value); }
}
