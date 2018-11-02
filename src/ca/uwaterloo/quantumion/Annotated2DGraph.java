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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 * Annotated 2D graph with controls
 *
 * @author Rich
 * @version 1.0
 * @created 02-Nov-2018 12:18:40 AM
 */
public class Annotated2DGraph extends JPanel {

    protected AnnotationMargins _Margins = new AnnotationMargins(10, 10, 10, 25);
    protected ISimpleRenderer _Annotator;
    protected LineGraph2D _Graph;

    /**
     * constructor
     */
    public Annotated2DGraph() {
        _Graph = new LineGraph2D();
        _Annotator = new Simple2DAnnotation(_Graph);
        this.Initialize();
    }

    /**
     * Annotation margins [top, right, bottom, left]
     *
     * @return
     */
    public int[] getMargins() {
        return new int[]{_Margins.Top, _Margins.Right, _Margins.Bottom, _Margins.Left};
    }

    /**
     * Annotation margins [top, right, bottom, left]
     *
     * @param v
     */
    public void setMargins(int[] v) {
        SetMargins(v[0], v[1], v[2], v[3]);
        invalidate();
    }

    /**
     * Annotation handler
     *
     * @return
     */
    public ISimpleRenderer getAnnotator() {
        return _Annotator;
    }

    /**
     * Annotation handler
     *
     * @return
     */
    public void setAnnotator(ISimpleRenderer r) {
        _Annotator = r;
        invalidate();
    }

    /**
     * Graph portion of the component
     */
    public LineGraph2D getGraph() {
        return _Graph;
    }

    /**
     * Graph portion of the component
     */
    public void setGraph(LineGraph2D g) {
        _Graph = g;
        invalidate();
    }

    /**
     * Set up initial component settings after all objects have been created
     */
    public void Initialize() {
        SetMargins(10, 10, 10, 25);
        this.add(_Graph);
        _Graph.setVisible(true);
        _Annotator = new Simple2DAnnotation(_Graph);

    }

    /**
     * Sets the annotation margins
     *
     * @param top
     * @param right
     * @param bottom
     * @param left
     */
    public void SetMargins(int top, int right, int bottom, int left) {
        _Margins.Top = top;
        _Margins.Right = right;
        _Margins.Bottom = bottom;
        _Margins.Left = left;

        this.setMinimumSize(new Dimension(_Margins.Left + _Margins.Right + _Graph.getMinimumSize().width,
            _Margins.Top + _Margins.Bottom + _Graph.getMinimumSize().height));
        invalidate();

    }

    /**
     * Resize the graph subcomponent
     */
    public void ResizeGraph() {
        _Graph.setSize(new Dimension(getWidth() - _Margins.Left - _Margins.Right,
            getHeight() - _Margins.Top - _Margins.Bottom));

        _Graph.setLocation(new Point(_Margins.Left, _Margins.Bottom));
        _Graph.invalidate();
    }

    /**
     * Paint the component handler
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        _Graph.invalidate();
        _Annotator.Render(g, _Graph.getSettings());
    }

}
