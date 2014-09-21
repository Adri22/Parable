package de._1nulleins0.Parable;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Window {

    ControlPanel cp;
    JPanel frameholder;
    JSplitPane splitpane;
    
    public Window(int w, int h, String title, Main m) {
	cp = new ControlPanel();
	frameholder = new JPanel();
	splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	cp.setPreferredSize(new Dimension(w, 50));
	cp.setMaximumSize(new Dimension(w, 50));
	cp.setMinimumSize(new Dimension(w, 50));
	
	m.setPreferredSize(new Dimension(w, h));
	m.setMaximumSize(new Dimension(w, h));
	m.setMinimumSize(new Dimension(w, h));
	
	frameholder.add(m);
	
	splitpane.setBottomComponent(cp);
        splitpane.setTopComponent(frameholder);
        
	JFrame frame = new JFrame(title);
	frame.add(splitpane);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);

	m.start();
    }

}
