package com.ptrstovka.calendarview2.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

public class CustomSpan implements LineBackgroundSpan {

    public static final float DEFAULT_RADIUS = 3;

    private final float radius;
    private final int color_left;
    private final int color_right;

    /**
     * Create a span to draw two dots using default radius and colors
     *
     * @see #DEFAULT_RADIUS
     */
    public CustomSpan() {
        this(DEFAULT_RADIUS, 0, 0);
    }

    /**
     * Create a span to draw two dots using default radius and specified colors
     *
     * @param colorLeft  color of the left dot
     * @param colorRight color of the right dot
     * @see #CustomSpan(int, int)
     * @see #DEFAULT_RADIUS
     */
    public CustomSpan(int colorLeft, int colorRight) {
        this(DEFAULT_RADIUS, colorLeft, colorRight);
    }

    /**
     * Create a span to draw two dots using a specified radius and colors
     *
     * @param radius radius for the dot
     * @param colorLeft  color of the left dot
     * @param colorRight color of the right dot
     */
    public CustomSpan(float radius, int colorLeft, int colorRight) {
        this.radius = radius;
        this.color_left = colorLeft;
        this.color_right = colorRight;
    }

    @Override public void drawBackground(
            Canvas canvas, Paint paint,
            int left, int right, int top, int baseline, int bottom,
            CharSequence charSequence,
            int start, int end, int lineNum
    ) {
        int oldColor = paint.getColor();
        final float center_x = (left + right) / 2;
        final float center_y = bottom + radius;
        final float shift_x = radius *2 ;

        if (color_left != 0) {
            paint.setColor(color_left);
        }
        canvas.drawCircle(center_x - shift_x*2, center_y, radius, paint);
        canvas.drawCircle(center_x - shift_x, center_y, radius, paint);

        if (color_right != 0) {
            paint.setColor(color_right);
        }
        canvas.drawCircle(center_x + shift_x*2, center_y, radius, paint);
        canvas.drawCircle(center_x + shift_x, center_y, radius, paint);

        paint.setColor(oldColor);
    }
}