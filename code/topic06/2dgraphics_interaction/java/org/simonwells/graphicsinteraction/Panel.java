package org.simonwells.graphicsinteraction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Panel extends SurfaceView implements SurfaceHolder.Callback{
    private GraphicsThread thread;
    private int currentX = 100;
    private int currentY = 100;
    Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
    private int bm_x_center = (bm.getWidth() / 2);
    private int bm_y_center = (bm.getHeight() / 2);

    public Panel(Context context)
    {
        super(context);
        getHolder().addCallback(this);
        this.thread = new GraphicsThread(getHolder(), this);
        setFocusable(true);
    }

    public Panel(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        getHolder().addCallback(this);
        this.thread = new GraphicsThread(getHolder(), this);
        setFocusable(true);
    }

    public Panel(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        getHolder().addCallback(this);
        this.thread = new GraphicsThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if(canvas != null)
        {
            canvas.drawColor(Color.RED);
            canvas.drawBitmap(bm, currentX, currentY, null);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    public void surfaceCreated(SurfaceHolder holder)
    {
        this.draw(holder.lockCanvas());
        thread.setRunning(true);
        thread.start();
    }

    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        thread.setRunning(false);

        while(retry)
        {
            try
            {
                thread.join();
                retry = false;
            }
            catch (InterruptedException e) {}
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        currentX = (int) event.getX() - bm_x_center;
        currentY = (int) event.getY() - bm_y_center;
        return super.onTouchEvent(event);
    }
}
