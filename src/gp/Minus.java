package gp;
public final class Minus extends Binop {
    public Minus(Node l, Node r) { super(l, r); }
    protected double apply(double a, double b) { return a - b; }
    protected String symbol() { return "-"; }
    protected Binop create(Node l, Node r) { return new Minus(l, r); }
}
