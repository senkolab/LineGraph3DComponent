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

/**
 * Interface for automatically generating grids
 * @author Rich
 * @version 1.0
 * @updated 01-Nov-2018 1:29:39 PM
 */
public interface IAutoGridder {

    /**
	 * Get major gridlines from explicit drawing limits
	 * 
	 * @returns
	 * 
	 * @param dl
	 */
    public double[] GetMajorGrid(DrawingLimits dl);

    /**
	 * Get major grid lines from either existing limits, or update with new traces
	 * 
	 * @returns
	 * 
	 * @param dl
	 * @param traces
	 */
    public double[] GetMajorGrid(DrawingLimits dl, Graph2DTrace[] traces);

    /**
	 * Get minor gridlines from explicit drawing limits
	 * 
	 * @returns
	 * 
	 * @param dl
	 */
    public double[] GetMinorGrid(DrawingLimits dl);

    /**
	 * Get minor grid lines from either existing limits, or update with new traces
	 * 
	 * @returns
	 * 
	 * @param dl
	 * @param traces
	 */
    public double[] GetMinorGrid(DrawingLimits dl, Graph2DTrace[] traces);

    /**
	 * Get String represenatation of the grid points
	 * 
	 * @returns
	 * 
	 * @param points
	 */
    public String[] GetGridLabels(double[] points);

    /**
     * Update the drawing limits
     *
     */
    public void GetNewDrawingLimits(DrawingLimits dl);

}
