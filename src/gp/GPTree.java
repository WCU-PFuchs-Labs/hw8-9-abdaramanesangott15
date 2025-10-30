package gp;

import tabular.*;

import java.util.*;

public final class GPTree implements Comparable<GPTree>, Cloneable {
    private Node root;
    private double fitness = Double.POSITIVE_INFINITY;

    public GPTree(Node r) { root = r; }
    public double eval(double[] x) { return root.eval(x); }

    public void evalFitness(DataSet data) {
        double sum = 0;
        for (DataRow row : data.getRows()) {
            double diff = eval(row.getX()) - row.getY();
            sum += diff * diff;
        }
        fitness = sum;
    }

    public double getFitness() { return fitness; }
    public int compareTo(GPTree t) { return Double.compare(this.fitness, t.fitness); }

    public boolean equals(Object o) {
        return (o instanceof GPTree) && compareTo((GPTree)o) == 0;
    }

    public GPTree clone() {
        GPTree g = new GPTree(root.clone());
        g.fitness = fitness;
        return g;
    }

    public String toString() { return root.toString(); }
}
