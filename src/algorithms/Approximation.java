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
        this.graph = graph;
    }

    public Output execute() {
        long startTime = System.currentTimeMillis();

        LinkedList<Integer> solution = new LinkedList<>();
        try {
            for (int v = 1; v <= graph.getTotalVertexes(); v++) {
                if (!solution.contains(v)) {
                    solution.add(v);
                    for (int w : graph.getAdj(v))
                        if (!solution.contains(w)) {
                            solution.add(v);
                            solution.add(w);
                        }
                }
                if (System.currentTimeMillis() - startTime >= TIMEOUT_MS)
                    throw new Exception("TIMEOUT");
            }
            long endTime = System.currentTimeMillis();
            return new Output(name, endTime - startTime, solution.size(), solution);
        } catch (Exception e) {
            if (e.getMessage().equals("TIMEOUT"))
                return new Output(name, -1, 0, null);
        }
        return null;
    }
}
