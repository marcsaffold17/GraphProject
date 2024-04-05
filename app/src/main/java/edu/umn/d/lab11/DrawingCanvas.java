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

public class DrawingCanvas extends View {
    public DrawingCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /** Temporarily commented out the DrawingCanvas functionality */

   /* protected void onDraw( Canvas canvas ) {
        super.onDraw(canvas);

        Paint paintStyle = new Paint();
        paintStyle.setColor(Color.RED);

        canvas.drawCircle(100, 380, 45, paintStyle);

        paintStyle.setARGB(128, 0, 50, 128);
        canvas.drawCircle(100, 380, 90, paintStyle);

        int canvasCenterWidth = canvas.getWidth() / 2;
        int canvasCenterHeight = canvas.getHeight() / 2;
        canvas.drawCircle(canvasCenterWidth, canvasCenterHeight - 100, 100, paintStyle);


    }

    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        int actionType = event.getActionMasked();
        long eTime = event.getEventTime();

        switch (actionType) {
            case (MotionEvent.ACTION_DOWN):
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
    } */

}
