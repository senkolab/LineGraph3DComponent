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

/**
 * 3D traces object
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 4:37:27 PM
 */
public class Graph3DTrace extends Graph2DTrace {

    private double _ZPoints[];
    private double _Zmin;
    private double _Zmax;

    /**
     * Constructor with linearly spaced X, and z=0
     *
     * @param Ypts
     */
    public Graph3DTrace(double[] Ypts) {

    }

    /**
     * constructor for z=0
     *
     * @param Xpts
     * @param Ypts
     */
    public Graph3DTrace(double[] Xpts, double[] Ypts) {

    }

    /**
     * Constructor for linearly spaced x, fixed z
     *
     * @param Ypts
     * @param Zpt
     */
    public Graph3DTrace(double[] Ypts, double Zpt) {

    }

    /**
     * Constructor for x, y, z ordinates
     *
     * @param Xpts
     * @param Ypts
     * @param Zpts
     */
    public Graph3DTrace(double[] Xpts, double[] Ypts, double[] Zpts) {

    }

    /**
     * empty constructor
     */
    public Graph3DTrace() {

    }

    /**
     * return the z ordinates of a traces
     */
    public double[] getZPoints() {
        return _ZPoints;
    }

    /**
     * return the z ordinates of a traces
     */
    public void getZPoints(double[] d) {
        _ZPoints = d;
    }

    /**
     * return the minimum Z value for this traces
     */
    public double getZmin() {
        return _Zmin;
    }

    /**
     * return the maximum z value of this traces
     */
    public double Zmax() {
        return _Zmax;
    }

    /**
     * Sets all z points to a fixed value
     *
     * @param zpt
     */
    public void SetZ(double zpt) {
        for (int n = 0; n < _ZPoints.length; n++) {
            _ZPoints[n] = zpt;
        }
        _Zmax = zpt;
        _Zmin = zpt;
    }

    /**
     * Set the Y point values, automatically numerates X ordinates as 0...N-1,
     * sets all Z ordinates to 0.0
     *
     * @param Ypts Y point ordinates
     */
    @Override
    public void SetPoints(double[] Ypts) {
        SetPoints(Ypts, 0.0);
    }

    /**
     * Set the X, and Y point values. All Z ordinates set to 0.0
     *
     * @param Xpts Array of X ordinate values
     * @param Ypts Array of Y ordinate values
     */
    @Override
    public void SetPoints(double[] Xpts, double[] Ypts) {
        SetPoints(Xpts, Ypts, 0.0);
    }

    /**
     * Set the Y point values, automatically numerates X ordinates as 0...N-1
     *
     * @param Ypts Y point ordinates
     * @param Zpt Z ordinate to set for all points
     */
    public void SetPoints(double[] Ypts, double Zpt) {
        _ZPoints = new double[Ypts.length];

        // set Z points the same value
        for (int n = 0; n < Ypts.length; n++) {
            _ZPoints[n] = Zpt;
        }

        super.SetPoints(Ypts);
    }

    /**
     * Set the Y point values, automatically numerates X ordinates as 0...N-1
     *
     * @param Xpts X point ordinates
     * @param Ypts Y point ordinates
     * @param Zpt Z value to give to all ordinates
     */
    public void SetPoints(double[] Xpts, double[] Ypts, double Zpt) {
        _ZPoints = new double[Ypts.length];
        
        // set Z points the same value
        for (int n = 0; n < Ypts.length; n++) {
            _ZPoints[n] = Zpt;
        }
        _Zmax = Zpt;
        _Zmin = Zpt;

        super.SetPoints(Xpts, Ypts);
    }

    /**
     * Set the x, y and z points
     *
     * @param Xpts X ordinates
     * @param Ypts Y ordinates
     * @param Zpts Z ordinates
     */
    public void SetPoints(double[] Xpts, double[] Ypts, double[] Zpts) {
            _ZPoints = Zpts;
            _Zmin = Double.MAX_VALUE;
            _Zmax = Double.MIN_VALUE;
            
            for (double z : Zpts)
            {
                _Zmin = Math.min(_Zmin, z);
                _Zmax = Math.max(_Zmax, z);
            }

            super.SetPoints(Xpts, Ypts);
    }

    /**
     * Update the min/max limits
     */
    protected void _UpdateLimits() {
        for (int n = 0; n < _XPoints.length; n++) {
            _Xmin = Math.min(_Xmin, _XPoints[n]);
            _Xmax = Math.max(_Xmax, _XPoints[n]);
            _Ymin = Math.min(_Ymin, _YPoints[n]);
            _Ymax = Math.max(_Ymax, _YPoints[n]);
            _Zmin = Math.min(_Zmin, _ZPoints[n]);
            _Zmax = Math.max(_Zmax, _ZPoints[n]);
        }
    }

}
