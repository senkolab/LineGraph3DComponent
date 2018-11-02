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
 * Implementation of a Graph Scaler for linear scaling between r space and pixel
 * space
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 3:49:34 PM
 */
public class LinearScaler implements IGraph2DScaler {

    private double _scale;
    private double _offset;

    /**
     * Constructor
     */
    public LinearScaler() {
        _scale = 1.0;
        _offset = 0.0;
    }
    
    /**
     * constructor
     * @param scale
     * @param offset 
     */
    public LinearScaler(double scale, double offset)
    {
        _scale = scale;
        _offset = offset;
    }
    /**
     * sets the scale factor
     *
     * @return
     */
    public double getScale() {
        return _scale;
    }

    /**
     * sets the scale factor
     *
     * @param d
     */
    public void getScale(double d) {
        _scale = d;
    }

    /**
     * the affine offset
     *
     * @return
     */
    public double getOffset() {
        return _offset;
    }

    /**
     * the affine offset
     *
     * @param d
     */
    public void getOffset(double d) {
        _offset = d;
    }

    /**
     *
     * @param value
     * @return
     */
    @Override
    public double Convert(double value) {
        return value * _scale + _offset;
    }

    /**
     *
     * @param value
     * @return
     */
    @Override
    public double UnConvert(double value) {
        return (value - _offset) / _scale;
    }

}
