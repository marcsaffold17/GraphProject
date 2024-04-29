package edu.umn.d.lab11;

public class Vertex {

    private String vLabel;
    private boolean visited;

    /**
     * Sets Vertex to not visited. Used for search algorithms
     * @param label
     */
    public Vertex(String label)
    {
        vLabel = label;
        visited = false;
    }

    /**
     * gets vLabel string value
     * @return
     */
    public String getLabel()
    {
        return vLabel;
    }


    /**
     * Sets visited boolean value for vertex. Used for search algorithms
     * @return
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Sets boolean value for visited
     * @param visited
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}