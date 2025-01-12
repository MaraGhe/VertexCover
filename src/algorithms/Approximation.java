package algorithms;

import graph.Graph;

import java.util.LinkedList;
import java.util.List;

public class Approximation {
    private Graph graph;
    private LinkedList<Integer> solution;
    private String name = "Approximation";

    private static int TIMEOUT_MS = 60000;

    public Approximation(Graph graph) {
        solution = new LinkedList<>();
        this.graph = graph;
    }

    public Output execute() {
        long startTime = System.currentTimeMillis();

        for (int v = 1; v <= graph.getTotalVertexes(); v++) {
            if (!solution.contains(v)) {
                for (int w : graph.getAdj(v))
                    if (!solution.contains(w)) {
                        solution.add(v);
                        solution.add(w);
                        break;
                    }
            }
            if (System.currentTimeMillis() - startTime >= TIMEOUT_MS)
                return new Output(name, -1, 0, null);
        }
        long endTime = System.currentTimeMillis();
        return new Output(name, endTime - startTime, solution.size(), solution);
    }
}
