package edu.umn.d.lab11;

public class Vertex {

    private String vLabel;
    private boolean visited;

    public Vertex()
    {
        vLabel = "Unknown";
        visited = false;
    }

    public Vertex(String label)
    {
        vLabel = label;
        visited = false;
    }

    public String getLabel()
    {
        return vLabel;
    }


    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}