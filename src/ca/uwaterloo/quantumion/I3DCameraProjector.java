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
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 1:33:38 PM
 */
public interface I3DCameraProjector {

	/**
	 * Implements a mouse pan/tilt
	 * 
	 * @param dx    delta X ordinate
	 * @param dy    delta Y ordinate
	 * @param settings    Settings object
	 */
	public void MouseRotate(int dx, int dy, Graph3DSettings settings);

	/**
	 * Adjust azimuth by a relative amount
	 * 
	 * @param value
	 */
	public void BumpAzimuthDegrees(double value);

	/**
	 * Adjust elevation by a relative amount
	 * 
	 * @param value
	 */
	public void BumpElevationDegrees(double value);

}