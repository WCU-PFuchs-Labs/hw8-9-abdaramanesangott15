package tabular;

import java.io.*;
import java.util.*;


public final class DataSet {
    private final List<DataRow> rows = new ArrayList<>();
    private int numFeatures = -1;

    public DataSet(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean headerSkipped = false;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (!headerSkipped && hasHeader(line)) { headerSkipped = true; continue; }
                String[] parts = line.split("\\s*,\\s*");
                if (numFeatures < 0) numFeatures = parts.length - 1;
                double y = Double.parseDouble(parts[0]);
                double[] x = new double[numFeatures];
                for (int i = 0; i < numFeatures; i++)
                    x[i] = Double.parseDouble(parts[i + 1]);
                rows.add(new DataRow(y, x));
            }
        }
    }

    private boolean hasHeader(String firstLine) {
        for (String p : firstLine.split(",")) {
            try { Double.parseDouble(p.trim()); }
            catch (NumberFormatException e) { return true; }
        }
        return false;
    }

    public List<DataRow> getRows() { return new ArrayList<>(rows); }
    public int size() { return rows.size(); }
    public int numFeatures() { return numFeatures; }
}
