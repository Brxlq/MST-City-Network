package mst;

import java.util.*;
import com.google.gson.annotations.SerializedName;

public class Graph {
    public int V;
    public List<Edge> edges;
    public List<List<Edge>> adj;

    public Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, double w) {
        Edge e = new Edge(u, v, w);
        edges.add(e);
        adj.get(u).add(e);
        adj.get(v).add(e);
    }

    public static class GraphJson {
        @SerializedName("V")
        public int V;
        @SerializedName("edges")
        public List<double[]> edges;
    }

    public static Graph fromJsonGraph(GraphJson gj) {
        Graph g = new Graph(gj.V);
        if (gj.edges != null) {
            for (double[] e : gj.edges) {
                g.addEdge((int)e[0], (int)e[1], e[2]);
            }
        }
        return g;
    }

    public static Graph randomGraph(int V, double density, double maxWeight, Random rnd) {
        Graph g = new Graph(V);
        for (int u = 0; u < V; u++) {
            for (int v = u + 1; v < V; v++) {
                if (rnd.nextDouble() < density) {
                    g.addEdge(u, v, 1 + rnd.nextInt((int) maxWeight));
                }
            }
        }
        return g;
    }
}
