package de._1nulleins0.Parable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel formulaPanel;
    private JLabel formulaPart1;
    public static JTextField a;
    private JLabel formulaPart2;
    public static JTextField d;
    private JLabel formulaPart3;
    public static JTextField e;
    private JLabel formulaPart4;

    public ControlPanel() {
	formulaPanel = new JPanel();
	formulaPart1 = new JLabel("y = ");
	a = new JTextField(3);
	formulaPart2 = new JLabel("[x - (");
	d = new JTextField(3);
	formulaPart3 = new JLabel(")]² + (");
	e = new JTextField(3);
	formulaPart4 = new JLabel(")");

	a.setText("1");
	d.setText("0");
	e.setText("0");

	formulaPanel.add(formulaPart1);
	formulaPanel.add(a);
	formulaPanel.add(formulaPart2);
	formulaPanel.add(d);
	formulaPanel.add(formulaPart3);
	formulaPanel.add(e);
	formulaPanel.add(formulaPart4);

	this.add(formulaPanel);
    }

}
