package algorithms;

import graph.Graph;

import java.util.LinkedList;

public class CleverGreedy {
    private Graph graph;
    private LinkedList<Integer> solution;
    private String name = "Clever Greedy";

    private static int TIMEOUT_MS = 60000;

    public CleverGreedy(Graph graph) {
        solution = new LinkedList<>();
        this.graph = graph;
    }

    public Output execute() {
        long startTime = System.currentTimeMillis();

        try {
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
                    throw new Exception("TIMEOUT");
            }
        } catch (Exception e) {
            if (e.getMessage().equals("TIMEOUT"))
                return new Output(name, -1, 0, null);
        }
        long endTime = System.currentTimeMillis();
        return new Output(name, endTime - startTime, solution.size(), solution);
    }
}
