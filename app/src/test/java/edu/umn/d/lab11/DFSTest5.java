package edu.umn.d.lab11;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class DFSTest5 {
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

        Vertex M = new Vertex("M");
        graph.addVertex(M);

        Vertex N = new Vertex("N");
        graph.addVertex(N);

        Vertex O = new Vertex("O");
        graph.addVertex(O);

        Vertex P = new Vertex("P");
        graph.addVertex(P);

        Vertex Q = new Vertex("Q");
        graph.addVertex(Q);

        Vertex R = new Vertex("R");
        graph.addVertex(R);

        Vertex S = new Vertex("S");
        graph.addVertex(S);

        Vertex T = new Vertex("T");
        graph.addVertex(T);

        Vertex U = new Vertex("U");
        graph.addVertex(U);

        Vertex V = new Vertex("V");
        graph.addVertex(V);

        Vertex W = new Vertex("W");
        graph.addVertex(W);

        Vertex X = new Vertex("X");
        graph.addVertex(X);

        Vertex Y = new Vertex("Y");
        graph.addVertex(Y);

        Vertex Z = new Vertex("Z");
        graph.addVertex(Z);

        int numVerts = graph.numVertices();

        // Test: Make sure there are 26 vertices
        assertEquals(26, numVerts);

        // Create edges
        graph.addEdge(A, B,1.0f);
        graph.addEdge(A, C,1.0f);
        graph.addEdge(A, D,1.0f);
        graph.addEdge(B, E,1.0f);
        graph.addEdge(B, F,1.0f);
        graph.addEdge(B, G,1.0f);
        graph.addEdge(C, G,1.0f);
        graph.addEdge(C, H,1.0f);
        graph.addEdge(D, I,1.0f);
        graph.addEdge(E, J,1.0f);
        graph.addEdge(F, J,1.0f);
        graph.addEdge(G, K,1.0f);
        graph.addEdge(H, L,1.0f);
        graph.addEdge(I, L,1.0f);
        graph.addEdge(J, M,1.0f);
        graph.addEdge(K, N,1.0f);
        graph.addEdge(L, M,1.0f);
        graph.addEdge(M, O,1.0f);
        graph.addEdge(M, P,1.0f);
        graph.addEdge(M, Q,1.0f);
        graph.addEdge(O, R,1.0f);
        graph.addEdge(Q, R,1.0f);
        graph.addEdge(R, S,1.0f);
        graph.addEdge(S, T,1.0f);
        graph.addEdge(S, U,1.0f);
        graph.addEdge(S, V,1.0f);
        graph.addEdge(T, W,1.0f);
        graph.addEdge(U, W,1.0f);
        graph.addEdge(V, X,1.0f);
        graph.addEdge(X, Z,1.0f);
        graph.addEdge(W, Y,1.0f);
        graph.addEdge(Z, Y,1.0f);

        int numEdges = graph.numAllEdges();

        // Test: Make sure there are 32 edges
        assertEquals(32, numEdges);

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


        // Expected order: A B E J M O R S T W Y U V X Z P Q F G K N C H L D I
        String expected = "A -> B -> E -> J -> M -> O -> R -> S -> T -> W -> Y -> U -> V -> X -> Z -> P -> Q -> F -> G -> K -> N -> C -> H -> L -> D -> I -> ";

        System.out.println("");
        System.out.println("Depth First Search Order:");
        graph.dfs(A);
        assertEquals(expected, "A -> B -> E -> J -> M -> O -> R -> S -> T -> W -> Y -> U -> V -> X -> Z -> P -> Q -> F -> G -> K -> N -> C -> H -> L -> D -> I -> ");
        System.out.print("nil");

    }
}