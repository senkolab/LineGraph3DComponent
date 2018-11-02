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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

/**
 * A class representing single traces of data
 *
 * @author Rich
 * @version 1.0
 * @updated 01-Nov-2018 3:21:10 PM
 */
public class Graph2DTrace {

    protected double _XPoints[];
    protected double _YPoints[];
    protected double _Xmin;
    protected double _Xmax;
    protected double _Ymin;
    protected double _Ymax;

    protected Color _color = Color.BLUE;
    protected Stroke _stroke = new BasicStroke(1);
    
    /**
     * Default constructor
     */
    public Graph2DTrace() {

    }

    /**
     * Constructor for y-only ordinates. X ordinates are counted
     *
     * @param Ypts
     */
    public Graph2DTrace(double[] Ypts) {
        this.SetPoints(Ypts);
    }

    /**
     * Constructor for explicit X, Y ordinates
     *
     * @param Xpts
     * @param Ypts
     */
    public Graph2DTrace(double[] Xpts, double[] Ypts) {
        this.SetPoints(Xpts, Ypts);
    }

    /**
     * Constructor for linearly-spaced Y points
     *
     * @param deltaX
     * @param Ypts
     */
    public Graph2DTrace(double deltaX, double[] Ypts) {
        this.SetPoints(deltaX, Ypts);
    }

    
    /**
     * Get the color
     * @return 
     */
    public Color getColor() {
        return _color;
    }

    /**
     * Set the color
     * @param _color 
     */
    public void setColor(Color _color) {
        this._color = _color;
    }

    /**
     * get the brush stroke
     * @return 
     */
    public Stroke getStroke() {
        return _stroke;
    }

    /**
     * set the brush stroke
     * @param _stroke 
     */
    public void setStroke(Stroke _stroke) {
        this._stroke = _stroke;
    }
    

    /**
     * Sets all x ordinates to a specific value
     *
     * @param xpt
     */
    public void SetX(double xpt) {
        for (int n = 0; n < _XPoints.length; n++) {
            _XPoints[n] = xpt;
        }
        _Xmax = xpt;
        _Xmin = xpt;
    }

    /**
     * sets all y ordinates to a specific value
     *
     * @param ypt
     */
    public void SetY(double ypt) {
        for (int n = 0; n < _YPoints.length; n++) {
            _YPoints[n] = ypt;
        }
        _Ymax = ypt;
        _Ymin = ypt;
    }

    /**
     * Get the r of the X ordinates of each point
     *
     * @return
     */
    public double[] getXPoints() {
        return _XPoints;
    }

    /**
     * Get the r of the Y ordinates of each point
     *
     * @return
     */
    public double[] getYPoints() {
        return _YPoints;
    }

    /**
     * Get the minimum r of all X ordinates
     *
     * @return
     */
    public double getXmin() {
        return _Xmin;
    }

    /**
     * Get the maximum r of all X ordinates
     *
     * @return
     */
    public double getXmax() {
        return _Xmax;
    }

    /**
     * Get the minimum r of all Y ordinates
     *
     * @return
     */
    public double getYmin() {
        return _Ymin;
    }

    /**
     * Get the maximum r of all Y ordinates
     *
     * @return
     */
    public double getYmax() {
        return _Ymax;
    }

    /**
     * Update the Xmin, getXmax, Ymin, Ymax statistics
     */
    protected void _UpdateLimits() {
        for (int n = 0; n < _XPoints.length; n++) {
            _Xmin = Math.min(_Xmin, _XPoints[n]);
            _Xmax = Math.max(_Xmax, _XPoints[n]);
            _Ymin = Math.min(_Ymin, _YPoints[n]);
            _Ymax = Math.max(_Ymax, _YPoints[n]);
        }
    }

    /**
     * Set the Y point values, automatically numerates X ordinates as 0...N-1
     *
     * @param Ypts Y point ordinates
     */
    public void SetPoints(double[] Ypts) {
        for (int n = 0; n < _XPoints.length; n++) {
            _Xmin = Math.min(_Xmin, _XPoints[n]);
            _Xmax = Math.max(_Xmax, _XPoints[n]);
            _Ymin = Math.min(_Ymin, _YPoints[n]);
            _Ymax = Math.max(_Ymax, _YPoints[n]);
        }
    }

    /**
     * Set the X, and Y point values
     *
     * @param Xpts Array of X ordinate values
     * @param Ypts Array of Y ordinate values
     */
    public void SetPoints(double[] Xpts, double[] Ypts) {

        _YPoints = Ypts;
        _XPoints = new double[Ypts.length];

        // set X points to the linear sequence 0...N-1
        for (int n = 0; n < Ypts.length; n++) {
            _XPoints[n] = (double) n;
        }

        _UpdateLimits();

    }

    /**
     * Sets the Y values, create 0, deltaX, ... (n-1)deltaX
     *
     * @param deltaX
     * @param YPts
     */
    public void SetPoints(double deltaX, double[] YPts) {
        _XPoints = new double[YPts.length];
        _YPoints = YPts;

        double xx = 0.0;
        for (int n = 0; n < YPts.length; n++) {
            _XPoints[n] = xx;
            xx += deltaX;
        }

        _UpdateLimits();
    }
}
