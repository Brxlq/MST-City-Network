Analytical Report – Optimization of a City Transportation Network (MST)
Student: Yerkebulan Sovet
Group: SE-2430

1. Summary of Input Data and Results
Three datasets represent small, medium, and large city networks.
Each vertex represents a city district, and each weighted edge represents a potential road with a construction cost.

| DATASET | VERTICES | EDGES | ALGORITHM | MST COST | TIME (MS) | COMPARISON |
|:--------:|:--------:|:--------:|:--------:|:--------:|:--------:|:--------:|
|    1     |     5     |    4      |     Kruskal     |  40        |     0     |    4      |
|    1      |     5     |     4     |     Prim     |    40      |      3    |     8     |
|    2      |    12      |    15      |    Kruskal      |    185      |    0      |     15     |
|    2      |    12      |    15      |    Prim      |     185     |     0     |     30     |
|    3      |    25      |     38     |    Kruskal      |     1055     |     0     |     38     |
|    3      |    25      |     38     |    Prim      |    1055      |    0      |     76     |


Both algorithms produced identical MST costs for every dataset, confirming correctness.

###2. Comparison Between Prim’s and Kruskal’s Algorithms

| CRITERION | KRUSKAL'S ALGORITHM | PRIM'S ALGORITHM |
|:---------:|:------------------:|:---------------:|
| Approach | Sorts all edges by weight and connects disjoint sets using DSU. | Expands MST from one vertex using a priority queue. |
| Best for | Sparse graphs (few edges). | Dense graphs (many edges). |
| Time Complexity | O(E log E) | O(E log V) |
| Main Data Structure | Disjoint Set Union (DSU). | Priority Queue (Heap). |
| Performance (in tests) | Fewer comparisons and simpler structure. | Slightly more comparisons and PQ operations. |
| Practical Result | Efficient for sparse city networks. | Better for dense urban networks. |

###3. Discussion
- In all test cases, Prim’s and Kruskal’s algorithms produced MSTs with the same total cost.  
- The difference lies in how they reach that result:  
  - Kruskal performs fewer comparisons since it primarily sorts edges once and connects components using DSU.  
  - Prim executes more priority queue operations but handles dense graphs more efficiently.  
- On small datasets, both algorithms performed almost instantly (0–3 ms).  
- As the number of vertices increased, the number of operations grew, but MST cost remained consistent.


4. Conclusions
1.	Both algorithms correctly build the MST and guarantee minimal total road cost.
2.	Kruskal’s algorithm is simpler and faster for sparse networks (fewer connections)
3.	Prim’s algorithm scales better on dense networks (many edges).
4.	For real-world city transportation systems, Prim’s algorithm is generally preferred due to graph density and adjacency list efficiency.

5. Appendix – MST Visualizations
Figure 1. MST for Small Graph (5 vertices)
Figure 2. MST for Medium Graph (12 vertices)
Figure 3. MST for Large Graph (25 vertices)

Summary
1.	Implemented and tested both algorithms
2.	Identical MST costs achieved
3.	Comparative performance analyzed
4.	Output saved to summary.csv and output_results.json
