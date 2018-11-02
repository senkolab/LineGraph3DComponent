
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
 * Interface specification to render trances
 *
 * @author Rich
 * @version 1.0
 * @created 01-Nov-2018 1:41:32 PM
 */
public interface ITraceRenderer {

    /**
     * Render a single traces
     *
     * @param ="traces" traces to be rendered
     *
     * @param gc Graphics context
     * @param settings Settings
     * @param trace
     * @param idx traces relative index (for coloring, etc)
     */
    public void RenderTrace(Graphics gc, Graph2DSettings settings, Graph2DTrace trace, int idx);

    /**
     * Reset the redering state machine if applicable
     */
    public void Reset();

}
