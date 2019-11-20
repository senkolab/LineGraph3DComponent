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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Annotated 2D graph with controls
 *
 * @author Rich
 * @version 1.0
 * @created 02-Nov-2018 12:18:40 AM
 */
public class Annotated2DGraph extends JPanel {

    protected AnnotationMargins _Margins = new AnnotationMargins(10, 10, 10, 25);
    protected LineGraph2D _Graph;
    protected TitlePanel _TitlePanel;
    protected XAnnotationPanel _XPanel;
    protected YAnnotationPanel _YPanel;

    /**
     * constructor
     */
    public Annotated2DGraph() {
        _Graph = new LineGraph2D();
        _TitlePanel = new TitlePanel();
        _XPanel = new XAnnotationPanel(_Graph);
        _YPanel = new YAnnotationPanel(_Graph);
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
     * Graph portion of the component
     *
     * @return
     */
    public LineGraph2D getGraph() {
        return _Graph;
    }

    /**
     * Graph portion of the component
     *
     * @param g
     */
    public void setGraph(LineGraph2D g) {
        _Graph = g;
        invalidate();
    }

    /**
     * Set up initial component settings after all objects have been created
     */
    public final void Initialize() {
        //SetMargins(10, 10, 10, 25);
        LayoutManager lm = new GraphLayoutManager();
        this.setLayout(lm);
        this.add(_Graph, GraphLayoutManager.CENTER);
        _Graph.setVisible(true);
        this.add(_TitlePanel, GraphLayoutManager.TOP);
        _TitlePanel.setVisible(true);
        this.add(_XPanel, GraphLayoutManager.BOTTOM);
        _XPanel.setVisible(true);
        this.add(_YPanel, GraphLayoutManager.LEFT);
        _YPanel.setVisible(true);

        this.setBounds(0, 0, 100, 100);
        this.setVisible(true);

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
     * Get the graph settings
     * @return 
     */
    public Graph2DSettings getSettings() {
        return _Graph.getSettings();
    }

    /**
     * Set the graph settings
     * @param value 
     */
    public void setSettings(Graph2DSettings value) {
        _Graph.setSettings(value);
        invalidate();
    }

    /**
     * Title Object
     */
    protected final class TitlePanel extends JLabel {

        public String _text;

        /**
         * Constructor
         */
        public TitlePanel() {
            this.setVisible(true);
            this.setHorizontalAlignment(SwingConstants.CENTER);
            this.setVerticalAlignment(SwingConstants.CENTER);
            this.setTitle("Title");
        }

        /**
         * Set the object title
         *
         * @param s
         */
        public void setTitle(String s) {
            _text = "Title";
            this.setText(_text);
            int h = this.getFontMetrics(this.getFont()).getHeight();
            if (_text.isBlank()) {
                h = 10;
            }
            this.setPreferredSize(new Dimension(10, h));
        }

        /**
         * Get the object title
         *
         * @return
         */
        public String getString() {
            return getText();
        }

        /**
         * Set color
         *
         * @param c
         */
        public void setColor(Color c) {
            setForeground(c);
            invalidate();
        }

        /**
         * Get color
         *
         * @return
         */
        public Color getColor() {
            return getForeground();
        }

    }

    /**
     * X annotation label panel
     */
    private class XAnnotationPanel extends JPanel {

        /**
         * Annotation rendering object
         */
        private I2DAnnotationRenderer _annotation;

        /**
         * text label for the graphic
         */
        private String _label;

        /**
         * Constructor
         *
         * @param graph
         */
        public XAnnotationPanel(LineGraph2D graph) {
            _annotation = new Panel2DAnnotation(graph, this);
            this.setPreferredSize(new Dimension(20, 20));
        }

        /**
         * Redraw the panel
         *
         * @param g
         */
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            getAnnotation().RenderXGridLabels(g);
        }

        /**
         * @return the _annotation
         */
        public I2DAnnotationRenderer getAnnotation() {
            return _annotation;
        }

        /**
         * @param _annotation the _annotation to set
         */
        public void setAnnotation(I2DAnnotationRenderer _annotation) {
            this._annotation = _annotation;
            invalidate();
        }

        /**
         * @return the _label
         */
        public String getLabel() {
            return _label;
        }

        /**
         * @param _label the _label to set
         */
        public void setLabel(String _label) {
            this._label = _label;
            invalidate();
        }
    }

    /**
     * Y annotation label panel
     */
    private class YAnnotationPanel extends JPanel {

        /**
         * Annotation rendering object
         */
        private I2DAnnotationRenderer _annotation;

        /**
         * text label for the graphic
         */
        private String _label;

        /**
         * Constructor
         *
         * @param annotation
         */
        public YAnnotationPanel(LineGraph2D graph) {
            _annotation = new Panel2DAnnotation(graph, this);
            this.setPreferredSize(new Dimension(50, 20));
        }

        /**
         * Redraw the panel
         *
         * @param g
         */
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            getAnnotation().RenderYGridLabels(g);
        }

        /**
         * @return the _annotation
         */
        public I2DAnnotationRenderer getAnnotation() {
            return _annotation;
        }

        /**
         * @param _annotation the _annotation to set
         */
        public void setAnnotation(I2DAnnotationRenderer _annotation) {
            this._annotation = _annotation;
            invalidate();
        }

        /**
         * @return the _label
         */
        public String getLabel() {
            return _label;
        }

        /**
         * @param _label the _label to set
         */
        public void setLabel(String _label) {
            this._label = _label;
            invalidate();
        }
    }

}
