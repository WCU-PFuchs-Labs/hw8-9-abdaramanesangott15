package gp;
public final class Plus extends Binop {
    public Plus(Node l, Node r) { super(l, r); }
    protected double apply(double a, double b) { return a + b; }
    protected String symbol() { return "+"; }
    protected Binop create(Node l, Node r) { return new Plus(l, r); }
}
