package edu.umn.d.lab11;


public interface MainView {

    VertexVisual findVertexVisualByName(String name);
    float calculateDistance(VertexVisual v1, VertexVisual v2);
    void recentVertex(String vertexName);
}