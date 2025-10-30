package gp;
import java.util.Random;

public final class RandomTreeFactory {
    private final int numVars;
    private final Random rand;
    public RandomTreeFactory(int numVars, long seed) {
        this.numVars = Math.max(1, numVars);
        this.rand = new Random(seed);
    }
    public Node randomTree(int depth) {
        if (depth == 0) {
            if (rand.nextBoolean()) return new Variable(rand.nextInt(numVars));
            return new Const(rand.nextDouble() * 2 - 1);
        }
        Node l = randomTree(depth - 1);
        Node r = randomTree(depth - 1);
        switch (rand.nextInt(4)) {
            case 0: return new Plus(l, r);
            case 1: return new Minus(l, r);
            case 2: return new Mult(l, r);
            default: return new Divide(l, r);
        }
    }
    public Random rng() { return rand; }
}
