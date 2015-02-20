package org.simonwells.graphicsinteraction;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GraphicsThread extends Thread
{
    private SurfaceHolder surfaceHolder;
    private Panel panel;
    private boolean run = false;

    public GraphicsThread(SurfaceHolder surfaceHolder, Panel panel)
    {
        this.surfaceHolder = surfaceHolder;
        this.panel = panel;
    }

    public void setRunning(boolean value)
    {
        this.run = value;
    }

    @Override
    public void run()
    {
        while(run)
        {
            Canvas canvas = null;

            try
            {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder)
                {
                    panel.draw(canvas);
                }
            }
            catch (Exception e) {}
        }
    }
}
