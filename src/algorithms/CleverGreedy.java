package algorithms;

import graph.Graph;

import java.util.LinkedList;

public class CleverGreedy {
    private Graph graph;
    private LinkedList<Integer> degreeList;
    private LinkedList<Integer> solution;
    private String name = "Clever Greedy";

    private static int TIMEOUT_MS = 60000;

    public CleverGreedy(Graph graph) {
        degreeList = new LinkedList<>();
        solution = new LinkedList<>();
        this.graph = graph;
    }

    public Output execute() {
        long startTime = System.currentTimeMillis();

        for (int v = 1; v <= graph.getTotalVertexes(); v++)
            if (graph.getDegree(v) > 0)
                degreeList.add(v);
        degreeList.sort((v1, v2) -> graph.getDegree(v2) - graph.getDegree(v1));

        Graph copy = new Graph(graph);
        while (copy.getTotalEdges() > 0 && !degreeList.isEmpty()) {
            int v = degreeList.removeFirst();
            solution.add(v);
            copy.removeVertex(v);
        }

        long endTime = System.currentTimeMillis();
        return new Output(name, endTime - startTime, solution.size(), solution);
    }
}
