package edu.umn.d.lab11;

public class vertexVisual extends Vertex{
    private float x;
    private float y;
    private float radius;

    public vertexVisual(String label, float x, float y, float radius) {
        super(label);
        this.x = x;
        this.y = y;
        this.radius = radius;
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

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}

