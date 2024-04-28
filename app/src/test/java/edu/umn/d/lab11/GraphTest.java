package edu.umn.d.lab11;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class GraphTest {
    @Test
    public void graphCreation() {

        Graph graph = new Graph();

        // Create vertices
        Vertex v0 = new Vertex("v0");
        graph.addVertex(v0);

        Vertex v1 = new Vertex("v1");
        graph.addVertex(v1);

        Vertex v2 = new Vertex("v2");
        graph.addVertex(v2);

        Vertex v3 = new Vertex("v3");
        graph.addVertex(v3);

        Vertex v4 = new Vertex("v4");
        graph.addVertex(v4);

        Vertex v5 = new Vertex("v5");
        graph.addVertex(v5);

        int numVerts = graph.numVertices();

        // Test: Make sure there are 6 vertices
        assertEquals(6, numVerts);

        // Create edges
        graph.addEdge( v0, v1, 1.0f);
        graph.addEdge( v0, v2, 1.0f);
        graph.addEdge( v1, v2, 1.0f);
        graph.addEdge( v1, v1, 1.0f);
        graph.addEdge( v2, v3, 1.0f);
        graph.addEdge( v2, v4, 1.0f);
        graph.addEdge( v2, v1, 1.0f);
        graph.addEdge( v2, v5, 1.0f);
        graph.addEdge( v2, v0, 1.0f);
        graph.addEdge( v4, v0, 1.0f);
        graph.addEdge( v5, v1, 1.0f);
        graph.addEdge( v5, v3, 1.0f);
        graph.addEdge( v3, v5, 1.0f);

        int numEdges = graph.numAllEdges();

        // Test: Make sure there are 13 edges
        assertEquals(13, numEdges);

        // Prints out graph adjacency list
        System.out.println("Graph Created:");

        // Outer loop: Searches the list of vertices
        for (Vertex vertex : graph.m_adjacencyList.keySet()) {
            System.out.print(vertex.getLabel() + ":");
            LinkedList<Edge> edgesList = graph.m_adjacencyList.get(vertex);

            // Nested loop: Searches for edges for the current vertex
            for (Edge edge : edgesList) {
                System.out.print(" -> " + edge.dst.getLabel());
            }
            System.out.println(" -> nil");
        }

    }
}
