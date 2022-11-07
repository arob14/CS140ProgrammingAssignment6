public class roberts_WeightedGraph implements WeightedGraphFunctions {
    private final java.util.ArrayList<EdgeWithWeight> edges;
    private final java.util.ArrayList<Integer> vertices;

    public roberts_WeightedGraph() {
        edges = new java.util.ArrayList<>();
        vertices = new java.util.ArrayList<>();
    }


    public boolean hasPath(int fromVertex, int toVertex) {
        return false;
    }


    public double getMinimumWeight(int fromVertex, int toVertex) {
        return 0;
    }


    public EdgeWithWeight[] getPath(int fromVertex, int toVertex) {
        return new EdgeWithWeight[0];
    }


    public boolean addVertex(int v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
            return true;
        }
        return false;
    }


    public boolean addWeightedEdge(int from, int to, double weight) {
        boolean bool = false;
        EdgeWithWeight edge = new EdgeWithWeight(from, to, weight);
        if (!edges.contains(edge)) {
            edges.add(edge);
            bool = true;
        }
        return bool;
    }
}
