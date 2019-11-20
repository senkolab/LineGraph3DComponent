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
 * Implementation of a Graph Scaler for decibel scaling between r space and pixel
 * space
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 3:49:34 PM
 */
public class DecibelScaler implements IGraph2DScaler {

    private double _scale;

    /**
     * Constructor
     */
    public DecibelScaler() {
        _scale = 20.0;
    }
    
    /**
     * constructor
     * @param scale
     */
    public DecibelScaler(double scale)
    {
        _scale = scale;
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
    public void setScale(double d) {
        _scale = d;
    }


    /**
     * Converts original value to scaled value
     * @param value
     * @return
     */
    @Override
    public double Convert(double value) {
        return _scale * Math.log10(Math.abs(value));
    }

    /**
     * Un-does converter
     * @param value
     * @return
     */
    @Override
    public double UnConvert(double value) {
        return Math.pow(10.0, value / _scale);
    }

}
