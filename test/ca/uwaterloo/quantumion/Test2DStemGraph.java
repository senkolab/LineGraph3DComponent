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

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Test form for 2D graph
 *
 * @author Rich
 */
public class Test2DStemGraph extends JFrame {

    public Test2DStemGraph() {
        this.setLayout(new BorderLayout());
        LineGraph2D graph = new LineGraph2D();
        graph.setTraceRenderer(new StemTraceRenderer());
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(200, 200);
        this.add(graph, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            LineGraph2D instance = new LineGraph2D();
            Test2DStemGraph frame = new Test2DStemGraph();
        });
    }

}
