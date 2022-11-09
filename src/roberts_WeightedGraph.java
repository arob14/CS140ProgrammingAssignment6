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
        java.util.PriorityQueue<VertexWithWeight> minPriorityQueueByWeight = new java.util.PriorityQueue<>(vertices.size(), new VertexWithWeightWeightComparator());
        VertexWithWeight[] verticeCost = new VertexWithWeight[vertices.size()];
        int[] parent = new int[vertices.size()];

        for (int i = 0; i < vertices.size(); i++) {
            parent[i] = -1;
            verticeCost[i] = new VertexWithWeight(vertices.get(i), Double.POSITIVE_INFINITY);
        }
        parent[vertices.get(fromVertex)] = fromVertex;
        verticeCost[vertices.get(vertices.get(fromVertex))] = new VertexWithWeight(vertices.get(fromVertex), 0.0);

        for (int i = 0; i < vertices.size(); i++) {
            minPriorityQueueByWeight.add(verticeCost[i]);
        }

        while (minPriorityQueueByWeight.size() > 0) {
            VertexWithWeight currentVertex = minPriorityQueueByWeight.poll();
            int v = currentVertex.getVertex();
            if (parent[v] == -1) {
                break;
            }
            if (v == toVertex) {
                break;
            }

            for (EdgeWithWeight currentEdge : edges) {
                if(v == currentEdge.getFromVertex()) {
                    if (currentVertex.getWeight() + currentEdge.getWeight() < currentEdge.getWeight()) {

                    }
                }
            }
        }



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
