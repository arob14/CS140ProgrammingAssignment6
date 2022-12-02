import java.util.ArrayList;

public class roberts_WeightedGraph implements WeightedGraphFunctions {
    private final ArrayList<EdgeWithWeight> edges;
    private final ArrayList<Integer> vertices;

    public roberts_WeightedGraph() {
        edges = new ArrayList<>();
        vertices = new ArrayList<>();
    }


	public boolean hasPath(int fromVertex, int toVertex) {
        return false;
    }


    public double getMinimumWeight(int fromVertex, int toVertex) {
        return Double.NaN;
    }
    private int indexOf(int v) {
    	int output = -1;
    	for(int i = 0; i < vertices.size(); i++) {
    		if (v == vertices.get(i)) {
    			output = i;
    		}
    	}
    	return output;
    }
    public EdgeWithWeight[] getPath(int fromVertex, int toVertex) {
        return new EdgeWithWeight[0];
    }

    private Object getPath(int fromVertex, int toVertex, WeightedGraphReturnType typeOfInfo) {
        java.util.PriorityQueue<VertexWithWeight> minPriorityQueueByWeight = new java.util.PriorityQueue<>(vertices.size(), new VertexWithWeightWeightComparator());
        VertexWithWeight[] verticeCost = new VertexWithWeight[vertices.size()];
        int[] parent = new int[vertices.size()];
        ArrayList<Integer> reversePath = new ArrayList<>();
        ArrayList<Integer> forwardPath = new ArrayList<>();
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
                    if (currentVertex.getWeight() + currentEdge.getWeight() < verticeCost[indexOf(v)].getWeight()) {
                    	minPriorityQueueByWeight.remove(currentVertex);
                    	verticeCost[indexOf(v)].setWeight(currentVertex.getWeight() + currentEdge.getWeight());
                    	currentVertex.setWeight(currentVertex.getWeight() + currentEdge.getWeight());
                    	minPriorityQueueByWeight.add(currentVertex);
                    }
                }
            }
        }
        int p = toVertex;
        reversePath.add(p);
        while (p != fromVertex) {
            p = parent[indexOf(p)];
            reversePath.add(p);
        }

        for(int i = reversePath.size(); i >=0; i--) {
            forwardPath.add(reversePath.get(i));
        }

        if (typeOfInfo == WeightedGraphReturnType.GET_PATH) {
            return ((Object) forwardPath);
        }
        if (typeOfInfo == WeightedGraphReturnType.GET_MINIMUM_WEIGHT) {
            return ((Object) );
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
        boolean bool = true;
        EdgeWithWeight edge = new EdgeWithWeight(from, to, weight);
        if (edges.size() == 0) {
        	edges.add(edge);
        	return true;
        }
        for (int i = 0; i < edges.size(); i++)
        {
        	EdgeWithWeight currentEdge = edges.get(i);
        	if(currentEdge.getFromVertex() == from && currentEdge.getToVertex() == to) {
                	bool = false;
        	}
        }
        if (bool == true) edges.add(edge);
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
        }
        output.append("}");

        return output.toString();
    }
}
