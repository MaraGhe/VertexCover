package algorithms;

import graph.Graph;

import java.util.LinkedList;

public class CleverGreedy {
    private Graph graph;
    private LinkedList<Integer> degreeList;
    private LinkedList<Integer> solution;
    private String name = "Clever Greedy";


    public CleverGreedy(Graph graph) {
        solution = new LinkedList<>();
        this.graph = graph;
    }

    public Output execute() {
        long startTime = System.currentTimeMillis();

        degreeList = new LinkedList<>();
        for (int v = 1; v <= graph.getTotalVertexes(); v++)
            if (graph.getDegree(v) > 0)
                degreeList.add(v);
        degreeList.sort((v1, v2) -> graph.getDegree(v2) - graph.getDegree(v1));

        Graph copy = new Graph(graph);
        while (copy.getTotalEdges() > 0 && !degreeList.isEmpty()) {
            int v = degreeList.removeFirst();
            if (copy.getDegree(v) > 0) {
                solution.add(v);
                copy.removeVertex(v);

                // update the list of degrees after a vertex removal
                degreeList = new LinkedList<>();
                for (int w = 1; w <= graph.getTotalVertexes(); w++)
                    if (graph.getDegree(w) > 0 && !solution.contains(w))
                        degreeList.add(w);
                degreeList.sort((v1, v2) -> copy.getDegree(v2) - copy.getDegree(v1));
            } else {
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        return new Output(name, endTime - startTime, solution.size(), solution);
    }
}
