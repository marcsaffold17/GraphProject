package edu.umn.d.lab11;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DrawingCanvas extends View implements DrawingCanvasView{
    private List<VertexVisual> vertices = new ArrayList<>();
    private List<EdgeVisual> edges = new ArrayList<>();
    private VertexVisual selectedVertex = null;
    private Presenter presenter;

    public DrawingCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint vertexPaint = new Paint();
        vertexPaint.setColor(Color.RED);

        Paint vertexTextPaint = new Paint();
        vertexTextPaint.setColor(Color.BLACK);
        vertexTextPaint.setTextSize(24);

        Paint edgePaint = new Paint();
        edgePaint.setColor(Color.BLUE);
        edgePaint.setStrokeWidth(5);

        // Draws edges
        for (EdgeVisual edge : edges) {
            VertexVisual srcVertex = edge.getSource();
            VertexVisual dstVertex = edge.getDestination();
            canvas.drawLine(srcVertex.getX(), srcVertex.getY(), dstVertex.getX(), dstVertex.getY(), edgePaint);

            float midX = (srcVertex.getX() + dstVertex.getX()) / 2;
            float midY = (srcVertex.getY() + dstVertex.getY()) / 2;

            canvas.drawText(String.valueOf(edge.getWeight()), midX, midY, vertexTextPaint);
        }

        // Draws vertices
        for (VertexVisual vertex : vertices) {
            canvas.drawCircle(vertex.getX(), vertex.getY(), vertex.getRadius(), vertexPaint);
            canvas.drawText(vertex.getVertexName(), vertex.getX() + vertex.getRadius() * 1.5f, vertex.getY(), vertexTextPaint);
        }
    }

    // Handles user interaction with vertex
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        int actionType = event.getActionMasked();

        switch (actionType) {
            case MotionEvent.ACTION_DOWN:
                selectedVertex = getSelectedVertex(touchX, touchY);
                if (selectedVertex != null) {
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                selectedVertex = null;
                return true;
            case MotionEvent.ACTION_MOVE:
                if (selectedVertex != null) {
                    selectedVertex.setX(touchX);
                    selectedVertex.setY(touchY);
                    updateEdgeDistance(selectedVertex);
                    invalidate();
                    return true;
                }
                break;
        }
        return super.onTouchEvent(event);
    }


    /**
     * Check if a vertex is clicked
     * @param touchX
     * @param touchY
     * @return
     */
    @Override
    public VertexVisual getSelectedVertex(float touchX, float touchY) {
        for (VertexVisual vertex : vertices) {
            float dx = touchX - vertex.getX();
            float dy = touchY - vertex.getY();
            float clickRange = dx * dx + dy * dy;
            if (clickRange <= vertex.getRadius() * vertex.getRadius()) {
                return vertex;
            }
        }
        return null;
    }

    /**
     * Adds visual vertex to android screen
     * @param vertex
     */
    @Override
    public void addVertex(VertexVisual vertex) {
        vertices.add(vertex);
        invalidate();
    }

    /**
     * Adds visual edge to android screen
     * @param edge
     */
    @Override
    public void addEdge(EdgeVisual edge) {
        edges.add(edge);
        invalidate();
    }

    /**
     * Removes edges from android screen
     */
    @Override
    public void clearEdges() {
        edges.clear();
        invalidate();
    }

    /**
     * Removes vertices from android screen
     */
    @Override
    public void clearVertices() {
        vertices.clear();
        invalidate();
    }

    /**
     * Changes weight when user moves visual vertex in app
     * @param movedVertex
     */
    @Override
    public void updateEdgeDistance(VertexVisual movedVertex) {
        for (EdgeVisual edge : edges) {
            if (edge.getSource() == movedVertex || edge.getDestination() == movedVertex) {
                float distance = edgeDistance(edge.getSource(), edge.getDestination());
                edge.setWeight(distance);
            }
        }
    }

    /**
     * Calculates distance between vertices
     * @param v1
     * @param v2
     * @return
     */
    @Override
    public float edgeDistance(VertexVisual v1, VertexVisual v2) {
        float dx = v2.getX() - v1.getX();
        float dy = v2.getY() - v1.getY();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}
