package graph;

import java.util.LinkedList;

public class Graph {
    private int totalVertexes;
    private int totalEdges = 0;
    private LinkedList<Integer> adj[];

    public Graph(int totalVertexes) {
        this.totalVertexes = totalVertexes;
        adj = new LinkedList[totalVertexes + 1];
        for (int i = 0; i <= totalVertexes; i++)
            adj[i] = new LinkedList();
    }

    public Graph(Graph other) {
        totalVertexes = other.totalVertexes;
        totalEdges = other.totalEdges;
        adj = new LinkedList[totalVertexes + 1];
        for (int v = 0; v < totalVertexes; v++) {
            adj[v] = new LinkedList();
            for (int w : other.adj[v])
                adj[v].add(w);
        }
    }

    public void addEdge(int v, int w) {
        if (existsEdge(v, w))
            return;
        totalEdges++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public void removeEdge(int v, int w) {
        if (!existsEdge(v, w))
            return;
        adj[v].remove((Object) v);
        adj[w].remove((Object) v);
        if (getDegree(v) == 0)
            totalVertexes--;
        if (getDegree(w) == 0)
            totalVertexes--;
        totalEdges--;
    }

    public void removeVertex(int v) {
        for (int w = 0; w < totalVertexes; w++) {
            removeEdge(v, w);
        }
    }

    public boolean existsEdge(int v, int w) {
        if (adj[v].contains(w))
            return true;
        return false;
    }

    public int getDegree(int v) {
        return adj[v].size();
    }

    public boolean isVertexCover(Graph graph) {
        if (graph.totalEdges == totalEdges)
            return true;
        return false;
    }

    public boolean isVertexCover(LinkedList<Integer> list) {
        int nrEdges = 0;
        LinkedList<Integer> visited = new LinkedList<>();
        for (int v : list) {
            for (int w : adj[v])
                if (!visited.contains(w))
                    nrEdges++;
            visited.add(v);
        }
        if (nrEdges == totalEdges)
            return true;
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        s += totalVertexes + " vertices, " + totalEdges + " edges\n";
        for (int v = 0; v < totalVertexes; v++) {
            s += v + ": ";
            for (int w : adj[v])
                s += w + " ";
            s += "\n";
        }
        return s;
    }

    public String showVertexes() {
        String s = "";
        for (int v = 0; v < totalVertexes; v++) {
            s += v + " ";
        }
        s += "\n";
        return s;
    }

    public LinkedList<Integer> getAdj(int v) {
        return adj[v];
    }

    public int getTotalEdges() {
        return totalEdges;
    }

    public int getTotalVertexes() {
        return totalVertexes;
    }
}
