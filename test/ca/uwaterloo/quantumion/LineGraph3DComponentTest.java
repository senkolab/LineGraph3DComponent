/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uwaterloo.quantumion;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for LineGraph3D component
 * @author Rich
 */
public class LineGraph3DComponentTest {
    
    public LineGraph3DComponentTest() {
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
     * Test of main method, of class LineGraph3DComponent.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        
        SwingUtilities.invokeLater(() -> {
            TestForm form = new TestForm(new LineGraph3DComponent());
        });
    }
    
    public class TestForm extends JFrame {
        public TestForm(LineGraph3DComponent c) {
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.add(c);
            this.setSize(200, 200);
            this.setVisible(true);
            this.setTitle("TestForm");
            this.pack();
            
        }
    }
}
