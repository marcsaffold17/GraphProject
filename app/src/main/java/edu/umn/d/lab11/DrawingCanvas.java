package edu.umn.d.lab11;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DrawingCanvas extends View implements MainView {
    private List<Vertex> vertices = new ArrayList<>();
    private List<EdgeVisual> edges = new ArrayList<>();
    private Presenter presenter;
    private Vertex selectedVertex = null;

    public DrawingCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        presenter = new Presenter((MainView) context);
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.RED);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(24);

        Paint edgePaint = new Paint();
        edgePaint.setColor(Color.BLUE);
        edgePaint.setStrokeWidth(5);

        // Draw edges
        for (EdgeVisual edge : edges) {
            VertexVisual srcVertex = edge.getSource();
            VertexVisual dstVertex = edge.getDestination();
            canvas.drawLine(srcVertex.getX(), srcVertex.getY(), dstVertex.getX(), dstVertex.getY(), edgePaint);

            float midX = (srcVertex.getX() + dstVertex.getX()) / 2;
            float midY = (srcVertex.getY() + dstVertex.getY()) / 2;

            canvas.drawText(String.valueOf(edge.getWeight()), midX, midY, textPaint);
        }

        // Draw vertices
        for (Vertex vertex : vertices) {
            if (vertex instanceof VertexVisual) {
                VertexVisual visualVertex = (VertexVisual) vertex;
                canvas.drawCircle(visualVertex.getX(), visualVertex.getY(), visualVertex.getRadius(), circlePaint);
                canvas.drawText(visualVertex.getVertexName(), visualVertex.getX() + visualVertex.getRadius() * 1.5f, visualVertex.getY(), textPaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        int actionType = event.getActionMasked();
        long eTime = event.getEventTime();
        Vertex vertex = new Vertex(touchX, touchY);
        presenter.addVertex(vertex);

        switch (actionType) {
            case (MotionEvent.ACTION_DOWN):
            addVertex(new Vertex(touchX, touchY));
                selectedVertex = getSelectedVertex(touchX, touchY);
                if (selectedVertex != null) {
                    return true;
                }
                break;


            case (MotionEvent.ACTION_UP):

                selectedVertex = null;
                return true;


            case (MotionEvent.ACTION_MOVE):

                if (selectedVertex != null && selectedVertex instanceof VertexVisual) {
                    VertexVisual visualVertex = (VertexVisual) selectedVertex;
                    visualVertex.setX(touchX);
                    visualVertex.setY(touchY);
                    invalidate();
                    updateEdgeDistances();
                    return true;
                }
                break;

                default:
                return true;
        }
        return super.onTouchEvent(event);
    }

    // Check if a vertex is clicked
    public Vertex getSelectedVertex(float touchX, float touchY) {
        for (Vertex vertex : vertices) {
            if (vertex instanceof VertexVisual) {
                VertexVisual visualVertex = (VertexVisual) vertex;
                float dx = touchX - visualVertex.getX();
                float dy = touchY - visualVertex.getY();
                float distanceSquared = dx * dx + dy * dy;
                if (distanceSquared <= visualVertex.getRadius() * visualVertex.getRadius()) {
                    return vertex;
                }
            }
        }
        return null;
    }

    private void updateEdgeDistances() {
        for (EdgeVisual edge : edges) {
            VertexVisual srcVertex = edge.getSource();
            VertexVisual dstVertex = edge.getDestination();
            float distance = calculateDistance(srcVertex, dstVertex);
            edge.setWeight(distance);
        }
        invalidate();
    }


    private float calculateDistance(VertexVisual v1, VertexVisual v2) {
        float dx = v2.getX() - v1.getX();
        float dy = v2.getY() - v1.getY();
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void addVertexClick() {

    }

    @Override
    public void recentVertex(String vertexName) {

    }


    public void addEdge(EdgeVisual edge) {
        edges.add(edge);
    }

}

