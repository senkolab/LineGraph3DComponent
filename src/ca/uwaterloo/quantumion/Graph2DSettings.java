package ca.uwaterloo.quantumion;

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
import java.awt.Color;
import java.awt.Rectangle;

/**
 * Generic properties for the entire 2D graph
 *
 * @author Rich
 * @version 1.0
 * @updated 01-Nov-2018 1:45:35 PM
 */
public class Graph2DSettings {

    private Color _TextColor;
    private Color _BGColor;
    private Color _GridColor;
    protected Graph2DMargins _Margins;
    public DrawingLimits _XLimits;
    public DrawingLimits _YLimits;
    private IGraph2DScaler _XScaler;
    private IGraph2DScaler _YScaler;
    private ICameraProjector _Projector;
    private double _XMajorGrid[];
    private double _YMajorGrid[];
    private double _XMinorGrid[];
    private double _YMinorGrid[];
    private IAutoGridder _XAutoGridder;
    private IAutoGridder _YAutoGridder;
    private boolean _XAutoGrid;
    private boolean _YAutoGrid;
    public IColorChooser _ColorChooser;
    public String _XMajorGridLabels[] = new String[0];
    public String _YMajorGridLabels[] = new String[0];
    public String _XMinorGridLabels[] = new String[0];
    public String _YMinorGridLabels[] = new String[0];
    public String _ZMajorGridLabels[] = new String[0];
    public String _ZMinorGridLabels[] = new String[0];

    /**
     * Constructor
     */
    public Graph2DSettings() {
        _Margins = new Graph2DMargins();

        _TextColor = Color.WHITE;
        _BGColor = Color.BLACK;
        _GridColor = Color.DARK_GRAY;

        _XLimits = new DrawingLimits(-1.0, 1.0, 0, 10);
        _YLimits = new DrawingLimits(-1.0, 1.0, 0, 100);

        _XScaler = new LinearScaler();
        _YScaler = new LinearScaler(-1.0, 0.0);

        _Projector = new Simple2DProjector();

        _XAutoGridder = new SimpleLinearAutoGrid();
        _YAutoGridder = new SimpleLinearAutoGrid();

        _XAutoGrid = true;
        _YAutoGrid = true;
        
        updateGrid();

        _ColorChooser = new CyclicColorChooser(Color.YELLOW, Color.GREEN, Color.CYAN);

    }

    /**
     * Get background color
     *
     * @return
     */
    public Color getBGColor() {
        return _BGColor;
    }

    /**
     * Set background color
     *
     * @param c
     */
    public void setBGColor(Color c) {
        _BGColor = c;
    }

    /**
     * Get text color
     *
     * @return
     */
    public Color getTextColor() {
        return _TextColor;
    }

    /**
     * Set text color
     *
     * @param c
     */
    public void setTextColor(Color c) {
        _TextColor = c;
    }

    /**
     * Get grid color
     *
     * @return
     */
    public Color getGridColor() {
        return _GridColor;
    }

    /**
     * Set grid color
     *
     * @param c
     */
    public void setGridColor(Color c) {
        _GridColor = c;
    }

    /**
     * The margins around the drawing plane in pixel space
     *
     * @return
     */
    public Graph2DMargins getMargins() {
        return _Margins;
    }

    /**
     * The margins around the drawing plane in pixel space
     *
     * @param mar
     */
    public void setMargins(Graph2DMargins mar) {
        _Margins = mar;
    }

    /**
     * X axis drawling limits
     *
     * @return
     */
    public DrawingLimits getXLimits() {
        return _XLimits;
    }

    /**
     * X axis drawling limits
     *
     * @param dl
     */
    public void setXLimits(DrawingLimits dl) {
        _XLimits = dl;
    }

    /**
     * Y axis drawing limits
     *
     * @return
     */
    public DrawingLimits getYLimits() {
        return _YLimits;
    }

    /**
     * Y axis drawing limits
     *
     * @param dl
     */
    public void setYLimits(DrawingLimits dl) {
        _YLimits = dl;
    }

    /**
     * X major grid points. Setting this will disable autogridding for X axis
     *
     * @return
     */
    public double[] getXMajorGrid() {
        return _XMajorGrid;
    }

    /**
     * X major grid points. Setting this will disable autogridding for X axis
     *
     * @param val
     */
    public void setXMajorGrid(double[] val) {
        _XMajorGrid = val;
        _XAutoGrid = false;
        updateGrid();
    }

    /**
     * Y major grid points. Setting this will disable autogridding for Y axis
     *
     * @return
     */
    public double[] getYMajorGrid() {
        return _YMajorGrid;
    }

    /**
     * Y major grid points. Setting this will disable autogridding for Y axis
     *
     * @param val
     */
    public void setYMajorGrid(double[] val) {
        _YMajorGrid = val;
        _YAutoGrid = false;
        updateGrid();
    }

    /**
     * X minor grid points. Setting this will disable autogridding for X axis
     *
     * @return
     */
    public double[] getXMinorGrid() {
        return _XMinorGrid;
    }

    /**
     * X minor grid points. Setting this will disable autogridding for X axis
     *
     * @param val
     */
    public void setXMinorGrid(double[] val) {
        _XMinorGrid = val;
        _XAutoGrid = false;
        updateGrid();
    }

    /**
     * Y minor grid points. Setting this will disable autogridding for Y axis
     *
     * @return
     */
    public double[] getYMinorGrid() {
        return _YMinorGrid;
    }

    /**
     * Y minor grid points. Setting this will disable autogridding for Y axis
     *
     * @param value
     */
    public void setYMinorGrid(double[] value) {
        _YMinorGrid = value;
        _YAutoGrid = false;
        updateGrid();
    }

    /**
     * X auto grid calculator
     *
     * @return
     */
    public IAutoGridder getXAutoGridder() {
        return _XAutoGridder;
    }

    /**
     * X auto grid calculator
     *
     * @param g
     */
    public void setXAutoGridder(IAutoGridder g) {
        _XAutoGridder = g;
        updateGrid();
    }

    /**
     * Y auto grid calculator
     *
     * @return
     */
    public IAutoGridder getYAutoGridder() {
        return _YAutoGridder;
    }

    /**
     * Y auto grid calculator
     *
     * @param g
     */
    public void getYAutoGridder(IAutoGridder g) {
        _YAutoGridder = g;
        updateGrid();
    }

    /**
     * Get/Set the X Grid auto updater
     *
     * @return
     */
    public boolean getXAutoGrid() {
        return _XAutoGrid;
    }

    /**
     * Get/Set the X Grid auto updater
     *
     * @param value
     */
    public void setXAutoGrid(boolean value) {
        _XAutoGrid = value;
        updateGrid();
    }

    /**
     * Get/Set the Y Grid auto updater
     *
     * @return
     */
    public boolean getYAutoGrid() {
        return _YAutoGrid;
    }

    /**
     * Get/Set the Y Grid auto updater
     *
     * @param value
     */
    public void setYAutoGrid(boolean value) {
        _YAutoGrid = value;
        updateGrid();
    }

    /**
     * Checks to see if the X,Y grids need updating
     */
    public void updateGrid() {
        if (_XAutoGrid) {
            _XAutoGridder.GetNewDrawingLimits(_XLimits);
            _XMajorGrid = _XAutoGridder.GetMajorGrid(_XLimits);
            _XMinorGrid = _XAutoGridder.GetMinorGrid(_XLimits);
            _XMajorGridLabels = _XAutoGridder.GetGridLabels(_XMajorGrid);
            _XMinorGridLabels = _XAutoGridder.GetGridLabels(_XMinorGrid);
        }
        if (_YAutoGrid) {
            _YAutoGridder.GetNewDrawingLimits(_YLimits);
            _YMajorGrid = _YAutoGridder.GetMajorGrid(_YLimits);
            _YMinorGrid = _YAutoGridder.GetMinorGrid(_YLimits);
            _YMajorGridLabels = _YAutoGridder.GetGridLabels(_YMajorGrid);
            _YMinorGridLabels = _YAutoGridder.GetGridLabels(_YMinorGrid);
        }
    }

    /**
     * Autocreate the drawing limits in pixel space based on a client rectangle
     *
     * @return
     */
    public Rectangle getPixelRectangle() {
        return new Rectangle(
            _XLimits.getPixMin(), _YLimits.getPixMin(),
            Math.abs(_XLimits.dPixel()), Math.abs(_YLimits.dPixel())
        );
    }

    /**
     * Autocreate the drawing limits in pixel space based on a client rectangle
     *
     * @param r
     */
    public void setPixelRectangle(Rectangle r) {
        _XLimits.setPixMin(r.x + _Margins.Left);
        _XLimits.setPixMax(r.x + r.width - _Margins.Right);
        _YLimits.setPixMin(r.y + _Margins.Top);
        _YLimits.setPixMax(r.y + r.height - _Margins.Bottom);
    }

    /**
     * The color sequence chooser
     *
     * @return
     */
    public IColorChooser getColorChooser() {
        return _ColorChooser;
    }

    /**
     * The color sequence chooser
     *
     * @param c
     */
    public void setColorChooser(IColorChooser c) {
        _ColorChooser = c;
    }

    /**
     * Get the x scaler object
     *
     * @return
     */
    public IGraph2DScaler getXScaler() {
        return _XScaler;
    }

    /**
     * Get the x scaler object
     *
     * @param s
     */
    public void setXScaler(IGraph2DScaler s) {
        _XScaler = s;
    }

    /**
     * get the y scaler
     *
     * @return
     */
    public IGraph2DScaler getYScaler() {
        return _YScaler;
    }

    /**
     * get the y scaler
     *
     * @param s
     */
    public void setYScaler(IGraph2DScaler s) {
        _YScaler = s;
    }

    /**
     * Get the projector object
     *
     * @return
     */
    public ICameraProjector getProjector() {
        return _Projector;
    }
}
