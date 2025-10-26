package mst;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Random rnd = new Random(42);

        List<Graph> datasets = List.of(
            Graph.randomGraph(5, 0.6, 20.0, rnd), 
            Graph.randomGraph(12, 0.3, 50.0, rnd),
            Graph.randomGraph(25, 0.15, 100.0, rnd) 
        );

        List<MSTResult> results = new ArrayList<>();
        System.out.println("===========================================");
        System.out.println("     Prim vs Kruskal MST Comparison");
        System.out.println("===========================================\n");

        int datasetIndex = 1;
        for (Graph g : datasets) {
            System.out.printf("Dataset %d: Vertices=%d, Edges=%d%n", datasetIndex, g.V, g.edges.size());

            MSTResult kruskal = KruskalMST.run(g);
            results.add(kruskal);

            MSTResult prim = PrimMST.run(g);
            results.add(prim);

            System.out.println("  Kruskal  " + kruskal);
            System.out.println("  Prim    " + prim + "\n");

            datasetIndex++;
        }

        JSONUtils.writeResults(results, "output_results.json");
        System.out.println(" JSON results saved to: output_results.json");

        try (PrintWriter pw = new PrintWriter(new FileWriter("summary.csv"))) {
            pw.println("dataset,algorithm,vertices,edges,mst_cost,time_ms,comparisons,pqOps,unions");
            int i = 1;
            for (int j = 0; j < results.size(); j += 2) { 
                MSTResult kr = results.get(j);
                MSTResult pr = results.get(j + 1);
                pw.printf("%d,Kruskal,%d,%d,%.2f,%d,%d,%d,%d%n",
                        i, kr.vertices, kr.edges, kr.totalCost, kr.timeMs,
                        kr.comparisons, kr.pqOps, kr.unions);
                pw.printf("%d,Prim,%d,%d,%.2f,%d,%d,%d,%d%n",
                        i, pr.vertices, pr.edges, pr.totalCost, pr.timeMs,
                        pr.comparisons, pr.pqOps, pr.unions);
                i++;
            }
        }

        System.out.println(" CSV summary saved to: summary.csv");
    }
}
