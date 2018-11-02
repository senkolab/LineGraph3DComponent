
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

import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;

/**
 * TOp level class for a 3D linegraph component
 *
 * @author Rich
 */
public class LineGraph3DComponent extends JPanel {

    protected Graph3DSettings _Settings;

    protected ISimpleRenderer _BackgroundRenderer;

    protected I3DGridRenderer _GridRenderer;

    protected ITraceRenderer _TraceRenderer;

    protected ISimpleRenderer _GridLabelRenderer;

    protected List<Graph3DTrace> _Traces;

    protected Color _BackgroundColor;

    protected Color _TextColor;

    protected Color _GridColor;

    protected IGraph2DScaler _XScaler;

    protected IGraph2DScaler _YScaler;

    protected DrawingLimits _XLimits;

    protected DrawingLimits _YLimits;

    protected double _AzimuthDeg;

    protected double _ElevationDeg;

    protected Color _GridPlaneColor;

    protected boolean _XAutoGrid;

    protected boolean _YAutoGrid;

    protected boolean _ZAutoGrid;

}
