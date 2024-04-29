package edu.umn.d.lab11;

public class VertexVisual extends Vertex{
    private float x;
    private float y;
    private float radius;
    private String vertexName;

    public VertexVisual(String vertexName, float x, float y, float radius) {
        super(vertexName);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vertexName = vertexName;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }
    public String getVertexName() { return vertexName;}
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
    public void setVertexName(String VertexName) {this.vertexName = vertexName;}


}

