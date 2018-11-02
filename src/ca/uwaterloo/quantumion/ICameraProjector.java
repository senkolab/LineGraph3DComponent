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
 * Projector for a world coordinate system to a 2D screen coordinate
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 1:38:03 PM
 */
public interface ICameraProjector {

	/**
	 * Convert world coordinates to paper coordinates
	 * 
	 * @returns
	 * 
	 * @param coords
	 * @param settings
	 */
	public int[] Pixels(double[] coords, Graph2DSettings settings);

	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param settings
	 */
	public int[] Pixels(double x, double y, double z, Graph2DSettings settings);

	/**
	 * 
	 * @param pixel
	 * @param settings
	 */
	public double[] Position(int[] pixel, Graph2DSettings settings);

}