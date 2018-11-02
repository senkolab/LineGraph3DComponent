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
 * Implementation of a simple 2D camera projection
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 4:20:31 PM
 */
public class Simple2DProjector implements ICameraProjector {

    /**
     * convert world coordinates to pixel coordinates
     *
     * @return
     *
     * @param coords 2D or 3-D coordinates in world space
     * @param settings Settings object
     */
    @Override
    public int[] Pixels(double[] coords, Graph2DSettings settings) {
        return Pixels(coords[0], coords[1], 0.0, settings);
    }

    /**
     * convert world coordinates to pixel coordinates
     *
     * @return
     *
     * @param x
     * @param y
     * @param z
     * @param settings
     */
    @Override
    public int[] Pixels(double x, double y, double z, Graph2DSettings settings) {
        int[] result = new int[2];

        DrawingLimits xl = settings.getXLimits();
        DrawingLimits yl = settings.getYLimits();

        result[0] = xl.getPixMin() + (int) Math.round((x - xl.getValueMin()) * ((double) xl.dPixel() / (double) xl.dValue()));
        result[1] = yl.getPixMin() + (int) Math.round((y - yl.getValueMin()) * ((double) yl.dPixel() / (double) yl.dValue()));

        return result;
    }

    /**
     * Converts position in pixel space to world coordinates
     *
     * @return
     * @param pixel
     * @param settings
     */
    @Override
    public double[] Position(int[] pixel, Graph2DSettings settings) {
        double[] result = new double[2];

        int x = pixel[0];
        int y = pixel[1];

        DrawingLimits xl = settings.getXLimits();
        DrawingLimits yl = settings.getYLimits();

        result[0] = xl.getValueMin() + ((x - xl.getPixMin() * ((double) (xl.dValue()) / (double) xl.dPixel())));
        result[1] = yl.getValueMin() + ((y - yl.getPixMin() * ((double) (yl.dValue()) / (double) yl.dPixel())));

        return result;
    }

}
