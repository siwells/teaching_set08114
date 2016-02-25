package org.simonwells.graphicsviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

public class Panel extends View {
    public Panel(Context context) { super(context); }
    public Panel(Context context, AttributeSet attrs) { super(context, attrs); }
    public Panel(Context context, AttributeSet attrs, int defStyle) { super(context, attrs, defStyle); }

    @Override
    protected void onDraw(Canvas canvas) { canvas.drawColor(Color.RED); }
}
