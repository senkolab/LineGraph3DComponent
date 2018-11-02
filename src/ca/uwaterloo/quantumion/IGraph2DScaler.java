
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
 * Interface for pixel coordinate-to-r coordinate scaler
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 1:39:53 PM
 */
public interface IGraph2DScaler {

    /**
     *
     *
     * @param ="r"
     * @returns
     *
     * @param value
     */
    public double Convert(double value);

    /**
     *
     *
     * @returns
     *
     * @param pixelPosition
     */
    public double UnConvert(double pixelPosition);

}
