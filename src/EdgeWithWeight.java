public class EdgeWithWeight implements EdgeWithWeightFunctions {
    private final int fromVertex;
    private final int toVertex;
    private final double weight;

    public EdgeWithWeight(int fromVertex, int toVertex, double weight) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }

    public int getFromVertex() {
        return fromVertex;
    }

    public int getToVertex() {
        return toVertex;
    }
    public double getWeight() {
        return getWeight();
    }

    public String toString() {
        return "(" + fromVertex +
                "," + toVertex +
                "," + weight +
                ')';
    }
}
