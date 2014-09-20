package de._1nulleins0.Parable;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

    public Window(int w, int h, String title, Main m) {

	m.setPreferredSize(new Dimension(w, h));
	m.setMaximumSize(new Dimension(w, h));
	m.setMinimumSize(new Dimension(w, h));

	JFrame frame = new JFrame(title);
	frame.add(m);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);

	m.start();
    }

}
