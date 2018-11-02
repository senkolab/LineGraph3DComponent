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

/**
 * expansion of the 2d graph for 3d settings
 *
 * @author Rich
 * @version 1.0
 * @updated 01-Nov-2018 3:29:29 PM
 */
public class Graph3DSettings extends Graph2DSettings {

    /**
     * Grid plane color
     */
    private Color _GridPlaneColor;

    /**
     * Z axis drawing limits
     */
    public DrawingLimits _ZLimits;

    /**
     * Scaler for the Z axis
     */
    private IGraph2DScaler _ZScaler;

    /**
     * Array of Z major grid lines
     */
    private double _ZMajorGrid[];

    /**
     * Array of z axis minor grid lines
     */
    private double _ZMinorGrid[];

    /**
     * AutoGrid handler for Z axis
     */
    private IAutoGridder _ZAutoGridder;

    /**
     * Boolean flag to enable auto-gridding
     */
    private boolean _ZAutoGrid;

    /**
     * Updates the grid if autogridding is enabled
     */
    @Override
    public void updateGrid() {
        super.updateGrid();

        if (_ZAutoGrid) {
            _ZAutoGridder.GetNewDrawingLimits(_ZLimits);
            _ZMajorGrid = _ZAutoGridder.GetMajorGrid(_ZLimits);
            _ZMinorGrid = _ZAutoGridder.GetMinorGrid(_ZLimits);
            _ZMajorGridLabels = _ZAutoGridder.GetGridLabels(_ZMajorGrid);
            _ZMinorGridLabels = _ZAutoGridder.GetGridLabels(_ZMinorGrid);
        }
    }

    /**
     * constructor
     */
    public Graph3DSettings() {
        super();
        _GridPlaneColor = new Color(64, 128, 128, 128);

        _ZLimits = new DrawingLimits(-1.0, 1.0, -10, 10);
        _ZScaler = new LinearScaler();
        _ZAutoGridder = new SimpleLinearAutoGrid();

        _ZMajorGrid = _ZAutoGridder.GetMajorGrid(_ZLimits);
        _ZMinorGrid = _ZAutoGridder.GetMajorGrid(_ZLimits);

        _ZAutoGrid = true;
    }

    /**
     * Grid plane color
     * @return 
     */
    public Color getGridPlaneColor() {
        return _GridPlaneColor;
    }

    /**
     * Grid plane color
     * @param c
     */
    public void setGridPlaneColor(Color c) {
        _GridPlaneColor = c;
    }

    /**
     * Z axis limits
     * @return 
     */
    public DrawingLimits getZLimits() {
        return _ZLimits;
    }

    /**
     * Z axis limits
     * @param zl
     */
    public void setZLimits(DrawingLimits zl) {
        _ZLimits = zl;
    }

    /**
     * Z axis scaler
     *
     * @return
     */
    public IGraph2DScaler getZScaler() {
        return _ZScaler;
    }

    /**
     * Z axis scaler
     *
     * @param sc
     */
    public void setZScaler(IGraph2DScaler sc) {
        _ZScaler = sc;
    }

    /**
     * Z axis major gridlines
     * @return 
     */
    public double[] getZMajorGrid() {
        return _ZMajorGrid;
    }

    /**
     * Z axis major gridlines
     * @param g
     */
    public void setZMajorGrid(double[] g) {
        _ZMajorGrid = g;
    }

    /**
     * Z axis minor grid
     * @return 
     */
    public double[] getZMinorGrid() {
        return _ZMinorGrid;
    }

    /**
     * Z axis minor grid
     * @param g
     */
    public void setZMinorGrid(double[] g) {
        _ZMinorGrid = g;
    }
    
    /**
     * Z axis auto gridder
     * @return 
     */
    public IAutoGridder getZAutoGridder() {
        return _ZAutoGridder;
    }

    /**
     * Z axis auto gridder
     * @param g
     */
    public void setZAutoGridder(IAutoGridder g) {
        _ZAutoGridder = g;
    }

    /**
     * enables/disables the auto grid property
     * @return 
     */
    public boolean getZAutoGrid() {
        return _ZAutoGrid;
    }

    /**
     * enables/disables the auto grid property
     * @param v
     */
    public void getZAutoGrid(boolean v) {
        _ZAutoGrid = v;
        if(_ZAutoGrid)
            updateGrid();
    }

}
