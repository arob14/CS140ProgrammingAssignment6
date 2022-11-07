public class VertexWithWeight implements VertexWithWeightFunctions {
    private final int vertex;
    private double weight;

    public VertexWithWeight(int vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getVertex() {
        return vertex;
    }

    public void setWeight(double w) {
        weight = w;
    }

    public String toString() {
        return "(" + vertex +
                "," + weight + ')';
    }
}
