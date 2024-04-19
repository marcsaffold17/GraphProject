package edu.umn.d.lab11;

import java.util.ArrayList;
import java.util.List;

public class Presenter {

    private Graph graph;
    private MainView view;
    private String recentVertexName;
    private List<Vertex> vertices = new ArrayList<>();



    public Presenter(MainView view) {
        this.view = view;
        graph = new Graph();
        recentVertexName = "";
    }

    public void vertexCounter(String vertexName) {
        Vertex newVertex = new Vertex(vertexName);
        graph.addVertex(newVertex);

        recentVertexName = vertexName;
        view.recentVertex(recentVertexName);
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

}