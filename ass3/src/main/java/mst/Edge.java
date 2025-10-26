package mst;

public class Edge implements Comparable<Edge> {
    public final int u;
    public final int v;
    public final double w;

    public Edge(int u, int v, double w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.w, o.w);
    }

    @Override
    public String toString() {
        return String.format("(%d-%d: %.2f)", u, v, w);
    }
}
