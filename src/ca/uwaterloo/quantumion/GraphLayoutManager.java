/*
 * Copyright 2019 Rich.
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

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.io.Serializable;

/**
 * Swing LayoutManager for Graphic Plot Based on JDK BorderLayout Source Code
 *
 * @author Rich
 */
public class GraphLayoutManager implements LayoutManager, LayoutManager2, Serializable {

    /**
     * Orientation to the top
     */
    public static final String TOP = "Top";
    /**
     * Orientation to the left
     */
    public static final String LEFT = "Left";
    /**
     * Orientation to the right
     */
    public static final String RIGHT = "Right";
    /**
     * Orientation to the bottom
     */
    public static final String BOTTOM = "Bottom";
    /**
     * Orientation to the center
     */
    public static final String CENTER = "Center";

    /**
     * @serial
     */
    protected Component top;
    /**
     * @serial
     */
    protected Component bottom;
    /**
     * @serial
     */
    protected Component left;
    /**
     * @serial
     */
    protected Component right;
    /**
     * @serial
     */
    protected Component center;

    /**
     * meas_type field
     */
    private static final int MIN = 0;

    /**
     * meas_type field
     */
    private static final int MAX = 1;

    /**
     * meas_type field
     */
    private static final int PREF = 2;

    /**
     * Add a new layout component
     *
     * @param orientation Position constant
     * @param comp component to add
     */
    @Override
    public void addLayoutComponent(String orientation, Component comp) {
        switch (orientation) {
            case TOP:
                top = comp;
                break;
            case BOTTOM:
                bottom=comp;
                break;
            case LEFT:
                left=comp;
                break;
            case RIGHT:
                right=comp;
                break;
            case CENTER:
                center=comp;
                break;
            default:
                throw new IllegalArgumentException("Invalid orientation");
        }
    }

    /**
     * Remove a component from the layout
     *
     * @param comp
     */
    @Override
    public void removeLayoutComponent(Component comp) {
        if (top == comp) {
            top = null;
        }
        if (bottom == comp) {
            bottom = null;
        }
        if (right == comp) {
            right = null;
        }
        if (left == comp) {
            left = null;
        }
        if (center == comp) {
            center = null;
        }
    }

    /**
     * Get the preferred layout size
     * @param parent
     * @return 
     */
    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return calcSize(parent, PREF);
    }

    /**
     * Returns the minimum component size
     *
     * @param parent
     * @return
     */
    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension(5, 5);
    }

    @Override
    public void layoutContainer(Container parent) {
        synchronized(parent.getTreeLock())
        {
            Insets i = parent.getInsets();
            int outer_t = i.top;
            int outer_b = parent.getHeight() - i.bottom;
            int outer_l = i.left;
            int outer_r = parent.getWidth() - i.right;
            
            Dimension tdim = calcCompSize(top, PREF);
            Dimension bdim = calcCompSize(bottom, PREF);
            Dimension ldim = calcCompSize(left, PREF);
            Dimension rdim = calcCompSize(right, PREF);
            Dimension cdim = calcCompSize(center, PREF);

            int inner_t = outer_t + tdim.height;
            int inner_b = outer_b - bdim.height;
            int inner_l = outer_l + ldim.width;
            int inner_r = outer_r - rdim.height;
            
            if(top != null)
            {
                top.setBounds(inner_l, outer_t, inner_r-inner_l, tdim.height);
            }
            if(bottom != null)
            {
                bottom.setBounds(inner_l, inner_b, inner_r-inner_l, bdim.height);
            }
            if(left != null)
            {
                left.setBounds(outer_l, inner_t, ldim.width, inner_b-inner_t);
            }
            if(right != null)
            {
                right.setBounds(inner_r, inner_t, rdim.width, inner_b-inner_t);
            }
            if(center != null)
            {
                center.setBounds(inner_l, inner_t, inner_r-inner_l, inner_b-inner_t);
            }
        }
    }

    /**
     * Add a new component
     *
     * @param comp
     * @param constraints
     */
    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        if ((constraints == null) || !(constraints instanceof String)) {
            throw new IllegalArgumentException("Incorrect orientation!");
        } else {
            addLayoutComponent((String) constraints, comp);
        }
    }

    /**
     * Maximum size of the layout
     *
     * @param target
     * @return
     */
    @Override
    public Dimension maximumLayoutSize(Container target) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Returns the Y axis alignment, which is a <code>float</code> indicating
     * where along the Y axis this container wishs to position its layout. 0
     * indicates align to the top, 1 indicates align to the bottom, and 0.5
     * indicates align to the center.
     *
     * @param parent The parent container.
     *
     * @return The Y alignment value.
     */
    @Override
    public float getLayoutAlignmentX(Container parent) {
        return 0.5f;
    }

    /**
     * Returns the Y axis alignment, which is a <code>float</code> indicating
     * where along the Y axis this container wishs to position its layout. 0
     * indicates align to the top, 1 indicates align to the bottom, and 0.5
     * indicates align to the center.
     *
     * @param parent The parent container.
     *
     * @return The Y alignment value.
     */
    @Override
    public float getLayoutAlignmentY(Container parent) {
        return 0.5f;
    }

    /**
     * Force a layout invalidation (not used. no changes)
     *
     * @param target
     */
    @Override
    public void invalidateLayout(Container target) {
        // do nothing
    }

    /**
     * Get the object at each orientation
     *
     * @param orientation
     * @return
     */
    public Object getOrientation(String orientation) {
        switch (orientation) {
            case TOP:
                return top;
            case BOTTOM:
                return bottom;
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case CENTER:
                return center;
            default:
                return null;
        }
    }

    /**
     * Calculate size of the compoent
     *
     * @param comp
     * @param meas_style
     * @return
     */
    private Dimension calcCompSize(Component comp, int meas_style) {
        if ((comp == null) || (comp.isVisible() == false)) {
            return new Dimension(0, 0);
        }

        if (meas_style == MIN) {
            return comp.getMinimumSize();
        }
        if (meas_style == MAX) {
            return comp.getMaximumSize();
        }
        return comp.getPreferredSize();
    }

    /**
     * Calculate the size of the entire component
     *
     * @param target
     * @param meas_type
     * @return
     */
    private Dimension calcSize(Container target, int meas_type) {
        synchronized (target.getTreeLock()) {
            Insets ins = target.getInsets();

            Dimension tdim = calcCompSize(top, meas_type);
            Dimension bdim = calcCompSize(bottom, meas_type);
            Dimension ldim = calcCompSize(left, meas_type);
            Dimension rdim = calcCompSize(right, meas_type);
            Dimension cdim = calcCompSize(center, meas_type);

            int width = ldim.width + cdim.width + rdim.width;
            int height = tdim.height + cdim.height + bdim.height;

            return new Dimension(width + ins.left + ins.right, height + ins.bottom + ins.top);
        }
    }
}
