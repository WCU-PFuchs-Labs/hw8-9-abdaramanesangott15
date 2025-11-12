import gp.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class TestGeneration {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine().trim();
        Generation g = new Generation(500, 3, file);
        g.evalAll();
        g.printBestTree();
        g.printBestFitness();
        ArrayList<GPTree> top = g.getTopTen();
        System.out.print("Top Ten Fitness Values: ");
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 0; i < top.size(); i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(df.format(top.get(i).getFitness()));
        }
        System.out.println();
    } 
}
