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
import java.awt.Rectangle;

/**
 * Render the background with a simple flat color
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 5:35:28 PM
 */
public class SimpleBackgroundRenderer implements ISimpleRenderer {

    /**
     * Render with a background color
     *
     * @param gc
     * @param settings
     */
    @Override
    public void Render(Graphics gc, Graph2DSettings settings) {
        gc.setColor(settings.getBGColor());
        Rectangle r = settings.getPixelRectangle();
        gc.fillRect(r.x, r.y, r.width, r.height);
    }

}
