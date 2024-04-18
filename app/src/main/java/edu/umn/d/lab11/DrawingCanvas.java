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

public class DrawingCanvas extends View {

    private List<Vertex> vertices = new ArrayList<>();
    public DrawingCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /** Temporarily commented out the DrawingCanvas functionality */

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paintStyle = new Paint();
        paintStyle.setColor(Color.RED);

        for (Vertex vertex : vertices) {
            if (vertex instanceof vertexVisual) {
                vertexVisual visualVertex = (vertexVisual) vertex;
                canvas.drawCircle(visualVertex.getX(), visualVertex.getY(), visualVertex.getRadius(), paintStyle);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        int actionType = event.getActionMasked();
        long eTime = event.getEventTime();

        switch (actionType) {
            case (MotionEvent.ACTION_DOWN):
            addVertex(new Vertex(touchX, touchY));
            Log.d("onTouchEvent", "Pressed down " + touchX + " " + touchY);
            return true;
            case (MotionEvent.ACTION_UP):
                Log.d("onTouchEvent", "Pressed up " + touchX + " " + touchY);
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d("onTouchEvent", "Move " + touchX + " " + touchY);
                default:
                return true;
        }
    }

}
