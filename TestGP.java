import gp.*;
import java.io.*;

public class TestGP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine().trim();
        Generation g = new Generation(500, 3, file);
        g.evalAll();
        for (int i = 1; i <= 50; i++) {
            System.out.println("Generation " + i + ":");
            g.printBestTree();
            g.printBestFitness();
            g.evolve();
            g.evalAll();
        }
    }
}
