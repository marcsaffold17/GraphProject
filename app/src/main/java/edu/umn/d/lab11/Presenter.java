package edu.umn.d.lab11;

public class Presenter {

    private Graph graph;
    private MainView view;
    private String recentVertexName;

    public Presenter(MainView view) {
        this.view = view;
        graph = new Graph();
        recentVertexName = "";
    }

    public void addVertexClick(String vertexName) {
        Vertex newVertex = new Vertex(vertexName);
        graph.addVertex(newVertex);

        recentVertexName = vertexName;
        view.recentVertex(recentVertexName);
    }
}