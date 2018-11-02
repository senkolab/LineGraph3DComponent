package ca.uwaterloo.quantumion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

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
 * Implements IColorChooser for single color
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 3:58:15 PM
 */
public class CyclicColorChooser implements IColorChooser {

    private final Color[] _colors;

    private final Stroke[] _strokes;
    
    private final int _defaultWidth = 1;
    
    /**
     * CONSTRUCTOR
     *
     * @param colorArgs... variable length list of colors
     */
    public CyclicColorChooser(Color ...colorArgs) {
        _colors = new Color[colorArgs.length];
        
        System.arraycopy(colorArgs, 0, _colors, 0, colorArgs.length);    
        _strokes = new Stroke[]{new BasicStroke(_defaultWidth)};
    }

    /**
     * Get total number of colors
     *
     * @return
     */
    @Override
    public int GetTotalColors() {
        return _colors.length;
    }

    /**
     * Get color by index
     *
     * @param n
     * @return
     */
    @Override
    public Color GetColorByIndex(int n) {

        return _colors[n % _colors.length];
    }

    /**
     * Applies the color defaults
     *
     * @param t
     * @param n
     */
    @Override
    public void ApplyNextColor(Graph2DTrace t, int n) {
        t.setColor(_colors[n % _colors.length]);
        t.setStroke(_strokes[n % _strokes.length]);
    }

}
