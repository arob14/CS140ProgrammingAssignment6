public class roberts_WeightedGraph implements WeightedGraphFunctions {
    private final java.util.ArrayList<EdgeWithWeight> edges;
    private final java.util.ArrayList<Integer> vertices;

    public roberts_WeightedGraph() {
        edges = new java.util.ArrayList<>();
        vertices = new java.util.ArrayList<>();
    }


    public boolean hasPath(int fromVertex, int toVertex) {
        boolean bool = false;
        return false;
    }


    public double getMinimumWeight(int fromVertex, int toVertex) {
        return 0;
    }

    @Override
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

    public String toString() {
        StringBuilder output = new StringBuilder("G=(V,E)\nV={");
        for(int i = 0; i < vertices.size(); i++) {
            if(i != vertices.size() - 1) {
                output.append(vertices.get(i)).append(",");
            }
            else {
                output.append(vertices.get(i));
            }
        }
        output.append("}\nE={");
        for(int i = 0; i < edges.size(); i++) {
            if (i != edges.size() - 1) {
                output.append(edges.get(i).toString()).append(",");
            }
            else {
                output.append(edges.get(i).toString());
            }
            output.append("}");
        }

        return output.toString();
    }
}
