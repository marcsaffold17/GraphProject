package edu.umn.d.lab11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    /**
     * Hashmap for storing vertices
     */
    public Graph()
    {
        // Removed parameter
        m_adjacencyList = new HashMap<>();
    }

    /**
     * Counts amount of vertices in graph
     * @return
     */
    public int numVertices()
    {
        return m_adjacencyList.size();
    }

    /**
     * Adds vertex to linked list
     * @param v
     */
    public void addVertex (Vertex v)
    {
        if (!m_adjacencyList.containsKey(v)) {
            m_adjacencyList.put (v, new LinkedList<>());
        }
    }

    /**
     * Counts amount of edges in graph
     * @return
     */
    public int numAllEdges() {
        int edgeSum = 0;

        for (LinkedList<Edge> edgeList : m_adjacencyList.values()) {
            edgeSum += edgeList.size();
        }

        return edgeSum;
    }

    /**
     * Adds edge between vertices to graph
     * @param src
     * @param dst
     * @param weight
     */
    public void addEdge (Vertex src, Vertex dst, float weight)
    {
        Edge edge = new Edge(src, dst, weight);
        if (m_adjacencyList.containsKey(src))
        {
            m_adjacencyList.get (src).add(edge);
        }
    }

    /**
     * Adds weighted edge to graph (currently unused)
     * @param v0
     * @param v1
     * @param weight
     */
    public void addUniEdge (Vertex v0, Vertex v1, float weight)
    {
        addEdge(v0, v1, weight);
        addEdge(v1, v0, weight);
    }

    public HashMap< Vertex, LinkedList<Edge>> m_adjacencyList;

    /**
     * Recursive call search algorithm. Searches bottom layers first
     * @param v
     */
    public void dfs(Vertex v) {
        v.setVisited(true);

        // Outputs current vertex
        System.out.print(v.getLabel() + " -> ");

        LinkedList<Edge> edgeList = m_adjacencyList.get(v);

        if (edgeList != null) {
            for (Edge edge : edgeList) {
                Vertex nextVertex = edge.dst;
                if (!nextVertex.isVisited()) {

                    // Recursive call. Restarts dfs at next unvisited vertex
                    dfs(nextVertex);
                }
            }
        }
    }

    /**
     * Queue oriented search algorithm. Searches top layers first
     * @param v
     */
    // Uses a queue
    public void bfs(Vertex v) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        v.setVisited(true);

        while (!queue.isEmpty()) {

            // Removes next vertex from queue
            Vertex next = queue.remove();

            // Outputs current vertex
            System.out.print(next.getLabel() + " -> ");

            LinkedList<Edge> edgeList = m_adjacencyList.get(next);

            if (edgeList != null) {
                for (Edge edge : edgeList) {

                    // Get next vertex
                    Vertex nextVertex = edge.dst;
                    if (!nextVertex.isVisited()) {

                        // Adds next vertex to queue
                        queue.add(nextVertex);
                        nextVertex.setVisited(true);
                    }
                }
            }
        }
    }

}