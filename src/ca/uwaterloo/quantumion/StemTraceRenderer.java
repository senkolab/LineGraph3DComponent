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

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Implement ITraceRenderer for "stem" drawing
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 6:08:30 PM
 */
public class StemTraceRenderer implements ITraceRenderer {

    /**
     * render each traces
     *
     *
     * @param gc
     * @param settings
     * @param trace
     * @param idx
     */
    @Override
    public void RenderTrace(Graphics gc, Graph2DSettings settings, Graph2DTrace trace, int idx) {
        Graphics2D g2 = (Graphics2D) gc;
        
        IGraph2DScaler xscaler = settings.getXScaler();
        IGraph2DScaler yscaler = settings.getYScaler();

        int[] xpts = new int[trace.getXPoints().length];
        int[] ypts = new int[trace.getYPoints().length];

        g2.setColor(trace.getColor());
        g2.setStroke(trace.getStroke());
        
        for (int n = 0; n < xpts.length; n++) {
            int[] xy0 = settings.getProjector().Pixels(
                xscaler.Convert(trace.getXPoints()[n]),
                yscaler.Convert(0.0),
                0.0, settings);
            
            int[] xy1 = settings.getProjector().Pixels(
                xscaler.Convert(trace.getXPoints()[n]),
                yscaler.Convert(trace.getYPoints()[n]),
                0.0, settings);
            
            g2.drawLine(xy0[0], xy0[1], xy1[0], xy1[1]);
            g2.drawOval(xy1[0]-settings.getStemHeadSize()/2, xy1[1]-settings.getStemHeadSize()/2, 
                    settings.getStemHeadSize(), settings.getStemHeadSize());
        }

        
        g2.drawPolyline(xpts, ypts, xpts.length);
    }

    /**
     * Reset required by interface
     */
    @Override
    public void Reset() {
        // do nothing, but required by interface
    }
}
