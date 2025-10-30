package gp;

public final class Variable implements Node {
    private final int index;
    public Variable(int i) { index = i; }
    public double eval(double[] x) { return x[index]; }
    public Node clone() { return new Variable(index); }
    public String toString() { return "x" + index; }
}
