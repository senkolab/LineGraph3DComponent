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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Component;

/**
 * Implements a 2D annotation renderer for separate panels
 *
 * @author Rich
 * @version 1.0
 * @created 02-Nov-2018 12:35:23 AM
 */
public class Panel2DAnnotation implements I2DAnnotationRenderer, ISimpleRenderer {

    protected LineGraph2D _Graph;
    protected Font _GridLabelFont;
    protected Color _GridLabelColor;
    protected Font _AxisLabelFont;
    /**
     * Axis label font color
     */
    protected Color _AxisLabelColor;
    /**
     * Title font
     */
    protected Font _TitleFont;
    /**
     * title font color
     */
    protected Color _TitleFontColor;
    protected String _Title;
    protected String _XLabel;
    protected String _YLabel;

    protected Component _Parent;
    /**
     * Constructor
     *
     *
     * @param Graph
     * @param parent
     */
    public Panel2DAnnotation(LineGraph2D Graph, Component parent) {
        _Graph = Graph;
        _GridLabelFont = new Font("Arial", Font.PLAIN, 10);
        _GridLabelColor = Color.BLACK;

        _AxisLabelFont = new Font("Arial", Font.PLAIN, 8);
        _AxisLabelColor = Color.BLACK;

        _TitleFont = new Font("Arial", Font.PLAIN, 12);
        _TitleFontColor = Color.BLACK;

        _XLabel = "XLabel";
        _YLabel = "Ylabel";
        _Title = "Title";
        _Parent = parent;
    }

    /**
     * Change the annotation font
     *
     * @return
     */
    public Font getGridLabelFont() {
        return _GridLabelFont;
    }

    /**
     * Change the annotation font
     *
     * @param f
     */
    public void setGridLabelFont(Font f) {
        _GridLabelFont = f;
    }

    /**
     * Gridline label colors
     *
     * @return
     */
    public Color getGridLabelColor() {
        return _GridLabelColor;
    }

    /**
     * Gridline label colors
     *
     * @param c
     */
    public void setGridLabelColor(Color c) {
        _GridLabelColor = c;
    }

    /**
     * Axis label font
     *
     * @return
     */
    public Font getAxisLabelFont() {
        return _AxisLabelFont;
    }

    /**
     * Axis label font
     *
     * @param f
     */
    public void setAxisLabelFont(Font f) {
        _AxisLabelFont = f;
    }

    /**
     * Axis label color
     *
     * @return
     */
    public Color getAxisLabelColor() {
        return _AxisLabelColor;
    }

    /**
     * Axis label color
     *
     * @param c
     */
    public void setAxisLabelColor(Color c) {
        _AxisLabelColor = c;
    }

    /**
     * Title font
     *
     * @return
     */
    public Font TitleFont() {
        return _TitleFont;
    }

    /**
     * Title font
     *
     * @param f
     */
    public void TitleFont(Font f) {
        _TitleFont = f;
    }

    /**
     * Title font color
     *
     * @return
     */
    public Color getTitleFontColor() {
        return _TitleFontColor;
    }

    /**
     * Title font color
     *
     * @param c
     */
    public void getTitleFontColor(Color c) {
        _TitleFontColor = c;
    }

    /**
     * Graph Title
     *
     * @return
     */
    public String getTitle() {
        return _Title;
    }

    /**
     * Graph Title
     *
     * @param s
     */
    public void setTitle(String s) {
        _Title = s;
    }

    /**
     * Graph X axis label
     *
     * @return
     */
    public String getXLabel() {
        return _XLabel;
    }

    /**
     * Graph X axis label
     *
     * @param s
     */
    public void setXLabel(String s) {
        _XLabel = s;
    }

    /**
     * Graph Y axis label
     *
     * @return
     */
    public String getYLabel() {
        return _YLabel;
    }

    /**
     * Graph Y axis label
     *
     * @param s
     */
    public void setYLabel(String s) {
        _YLabel = s;
    }

    /**
     * Render all X grid labels
     *
     * @param gc
     */
    public void RenderXGridLabels(Graphics gc) {
        
        Graphics2D g2 = (Graphics2D) gc;
        Graph2DSettings s = _Graph.getSettings();
        double[] gridlines = s.getXMajorGrid();
        String[] gridlabels = s.getXMajorGridLabels();
        ICameraProjector proj = s.getProjector();
        double ymin = s.getYLimits().getValueMin();

        int[] xy;
        int x;
        int y;

        g2.setFont(_GridLabelFont);
        g2.setColor(_TitleFontColor);
        for (int n = 0; n < gridlabels.length; n++) {
            xy = proj.Pixels(gridlines[n], ymin, 0.0, s);
            FontMetrics fm = g2.getFontMetrics();
            x = xy[0] - fm.stringWidth(gridlabels[n]) / 2;
            y = fm.getHeight();

            g2.drawString(gridlabels[n], x, y);
        }
    }

    /**
     * Render all Y grid labels
     *
     * @param gc
     */
    public void RenderYGridLabels(Graphics gc ) {
        Graphics2D g2 = (Graphics2D) gc;
        Graph2DSettings s = _Graph.getSettings();
        double[] gridlines = s.getYMajorGrid();
        String[] gridlabels = s.getYMajorGridLabels();
        ICameraProjector proj = s.getProjector();
        double xmin = s.getXLimits().getValueMin();

        int[] xy;
        int x;
        int y;

        g2.setFont(_GridLabelFont);
        g2.setColor(_TitleFontColor);
        for (int n = 0; n < gridlabels.length; n++) {
            xy = proj.Pixels(xmin, gridlines[n], 0.0, s);
            FontMetrics fm = g2.getFontMetrics();
            y = xy[1] + fm.getHeight()/2;
            x = _Parent.getWidth() - fm.stringWidth(gridlabels[n]);

            g2.drawString(gridlabels[n], x, y);
        }
    }

    /**
     * Render titles
     *
     *
     * @param gc
     * @param Title
     */
    public void RenderTitle(Graphics gc, String Title) {

    }

    /**
     *
     * @param gc
     * @param XLabel
     */
    public void RenderXLabel(Graphics gc, String XLabel) {

    }

    /**
     *
     * @param gc
     * @param YLabel
     */
    public void RenderYLabel(Graphics gc, String YLabel) {

    }

    /**
     * Render the annotations
     *
     * @param gc
     * @param settings
     */
    public void Render(Graphics gc, Graph2DSettings settings) {
        Graphics2D g2 = (Graphics2D) gc;

        g2.setColor(_GridLabelColor);

        RenderXGridLabels(gc);
        RenderYGridLabels(gc);
    }

}
