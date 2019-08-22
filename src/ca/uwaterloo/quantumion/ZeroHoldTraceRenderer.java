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
 * Implement ITraceRenderer for "zero-order-hold" drawing (e.g. logic analyzers)
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 6:08:30 PM
 */
public class ZeroHoldTraceRenderer implements ITraceRenderer {

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

        if(trace.getXPoints().length < 1)
            return;
        
        int[] xpts = new int[2*trace.getXPoints().length - 1];
        int[] ypts = new int[2*trace.getYPoints().length - 1];

        g2.setColor(trace.getColor());
        g2.setStroke(trace.getStroke());
     
        int[] xy0;
        int[] xy1;

        // do first point
        xy0 = settings.getProjector().Pixels(
            xscaler.Convert(trace.getXPoints()[0]),
            yscaler.Convert(trace.getYPoints()[0]),
            0.0, settings);
        xpts[0] = xy0[0];
        ypts[0] = xy0[1];
        
        // do rest of ponts
        for (int n = 1; n < trace.getXPoints().length; n++) {
            xy1 = settings.getProjector().Pixels(
                xscaler.Convert(trace.getXPoints()[n]),
                yscaler.Convert(trace.getYPoints()[n]),
                0.0, settings);
            
            xpts[2*n-1] = xy1[0];   // advance x to new point
            ypts[2*n-1] = xy0[1];   // ...but keep previous height
            xpts[2*n] = xy1[0];
            ypts[2*n] = xy1[1];
            
            // hold previous results
            xy0 = xy1;
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
