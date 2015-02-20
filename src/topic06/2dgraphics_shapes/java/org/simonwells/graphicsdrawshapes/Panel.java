package org.simonwells.graphicsdrawshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Panel extends View {
    public Panel(Context context) { super(context); }
    public Panel(Context context, AttributeSet attrs) { super(context, attrs); }
    public Panel(Context context, AttributeSet attrs, int defStyle) { super(context, attrs, defStyle); }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.BLACK);

        Paint paint = new Paint();

        paint.setColor(Color.WHITE);
        canvas.drawCircle(100, 100, 20, paint);

        paint.setColor(Color.RED);
        canvas.drawRect(125, 125, 200, 200, paint);

        paint.setColor(Color.GREEN);
        canvas.drawLine(10, 10, 75, 250, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawText("HELLO NAPIER", 10, 200, paint);
    }
}
