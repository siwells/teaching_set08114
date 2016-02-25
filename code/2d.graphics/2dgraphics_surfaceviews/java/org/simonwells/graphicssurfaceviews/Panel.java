package org.simonwells.graphicssurfaceviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Panel extends SurfaceView implements SurfaceHolder.Callback{
    private GraphicsThread thread;
    Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

    public Panel(Context context)
    {
        super(context);
        getHolder().addCallback(this);
        this.thread = new GraphicsThread(getHolder(), this);
    }

    public Panel(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        getHolder().addCallback(this);
        this.thread = new GraphicsThread(getHolder(), this);
    }

    public Panel(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        getHolder().addCallback(this);
        this.thread = new GraphicsThread(getHolder(), this);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if(canvas != null)
        {
            canvas.drawColor(Color.RED);
            canvas.drawBitmap(bm, 10, 10, null);
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
}
