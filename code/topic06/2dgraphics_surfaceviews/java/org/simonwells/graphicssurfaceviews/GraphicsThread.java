package org.simonwells.graphicssurfaceviews;

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
    public void run() {}
}
