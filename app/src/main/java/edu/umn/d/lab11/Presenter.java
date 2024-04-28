package edu.umn.d.lab11;

public class Presenter {

    private Graph graph;
    private MainView view;
    private DrawingCanvasView canvasView;

    public Presenter(MainView view, DrawingCanvasView canvasView) {
        this.graph = new Graph();
        this.view = view;
        this.canvasView = canvasView;
    }

    // Various presenter functions that I couldn't figure out

}