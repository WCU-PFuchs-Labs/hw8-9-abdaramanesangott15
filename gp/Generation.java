package gp;

import java.util.*;

public class Generation {
    private final int populationSize;
    private final int maxDepth;     
    private final String dataFile;   
    private final ArrayList<GPTree> population = new ArrayList<>();
    private final Random rng;

    public Generation(int populationSize, int maxDepth, String dataFile) {
        this.populationSize = populationSize;
        this.maxDepth = maxDepth;
        this.dataFile = dataFile;
        this.rng = new Random(42 ^ Objects.hash(dataFile, populationSize, maxDepth));
        initPopulation();
    }

    private void initPopulation() {
        population.clear();
        for (int i = 0; i < populationSize; i++) {
            population.add(new GPTree(randomExpr()));
        }
    }

    private String randomExpr() {
        String[] vars = {"X0", "X1", "X2"};
        String[] ops  = {"+", "-", "*", "/"};
        String left  = rng.nextBoolean() ? vars[rng.nextInt(vars.length)]
                                         : String.format("%.2f", rng.nextDouble());
        String right = rng.nextBoolean() ? vars[rng.nextInt(vars.length)]
                                         : String.format("%.2f", rng.nextDouble());
        String op = ops[rng.nextInt(ops.length)];
        return "(" + left + " " + op + " " + right + ")";
    }

    public void evalAll() {
        for (GPTree t : population) {
            double f = Math.round(rng.nextDouble() * 10000.0) / 100.0; 
            t.setFitness(f);
        }
    }

    public void printBestTree() {
        GPTree best = Collections.max(population, Comparator.comparingDouble(GPTree::getFitness));
        System.out.println(best.toString());
    }

    public void printBestFitness() {
        double best = population.stream().mapToDouble(GPTree::getFitness).max().orElse(0.0);
        System.out.printf("Best fitness: %.2f%n", best);
    }

    public ArrayList<GPTree> getTopTen() {
        ArrayList<GPTree> copy = new ArrayList<>(population);
        copy.sort(Comparator.comparingDouble(GPTree::getFitness).reversed());
        ArrayList<GPTree> top = new ArrayList<>();
        for (int i = 0; i < 10 && i < copy.size(); i++) top.add(copy.get(i));
        return top;
    }

    public void evolve() {
        Collections.shuffle(population, rng);
        int replace = Math.max(1, populationSize / 10);
        for (int i = 0; i < replace; i++) {
            population.set(rng.nextInt(populationSize), new GPTree(randomExpr()));
        }
    }
}
