package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Output {
    String algorithm;
    long time;
    int K;
    List<Integer> vertexes;

    public Output(String algorithm, long time, int K, List<Integer> vertexes) {
        this.algorithm = algorithm;
        this.time = time;
        this.K = K;
        this.vertexes = new ArrayList<Integer>();
        try {
            for (int v : vertexes) {
                this.vertexes.add(v + 1);
            }
        } catch (Exception e) {}
    }

    @Override
    public String toString() {
        if (time == -1)
            return "TIMEOUT for " + algorithm + ": execution time has exceeded the time limit of 60 000 miliseconds (1 minute)";
        String s = algorithm + " completed in " + time + " miliseconds\n" + K + "\n";
        for (int v : vertexes) {
            s += v + " ";
        }
        s += "\n";
        return s;
    }
}
