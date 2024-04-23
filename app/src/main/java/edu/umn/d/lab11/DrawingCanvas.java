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

public class DrawingCanvas extends View {
    private List<VertexVisual> vertices = new ArrayList<>();
    private List<EdgeVisual> edges = new ArrayList<>();
    private VertexVisual selectedVertex = null;

    public DrawingCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
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
        for (VertexVisual vertex : vertices) {
            canvas.drawCircle(vertex.getX(), vertex.getY(), vertex.getRadius(), circlePaint);
            canvas.drawText(vertex.getVertexName(), vertex.getX() + vertex.getRadius() * 1.5f, vertex.getY(), textPaint);
        }
    }

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

    // Check if a vertex is clicked
    private VertexVisual getSelectedVertex(float touchX, float touchY) {
        for (VertexVisual vertex : vertices) {
            float dx = touchX - vertex.getX();
            float dy = touchY - vertex.getY();
            float distanceSquared = dx * dx + dy * dy;
            if (distanceSquared <= vertex.getRadius() * vertex.getRadius()) {
                return vertex;
            }
        }
        return null;
    }

    public void addVertex(VertexVisual vertex) {
        vertices.add(vertex);
        invalidate();
    }

    public void addEdge(EdgeVisual edge) {
        edges.add(edge);
        invalidate();
    }

    public void clearEdges() {
        edges.clear();
        invalidate();
    }

    public void clearVertices() {
        vertices.clear();
        invalidate();
    }

    private void updateEdgeDistance(VertexVisual movedVertex) {
        for (EdgeVisual edge : edges) {
            if (edge.getSource() == movedVertex || edge.getDestination() == movedVertex) {
                float distance = calculateDistance(edge.getSource(), edge.getDestination());
                edge.setWeight(distance);
            }
        }
    }
    private float calculateDistance(VertexVisual v1, VertexVisual v2) {
        float dx = v2.getX() - v1.getX();
        float dy = v2.getY() - v1.getY();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}
