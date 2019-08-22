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
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Test form for Annotated 2D graph
 *
 * @author Rich
 */
public final class TestGraphLayoutManager extends JFrame {

    public TestGraphLayoutManager() {
        this.setLayout(new GraphLayoutManager());
        
        this.add(new JLabel("Top"), GraphLayoutManager.TOP);
        this.add(new JLabel("Bottom"), GraphLayoutManager.BOTTOM);
        this.add(new JLabel("Center"), GraphLayoutManager.CENTER);
        this.add(new JLabel("Left"), GraphLayoutManager.LEFT);
        this.add(new JLabel("Right"), GraphLayoutManager.RIGHT);
        
        for(Component c: this.getRootPane().getComponents())
        {
            if(!(c instanceof JPanel))
                break;
            ((JPanel)c).setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            ((JPanel)c).setAlignmentX(CENTER_ALIGNMENT);
            ((JPanel)c).setAlignmentY(CENTER_ALIGNMENT);
        }

        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.pack();
        this.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TestGraphLayoutManager frame = new TestGraphLayoutManager();
        });
    }

}
