package mst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class MSTTest {
    @Test
    public void testMSTCostEquality() {
        Graph g = Graph.randomGraph(6, 1.0, 20.0, new Random(1));
        MSTResult kr = KruskalMST.run(g);
        MSTResult pr = PrimMST.run(g);
        assertEquals(Math.round(kr.totalCost * 1000),
                     Math.round(pr.totalCost * 1000),
                     "Prim and Kruskal should produce same MST cost");
    }

    @Test
    public void testDisconnectedGraph() {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 2.0);
        MSTResult kr = KruskalMST.run(g);
        assertTrue(kr.mstEdges.size() < g.V - 1);
    }
}
