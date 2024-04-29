package edu.umn.d.lab11;

public class EdgeVisual {
    private VertexVisual source;
    private VertexVisual destination;
    private float weight;

    /**
     * Defines visual aspects of an edge
     * @param source
     * @param destination
     * @param weight
     */
    public EdgeVisual(VertexVisual source, VertexVisual destination, float weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * Gets VertexVisual source value
     * @return
     */
    public VertexVisual getSource() {
        return source;
    }

    /**
     * Gets VertexVisual destination value
     * @return
     */
    public VertexVisual getDestination() {
        return destination;
    }

    /**
     * Gets float weight value
     * @return
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Sets source value (not currently used)
     */
    public void setSource() {
        this.source = source;
    }

    /**
     * Sets destination value (not currently used)
     */
    public void setDestination() {
        this.destination = destination;
    }

    /**
     * Sets weight value
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

}


