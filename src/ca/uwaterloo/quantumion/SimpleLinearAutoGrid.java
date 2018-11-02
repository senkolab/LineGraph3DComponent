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
 * Simplistic grid making routine
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 4:05:28 PM
 */
public class SimpleLinearAutoGrid implements IAutoGridder {

    /**
     * Sets the major grid
     *
     * @return
     *
     * @param dl
     */
    @Override
    public double[] GetMajorGrid(DrawingLimits dl) {
        // special case for dValue = 0
        double exp = (dl.dValue() != 0) ? Math.floor(Math.log10(Math.abs(dl.dValue()))) : 0;
        double mant = (dl.dValue() != 0) ? dl.dValue() / Math.pow(10.0, exp) : 1;

        double delta_exp;
        int numticks;
        double[] val;

        // use lookup table to figure out the delta steps (in log)
        if (mant <= 2.5) {
            delta_exp = 0.5;
        } else if (mant <= 4.0) {
            delta_exp = 1.0;
        } else if (mant <= 6.0) {
            delta_exp = 2.0;
        } else {
            delta_exp = 2.5;
        }

        numticks = (int) Math.floor(mant / delta_exp) - 1;

        try{
        val = new double[numticks];

        // each tick is the next in the "dlog" steps
        for (int n = 0; n < numticks; n++) {
            val[n] = dl.getValueMin() + ((double) n + 1) * delta_exp * Math.pow(10.0, exp);
        }

        return val;
        }
        catch (Exception ex) {
            return new double[0];
        }
    }

    /**
     * Create a major gridlne
     *
     * @param dl
     * @param traces
     * @return
     */
    @Override
    public double[] GetMajorGrid(DrawingLimits dl, Graph2DTrace[] traces) {
        // not unique for each trace
        return GetMajorGrid(dl);
    }

    /**
     * Creates a major gridline
     *
     * @param dl
     * @return
     */
    @Override
    public double[] GetMinorGrid(DrawingLimits dl) {
        // special case for dvalue = 0
        double exp = (dl.dValue() != 0) ? Math.floor(Math.log10(Math.abs(dl.dValue()))) : 0;
        double mant = (dl.dValue() != 0) ? dl.dValue() / Math.pow(10.0, exp) : 1;
        double delta_minor;

        // use lookup table to figure out the delta steps (in log)
        if (mant <= 2.5) {
            delta_minor = 0.25;
        } else if (mant <= 4.0) {
            delta_minor = 0.50;
        } else if (mant <= 6.0) {
            delta_minor = 1.0;
        } else {
            delta_minor = 2.0;
        }

        int numticks = (int) Math.floor(mant / delta_minor) - 1;

        double[] val = new double[numticks];

        // each tick is the next in the steps, with div-by-10 subdivisions
        for (int n = 0; n < numticks; n++) {
            val[n] = dl.getValueMin() + ((double) n + 1) * delta_minor * Math.pow(10.0, exp);
        }

        return val;
    }

    /**
     * Create a minor gridset
     *
     * @param dl
     * @param traces
     * @return
     */
    @Override
    public double[] GetMinorGrid(DrawingLimits dl, Graph2DTrace[] traces) {
        // not implemented uniquely with Traces
        return GetMinorGrid(dl);
    }

    /**
     * get the labels of the gridlines
     *
     * @param points
     * @return
     */
    @Override
    public String[] GetGridLabels(double[] points) {
        String[] result = new String[points.length];

        for (int n = 0; n < points.length; n++) {
            result[n] = String.format("%.3g", points[n]);
        }

        return result;
    }

    /**
     *
     * @param dl
     */
    @Override
    public void GetNewDrawingLimits(DrawingLimits dl) {
        // special case for dValue = 0
        double exp = (dl.dValue() != 0) ? Math.floor(Math.log10(Math.abs(dl.dValue()))) : 0;
        double mant = (dl.dValue() != 0) ? dl.dValue() / Math.pow(10.0, exp) : 1;

        double delta_exp;

        // use lookup table to figure out the delta steps (in log)
        if (mant <= 2.5) {
            delta_exp = 0.5;
        } else if (mant <= 4.0) {
            delta_exp = 1.0;
        } else if (mant <= 6.0) {
            delta_exp = 2.0;
        } else {
            delta_exp = 2.5;
        }

        double roundval = delta_exp * Math.pow(10.0, exp);
        dl.setValueMin(Math.floor(dl.getValueMin() / roundval) * roundval);
        dl.setValueMax(Math.ceil(dl.getValueMax() / roundval) * roundval);
    }
}
