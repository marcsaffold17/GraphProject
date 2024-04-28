package edu.umn.d.lab11;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;
public class BFSTest2 {
    @Test
    public void graphCreation() {

        Graph graph = new Graph();

        // Create vertices
        Vertex A = new Vertex("A");
        graph.addVertex(A);

        Vertex B = new Vertex("B");
        graph.addVertex(B);

        Vertex C = new Vertex("C");
        graph.addVertex(C);

        Vertex D = new Vertex("D");
        graph.addVertex(D);

        Vertex E = new Vertex("E");
        graph.addVertex(E);

        int numVerts = graph.numVertices();

        // Test: Make sure there are 5 vertices
        assertEquals(5, numVerts);

        graph.addEdge(A, B,1.0f);
        graph.addEdge(A, C,1.0f);
        graph.addEdge(B, D,1.0f);
        graph.addEdge(C, E,1.0f);

        int numEdges = graph.numAllEdges();

        // Test: Make sure there are 4 edges
        assertEquals(4, numEdges);

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

        // Expected order: A B C D E
        String expected = "A -> B -> C -> D -> E -> ";

        System.out.println("");
        System.out.println("Breadth First Search Order:");
        graph.bfs(A);
        assertEquals(expected, "A -> B -> C -> D -> E -> ");
        System.out.print("nil");
    }
}