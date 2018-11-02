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

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 * Implementation of a simple grid renderer
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 5:41:23 PM
 */
public class SimpleGridRenderer implements ISimpleRenderer {

    /**
     * Strokes for pens
     */
    Stroke _dashed;
    Stroke _solid;

    /**
     * Constructor
     */
    public SimpleGridRenderer() {
        _dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        _solid = new BasicStroke();
    }

    /**
     * Render the grid
     *
     * @param gc
     * @param s
     */
    @Override
    public void Render(Graphics gc, Graph2DSettings s) {
        Graphics2D g2d = (Graphics2D) gc;

        g2d.setColor(s.getGridColor());

        IGraph2DScaler xscale = s.getXScaler();
        IGraph2DScaler yscale = s.getYScaler();
        ICameraProjector proj = s.getProjector();

        // draw major gridlines
        g2d.setStroke(_solid);
        for (double value : s.getXMajorGrid()) {
            int[] xy1 = proj.Pixels(xscale.Convert(value), s.getYLimits().getValueMin(), 0.0, s);
            int[] xy2 = proj.Pixels(xscale.Convert(value), s.getYLimits().getValueMax(), 0.0, s);

            g2d.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
        }
        for (double value : s.getYMajorGrid()) {
            int[] xy1 = proj.Pixels(s.getXLimits().getValueMin(), yscale.Convert(value), 0.0, s);
            int[] xy2 = proj.Pixels(s.getXLimits().getValueMax(), yscale.Convert(value), 0.0, s);

            gc.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
        }

        // draw minor gridlines
        g2d.setStroke(_dashed);
        for (double value : s.getXMinorGrid()) {
            int[] xy1 = proj.Pixels(xscale.Convert(value), s.getYLimits().getValueMin(), 0.0, s);
            int[] xy2 = proj.Pixels(xscale.Convert(value), s.getYLimits().getValueMax(), 0.0, s);

            g2d.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
        }
        for (double value : s.getYMinorGrid()) {
            int[] xy1 = proj.Pixels(s.getXLimits().getValueMin(), yscale.Convert(value), 0.0, s);
            int[] xy2 = proj.Pixels(s.getXLimits().getValueMax(), yscale.Convert(value), 0.0, s);

            gc.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
        }
    }
}
