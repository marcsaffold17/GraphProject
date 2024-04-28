package edu.umn.d.lab11;

public interface DrawingCanvasView {
    VertexVisual getSelectedVertex(float touchX, float touchY);
    void addVertex(VertexVisual vertex);
    void addEdge(EdgeVisual edge);
    void clearEdges();
    void clearVertices();
    void updateEdgeDistance(VertexVisual movedVertex);
    float edgeDistance(VertexVisual v1, VertexVisual v2);
}
