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
 * Drawing Limits Class for a single dimension
 *
 * @author Rich
 */
public class DrawingLimits {

    protected double _ValueMin = -1.0;

    protected double _ValueMax = 1.0;

    protected int _pixMin = -100;

    protected int _pixMax = 100;

    /**
     * Minimum value-space value
     *
     * @return
     */
    public double getValueMin() {
        return _ValueMin;
    }

    /**
     * Minimu value-space value
     *
     * @param _ValueMin
     */
    public void setValueMin(double _ValueMin) {
        this._ValueMin = _ValueMin;
    }

    /**
     * maximum value-space value
     *
     * @return
     */
    public double getValueMax() {
        return _ValueMax;
    }

    /**
     * Maximum value-space value
     *
     * @param _ValueMax
     */
    public void setValueMax(double _ValueMax) {
        this._ValueMax = _ValueMax;
    }

    /**
     * Minium pixel-space value
     *
     * @return
     */
    public int getPixMin() {
        return _pixMin;
    }

    /**
     * minimum pixel-space value
     *
     * @param _pixMin
     */
    public void setPixMin(int _pixMin) {
        this._pixMin = _pixMin;
    }

    /**
     * Maximum pixel-space value
     *
     * @return
     */
    public int getPixMax() {
        return _pixMax;
    }

    /**
     * Maximum pixel-spave value
     *
     * @param _pixMax
     */
    public void setPixMax(int _pixMax) {
        this._pixMax = _pixMax;
    }

    /**
     * resets the limit to its infinite counterparts (useful for min/max
     * initialization)
     */
    public void ResetInfValues() {
        _ValueMin = Double.MAX_VALUE;
        _ValueMax = Double.MIN_VALUE;
    }

    /**
     * Constructor
     *
     * @param vmin value space minimum
     * @param vmax value space maximum
     * @param pmin pixel space minimum
     * @param pmax pixel space maximum
     */
    public DrawingLimits(double vmin, double vmax, int pmin, int pmax) {
        _ValueMax = vmax;
        _ValueMin = vmin;
        _pixMax = pmax;
        _pixMin = pmin;
    }

    /**
     * Size in pixel space
     *
     * @return
     */
    public int dPixel() {
        return _pixMax - _pixMin;
    }

    /**
     * Size in value space
     *
     * @return
     */
    public double dValue() {
        return _ValueMax - _ValueMin;
    }
}
