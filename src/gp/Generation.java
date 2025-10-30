package gp;

import tabular.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public final class Generation {
    private final GPTree[] pop;
    private final DataSet data;
    private final RandomTreeFactory fact;
    private final Random rand;

    public Generation(int size, int depth, String file) throws IOException {
        data = new DataSet(file);
        fact = new RandomTreeFactory(data.numFeatures(), System.nanoTime());
        rand = fact.rng();
        pop = new GPTree[size];
        for (int i = 0; i < size; i++) pop[i] = new GPTree(fact.randomTree(depth));
    }

    public void evalAll() {
        for (GPTree t : pop) t.evalFitness(data);
        Arrays.sort(pop);
    }

    public ArrayList<GPTree> getTopTen() {
        ArrayList<GPTree> a = new ArrayList<>();
        for (int i = 0; i < Math.min(10, pop.length); i++) a.add(pop[i]);
        return a;
    }

    public void printBestFitness() {
        System.out.println("Best Fitness: " + new DecimalFormat("0.00").format(pop[0].getFitness()));
    }

    public void printBestTree() { System.out.println("Best Tree: " + pop[0]); }

    public void evolve() {
        GPTree[] next = new GPTree[pop.length];
        int elite = Math.max(1, pop.length / 20);
        for (int i = 0; i < elite; i++) next[i] = pop[i].clone();
        for (int i = elite; i < pop.length; i++) {
            next[i] = new GPTree(fact.randomTree(3));
        }
        System.arraycopy(next, 0, pop, 0, pop.length);
    }
}
