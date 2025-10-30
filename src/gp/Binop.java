package gp;

public abstract class Binop implements Node {
    protected Node left, right;
    protected Binop(Node l, Node r) { left = l; right = r; }
    protected abstract double apply(double a, double b);
    protected abstract String symbol();
    protected abstract Binop create(Node l, Node r);
    public double eval(double[] x) { return apply(left.eval(x), right.eval(x)); }
    public Node clone() { return create(left.clone(), right.clone()); }
    public String toString() { return "(" + left + " " + symbol() + " " + right + ")"; }
}
