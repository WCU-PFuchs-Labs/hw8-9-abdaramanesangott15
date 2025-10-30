package gp;

public class GPTree {
    private final String expr;
    private double fitness;

    public GPTree(String expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return expr; 
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
}
