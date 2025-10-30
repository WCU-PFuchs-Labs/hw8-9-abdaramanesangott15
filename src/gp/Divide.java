package gp;
public final class Divide extends Binop {
    public Divide(Node l, Node r) { super(l, r); }
    protected double apply(double a, double b) { return b == 0 ? 0 : a / b; }
    protected String symbol() { return "/"; }
    protected Binop create(Node l, Node r) { return new Divide(l, r); }
}
