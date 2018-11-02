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
 * Annotation margins
 * @author Rich
 * @version 1.0
 * @created 02-Nov-2018 12:20:23 AM
 */
public class AnnotationMargins {

	public int Top;
	public int Right;
	public int Left;
	public int Bottom;

	public AnnotationMargins(){

	}

	/**
	 * 
	 * @param top
	 * @param right
	 * @param bottom
	 * @param left
	 */
	public AnnotationMargins(int top, int right, int bottom, int left){
            Top = top;
            Left = left;
            Right = right;
            Bottom = bottom;
	}

}