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
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rich
 */
public class LineGraph2DTest {

    public LineGraph2DTest() {
        SwingUtilities.invokeLater(() -> {

        });
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After

    public void tearDown() {
    }

    /**
     * Test of getSettings method, of class LineGraph2D.
     */
    @Test
    public void testGetSettings() {
        System.out.println("getSettings");
        LineGraph2D instance = new LineGraph2D();
        Graph2DSettings expResult = null;
        Graph2DSettings result = instance.getSettings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSettings method, of class LineGraph2D.
     */
    @Test
    public void testSetSettings() {
        System.out.println("setSettings");
        Graph2DSettings s = null;
        LineGraph2D instance = new LineGraph2D();
        instance.setSettings(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBackGroundColor method, of class LineGraph2D.
     */
    @Test
    public void testGetBackGroundColor() {
        System.out.println("getBackGroundColor");
        LineGraph2D instance = new LineGraph2D();
        Color expResult = null;
        Color result = instance.getBackGroundColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBackgroundColor method, of class LineGraph2D.
     */
    @Test
    public void testSetBackgroundColor() {
        System.out.println("setBackgroundColor");
        Color c = null;
        LineGraph2D instance = new LineGraph2D();
        instance.setBackgroundColor(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTextColor method, of class LineGraph2D.
     */
    @Test
    public void testGetTextColor() {
        System.out.println("getTextColor");
        LineGraph2D instance = new LineGraph2D();
        Color expResult = null;
        Color result = instance.getTextColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTextColor method, of class LineGraph2D.
     */
    @Test
    public void testSetTextColor() {
        System.out.println("setTextColor");
        Color c = null;
        LineGraph2D instance = new LineGraph2D();
        instance.setTextColor(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGridColor method, of class LineGraph2D.
     */
    @Test
    public void testGetGridColor() {
        System.out.println("getGridColor");
        LineGraph2D instance = new LineGraph2D();
        Color expResult = null;
        Color result = instance.getGridColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGridColor method, of class LineGraph2D.
     */
    @Test
    public void testSetGridColor() {
        System.out.println("setGridColor");
        Color c = null;
        LineGraph2D instance = new LineGraph2D();
        instance.setGridColor(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getXScaler method, of class LineGraph2D.
     */
    @Test
    public void testGetXScaler() {
        System.out.println("getXScaler");
        LineGraph2D instance = new LineGraph2D();
        IGraph2DScaler expResult = null;
        IGraph2DScaler result = instance.getXScaler();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setXScaler method, of class LineGraph2D.
     */
    @Test
    public void testSetXScaler() {
        System.out.println("setXScaler");
        IGraph2DScaler s = null;
        LineGraph2D instance = new LineGraph2D();
        instance.setXScaler(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYScaler method, of class LineGraph2D.
     */
    @Test
    public void testGetYScaler_0args() {
        System.out.println("getYScaler");
        LineGraph2D instance = new LineGraph2D();
        IGraph2DScaler expResult = null;
        IGraph2DScaler result = instance.getYScaler();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYScaler method, of class LineGraph2D.
     */
    @Test
    public void testGetYScaler_IGraph2DScaler() {
        System.out.println("getYScaler");
        IGraph2DScaler s = null;
        LineGraph2D instance = new LineGraph2D();
        instance.getYScaler(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTraces method, of class LineGraph2D.
     */
    @Test
    public void testGetTraces() {
        System.out.println("getTraces");
        LineGraph2D instance = new LineGraph2D();
        List<Graph2DTrace> expResult = null;
        List<Graph2DTrace> result = instance.getTraces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetTraces method, of class LineGraph2D.
     */
    @Test
    public void testSetTraces() {
        System.out.println("SetTraces");
        Graph2DTrace[] traces = null;
        LineGraph2D instance = new LineGraph2D();
        instance.SetTraces(traces);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetTrace method, of class LineGraph2D.
     */
    @Test
    public void testSetTrace() {
        System.out.println("SetTrace");
        Graph2DTrace t = null;
        LineGraph2D instance = new LineGraph2D();
        instance.SetTrace(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setXLimits method, of class LineGraph2D.
     */
    @Test
    public void testGetXLimits_0args() {
        System.out.println("getXLimits");
        LineGraph2D instance = new LineGraph2D();
        DrawingLimits expResult = null;
        DrawingLimits result = instance.getXLimits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setXLimits method, of class LineGraph2D.
     */
    @Test
    public void testGetXLimits_DrawingLimits() {
        System.out.println("getXLimits");
        DrawingLimits dl = null;
        LineGraph2D instance = new LineGraph2D();
        instance.setXLimits(dl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setYLimits method, of class LineGraph2D.
     */
    @Test
    public void testGetYLimits_0args() {
        System.out.println("getYLimits");
        LineGraph2D instance = new LineGraph2D();
        DrawingLimits expResult = null;
        DrawingLimits result = instance.getYLimits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setYLimits method, of class LineGraph2D.
     */
    @Test
    public void testGetYLimits_DrawingLimits() {
        System.out.println("getYLimits");
        DrawingLimits dl = null;
        LineGraph2D instance = new LineGraph2D();
        instance.setYLimits(dl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeExampleSine method, of class LineGraph2D.
     */
    @Test
    public void testMakeExampleSine() {
        System.out.println("makeExampleSine");
        LineGraph2D instance = new LineGraph2D();
        instance.makeExampleSine();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeExampleLine method, of class LineGraph2D.
     */
    @Test
    public void testMakeExampleLine() {
        System.out.println("makeExampleLine");
        LineGraph2D instance = new LineGraph2D();
        instance.makeExampleLine();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InitialSettings method, of class LineGraph2D.
     */
    @Test
    public void testInitialSettings() {
        System.out.println("InitialSettings");
        LineGraph2D instance = new LineGraph2D();
        instance.InitialSettings();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class LineGraph2D.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics gc = null;
        LineGraph2D instance = new LineGraph2D();
        instance.paintComponent(gc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of componentResized method, of class LineGraph2D.
     */
    @Test
    public void testComponentResized() {
        System.out.println("componentResized");
        ComponentEvent ce = null;
        LineGraph2D instance = new LineGraph2D();
        instance.componentResized(ce);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of componentMoved method, of class LineGraph2D.
     */
    @Test
    public void testComponentMoved() {
        System.out.println("componentMoved");
        ComponentEvent ce = null;
        LineGraph2D instance = new LineGraph2D();
        instance.componentMoved(ce);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of componentShown method, of class LineGraph2D.
     */
    @Test
    public void testComponentShown() {
        System.out.println("componentShown");
        ComponentEvent ce = null;
        LineGraph2D instance = new LineGraph2D();
        instance.componentShown(ce);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of componentHidden method, of class LineGraph2D.
     */
    @Test
    public void testComponentHidden() {
        System.out.println("componentHidden");
        ComponentEvent ce = null;
        LineGraph2D instance = new LineGraph2D();
        instance.componentHidden(ce);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public static int main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            LineGraph2D instance = new LineGraph2D();
            TestFrame frame = new TestFrame(instance);
        });
        return 0;

    }

    public static class TestFrame extends JFrame {

        public TestFrame(LineGraph2D graph) {
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setSize(200, 200);
            this.add(graph);
            this.pack();
            this.setVisible(true);
        }
    }
}
