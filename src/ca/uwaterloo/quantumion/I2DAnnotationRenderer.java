
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

/**
 * Defines the interface for an annotation renderer
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 1:32:24 PM
 */
public interface I2DAnnotationRenderer {

    /**
     * Render the graph title
     *
     * @param gc
     * @param Title
     */
    public void RenderTitle(Graphics gc, String Title);

    /**
     * Render the X axis label
     *
     * @param gc
     * @param XLabel
     */
    public void RenderXLabel(Graphics gc, String XLabel);

    /**
     * Render the Y axis label
     *
     * @param gc
     * @param YLabel
     */
    public void RenderYLabel(Graphics gc, String YLabel);

}
