/*
 * Copyright 2018 Rich.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.uwaterloo.quantumion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 * 2D Graph component
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 4:52:53 PM
 */
public final class LineGraph2D extends JPanel implements ComponentListener {


    /**
     * All settings member object
     */
    protected Graph2DSettings _Settings;
    protected ISimpleRenderer _BackgroundRenderer;
    protected ISimpleRenderer _GridRenderer;
    private ITraceRenderer _TraceRenderer;
    protected List<Graph2DTrace> _Traces;
    protected ICameraProjector _Projector;

    /**
     * Constructor
     */
    public LineGraph2D() {
        _Settings = new Graph2DSettings();
        InitialSettings();
    }

    /**
     * Constructor with pre-allocated settings object
     *
     * @param settings Initial settings object
     */
    public LineGraph2D(Graph2DSettings settings) {
        _Settings = settings;
        InitialSettings();
    }

    /**
     * Get settings object
     *
     * @return
     */
    public Graph2DSettings getSettings() {
        return _Settings;
    }

    /**
     * set settings object
     *
     * @param s
     */
    public void setSettings(Graph2DSettings s) {
        _Settings = s;
        invalidate();
    }

    /**
     * Background color
     *
     * @return
     */
    public Color getBackGroundColor() {
        return _Settings.getBGColor();
    }

    /**
     * Background color
     *
     * @param c
     */
    public void setBackgroundColor(Color c) {
        _Settings.setBGColor(c);
        invalidate();
    }

    /**
     * Text color
     *
     * @return
     */
    public Color getTextColor() {
        return _Settings.getTextColor();
    }

    /**
     * Text color
     *
     * @param c
     */
    public void setTextColor(Color c) {
        _Settings.setTextColor(c);
        invalidate();
    }

    /**
     * Grid Color
     *
     * @return
     */
    public Color getGridColor() {
        return _Settings.getGridColor();
    }

    /**
     * Grid Color
     *
     * @param c
     */
    public void setGridColor(Color c) {
        _Settings.setGridColor(c);
        invalidate();
    }

    /**
     * X scale algorithm
     *
     * @return
     */
    public IGraph2DScaler getXScaler() {
        return _Settings.getXScaler();
    }

    /**
     * X scale algorithm
     *
     * @param s
     */
    public void setXScaler(IGraph2DScaler s) {
        _Settings.setXScaler(s);
        invalidate();
    }

    /**
     * Y scale algorithm
     *
     * @return
     */
    public IGraph2DScaler getYScaler() {
        return _Settings.getYScaler();
    }

    /**
     * X scale algorithm
     *
     * @param s
     */
    public void getYScaler(IGraph2DScaler s) {
        _Settings.setYScaler(s);
        invalidate();
    }

    /**
     * return the collection of traces
     *
     * @return
     */
    public List<Graph2DTrace> getTraces() {
        return _Traces;
    }

    /**
     * Invalidate old traces and put new ones in their place
     *
     * @param traces
     */
    public void SetTraces(Graph2DTrace[] traces) {

        getTraceRenderer().Reset();
        _Traces.clear();

        for (Graph2DTrace t : traces) {
            _AddTrace(t);
        }

        _Settings.updateGrid();

        invalidate();
    }

    /**
     * Add a new trace
     *
     * @param t
     */
    public void AddTrace(Graph2DTrace t) {
        _AddTrace(t);
        _Settings.updateGrid();
        invalidate();
    }

    /**
     * Low level trace add...no redraw
     *
     * @param t
     */
    protected void _AddTrace(Graph2DTrace t) {
        Graph2DSettings s = _Settings;

        _Traces.add(t);

        if (_Traces.size() == 1) {
            s.getXLimits().ResetInfValues();
            s.getYLimits().ResetInfValues();
        }

        if (s.getXAutoGrid()) {
            s.getXLimits().setValueMin(Math.min(s.getXLimits().getValueMin(), t.getXmin()));
            s.getXLimits().setValueMax(Math.max(s.getXLimits().getValueMax(), t.getXmax()));
        }

        if (s.getYAutoGrid()) {
            s.getYLimits().setValueMin(Math.min(s.getYLimits().getValueMin(), t.getYmin()));
            s.getYLimits().setValueMax(Math.max(s.getYLimits().getValueMax(), t.getYmax()));
        }

        s.updateGrid();
    }

    /**
     * Invalidate old traces and put a new one in their place
     *
     *
     * @param t
     */
    public void SetTrace(Graph2DTrace t) {

        getTraceRenderer().Reset();
        _Traces.clear();
        _AddTrace(t);
        invalidate();
    }

    /**
     * Add a trace from y points
     * @param Ypts 
     */
    public void AddTrace(double[] Ypts) {
        Graph2DTrace t = new Graph2DTrace(Ypts);
        ApplyNextTraceColor(t);
        this.AddTrace(t);
    }

    /**
     * Constructor for explicit X, Y ordinates
     *
     * @param Xpts
     * @param Ypts
     */
    public void AddTrace(double[] Xpts, double[] Ypts) {
        Graph2DTrace t = new Graph2DTrace(Xpts, Ypts);
        ApplyNextTraceColor(t);
        this.AddTrace(t);
    }

    /**
     * Constructor for linearly-spaced Y points
     *
     * @param deltaX
     * @param Ypts
     */
    public void AddTrace(double deltaX, double[] Ypts) {
        Graph2DTrace t = new Graph2DTrace(deltaX, Ypts);
        ApplyNextTraceColor(t);
        this.AddTrace(t);
    }

    /**
     * Apply color and other decorators to the trace in the 
     * order they will be used
     * 
     * @param t 
     */
    public void ApplyNextTraceColor(Graph2DTrace t)
    {
        int idx = _Traces.size();
        _Settings.getColorChooser().ApplyNextColor(t, idx);
    }
    /**
     * the drawing limits
     *
     * @return
     */
    public DrawingLimits getXLimits() {
        return _Settings.getXLimits();
    }

    /**
     * the drawing limits
     *
     * @param dl
     */
    public void setXLimits(DrawingLimits dl) {
        _Settings.setXLimits(dl);
        invalidate();
    }

    /**
     * the drawing limits
     *
     * @return
     */
    public DrawingLimits getYLimits() {
        return _Settings.getYLimits();
    }

    /**
     * the drawing limits
     *
     * @param dl
     */
    public void setYLimits(DrawingLimits dl) {
        _Settings.setYLimits(dl);
        invalidate();
    }

    /**
     * Make example sinusoid plot
     */
    protected void makeExampleSine() {

        double phi = -1.0;
        int npoints = 100;
        double[] yy = new double[npoints];
        double[] xx = new double[npoints];

        for (int n = 0; n < npoints; n++) {
            xx[n] = phi;
            yy[n] = Math.sin(Math.PI * 2.0 * xx[n]);
            phi += 2.0 / npoints;
        }

        this.AddTrace(xx,yy);
    }

    /**
     * make example line plot
     */
    protected void makeExampleLine() {
        int npoints = 100;
        double[] yy = new double[npoints];
        double[] xx = new double[npoints];
        double dx = -0.5;

        for (int n = 0; n < npoints; n++) {
            xx[n] = dx;
            yy[n] = xx[n];
            dx += 1.0 / npoints;
        }

        this.AddTrace(xx, yy);
    }

    /**
     * set up all initial settings
     */
    protected void InitialSettings() {

        _BackgroundRenderer = new SimpleBackgroundRenderer();
        _GridRenderer = new SimpleGridRenderer();
        setTraceRenderer(new SimpleTraceRenderer());
        _Traces = new LinkedList<>();
        _Settings.setXAutoGrid(true);
        _Settings.setYAutoGrid(true);

        makeExampleSine();
        makeExampleLine();
    }

    /**
     * The main drawing method
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {

        // do default painting
        super.paintComponent(g);

        // Do all work in an image
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gc_img = img.createGraphics();

        resize();

        // do the rendering
        _BackgroundRenderer.Render(gc_img, _Settings);
        _GridRenderer.Render(gc_img, _Settings);

        // draw each traces
        for (int n = 0; n < _Traces.size(); n++) {
            getTraceRenderer().RenderTrace(gc_img, _Settings, _Traces.get(n), n);
        }

        // draw canvas
        g.drawImage(img, 0, 0, this);
    }

    /**
     * Recalculate dimensions
     */
    public void resize() {
        _Settings.getXLimits().setPixMin(0);
        _Settings.getXLimits().setPixMax(getWidth());
        _Settings.getYLimits().setPixMin(getHeight());
        _Settings.getYLimits().setPixMax(0);
    }

    @Override
    public void componentResized(ComponentEvent ce) {
        resize();
        invalidate();
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
        // do nothing
    }

    @Override
    public void componentShown(ComponentEvent ce) {
        // do noghting
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        // do nothing
    }
    
    /**
     * @return the _TraceRenderer
     */
    public ITraceRenderer getTraceRenderer() {
        return _TraceRenderer;
    }

    /**
     * @param _TraceRenderer the _TraceRenderer to set
     */
    public void setTraceRenderer(ITraceRenderer _TraceRenderer) {
        this._TraceRenderer = _TraceRenderer;
        this.invalidate();
    }

}
