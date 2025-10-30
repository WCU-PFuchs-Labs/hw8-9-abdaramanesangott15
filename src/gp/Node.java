package gp;

public interface Node extends Cloneable {
    double eval(double[] x);
    Node clone();
}
