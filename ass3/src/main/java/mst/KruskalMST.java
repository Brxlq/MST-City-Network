package mst;

import java.util.*;

public class KruskalMST {
    public static MSTResult run(Graph g) {
        MSTResult res = new MSTResult();
        res.vertices = g.V;
        res.edges = g.edges.size();
        long comps = 0;
        long start = System.nanoTime();

        List<Edge> sorted = new ArrayList<>(g.edges);
        Collections.sort(sorted);
        DSU dsu = new DSU(g.V);

        for (Edge e : sorted) {
            comps++;
            if (dsu.union(e.u, e.v)) {
                res.mstEdges.add(e);
                res.totalCost += e.w;
            }
            if (res.mstEdges.size() == g.V - 1) break;
        }

        long end = System.nanoTime();
        res.timeMs = (end - start) / 1_000_000;
        res.comparisons = comps;
        res.unions = dsu.unions;
        return res;
    }
}
