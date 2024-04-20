package edu.umn.d.lab11;

public class EdgeVisual {
    private VertexVisual source;
    private VertexVisual destination;
    private float weight;

    public EdgeVisual(VertexVisual source, VertexVisual destination, float weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public VertexVisual getSource() {
        return source;
    }

    public VertexVisual getDestination() {
        return destination;
    }

    public float getWeight() {
        return weight;
    }

    public void setSource() {
        this.source = source;
    }

    public void setDestination() {
        this.destination = destination;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }

}


