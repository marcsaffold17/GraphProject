package edu.umn.d.lab11;

public class VertexVisual extends Vertex{
    private float x;
    private float y;
    private float radius;
    private String vertexName;

    /**
     * Defines all the visual aspects of a vertex
     * @param vertexName
     * @param x
     * @param y
     * @param radius
     */
    public VertexVisual(String vertexName, float x, float y, float radius) {
        super(vertexName);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vertexName = vertexName;
    }


    /**
     * Gets X float value
     * @return
     */
    public float getX() {
        return x;
    }


    /**
     * Gets Y float value
     * @return
     */
    public float getY() {
        return y;
    }

    /**
     * Gets Radius float value
     * @return
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Gets vertexName string value
     * @return
     */
    public String getVertexName() {
        return vertexName;
    }

    /**
     * Sets X float value
     * @param x
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Sets Y float value
     * @param y
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Sets Radius float value (not currently used)
     * @param radius
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * Sets VertexName string value (not currently used)
     * @param VertexName
     */
    public void setVertexName(String VertexName) {
        this.vertexName = vertexName;
    }


}

