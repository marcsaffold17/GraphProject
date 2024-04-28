package edu.umn.d.lab11;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class DFSTest4 {
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

        Vertex F = new Vertex("F");
        graph.addVertex(F);

        Vertex G = new Vertex("G");
        graph.addVertex(G);

        Vertex H = new Vertex("H");
        graph.addVertex(H);

        Vertex I = new Vertex("I");
        graph.addVertex(I);

        Vertex J = new Vertex("J");
        graph.addVertex(J);

        Vertex K = new Vertex("K");
        graph.addVertex(K);

        Vertex L = new Vertex("L");
        graph.addVertex(L);


        int numVerts = graph.numVertices();

        // Test: Make sure there are 12 vertices
        assertEquals(12, numVerts);

        // Create edges
        graph.addEdge(A, B,1.0f);
        graph.addEdge(A, C,1.0f);
        graph.addEdge(B, D,1.0f);
        graph.addEdge(B, E,1.0f);
        graph.addEdge(C, E,1.0f);
        graph.addEdge(C, F,1.0f);
        graph.addEdge(D, G,1.0f);
        graph.addEdge(E, G,1.0f);
        graph.addEdge(E, H,1.0f);
        graph.addEdge(F, H,1.0f);
        graph.addEdge(G, I,1.0f);
        graph.addEdge(G, J,1.0f);
        graph.addEdge(H, K,1.0f);
        graph.addEdge(K, L,1.0f);


        int numEdges = graph.numAllEdges();

        // Test: Make sure there are 14 edges
        assertEquals(14, numEdges);

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


        // Expected order: A B D G I J E H K L C F
        String expected = "A -> B -> D -> G -> I -> J -> E -> H -> K -> L -> C -> F -> ";

        System.out.println("");
        System.out.println("Depth First Search Order:");
        graph.dfs(A);
        assertEquals(expected, "A -> B -> D -> G -> I -> J -> E -> H -> K -> L -> C -> F -> ");
        System.out.print("nil");

    }
}