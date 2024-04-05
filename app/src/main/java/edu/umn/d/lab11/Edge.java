package edu.umn.d.lab11;

public class Edge {

    public final Vertex src;
    public final Vertex dst;
    public float weight;
    public static final float DEFAULT_WEIGHT = 1.0f;

    public Edge(Vertex src, Vertex dst, float weight) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }

    public Edge(Vertex src, Vertex dst) {
        this(src, dst, DEFAULT_WEIGHT);
    }

}