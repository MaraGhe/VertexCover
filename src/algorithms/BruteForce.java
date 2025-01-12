package algorithms;

import graph.Graph;
import java.util.LinkedList;

public class BruteForce {
    private Graph graph;
    private LinkedList<Integer> solution;
    private String name = "Backtracking (brute force)";

    private static int TIMEOUT_MS = 60000;

    public BruteForce(Graph graph) {
        this.graph = graph;
        solution = new LinkedList<>();
    }

    public Output execute() {
        long startTime = System.currentTimeMillis();

        LinkedList<Integer> solution = new LinkedList<>();
        try {
            backtrack(graph, new LinkedList<>(), solution, startTime);

            long endTime = System.currentTimeMillis();
            return new Output(name, endTime - startTime, solution.size(), solution);
        } catch (Exception e) {
            if (e.getMessage().equals("TIMEOUT"))
                return new Output(name, -1, 0, null);
        }
        return null;
    }

    private void backtrack(Graph graph, LinkedList<Integer> list,
                           LinkedList<Integer> solution, long startTime) throws Exception {
        if (System.currentTimeMillis() - startTime >= TIMEOUT_MS)
            throw new Exception("TIMEOUT");
        if (graph.isVertexCover(list) && (solution.size() == 0 || list.size() < solution.size())) {
            solution.clear();
            for (int v : list)
                solution.add(v);
            return;
        }
        for (int v = 0; v < graph.getTotalVertexes(); v++) {
            if (!list.contains(v)) {
                list.add(v);
                backtrack(graph, list, solution, startTime);
                list.removeLast();
            }
        }
    }
}
