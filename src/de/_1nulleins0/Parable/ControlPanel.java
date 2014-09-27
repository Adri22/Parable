package de._1nulleins0.Parable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {

    // JButton applyButton;
    private JPanel formularPanel;
    private JLabel formula1;
    public static JTextField a;
    private JLabel formula2;
    public static JTextField d;
    private JLabel formula3;
    public static JTextField e;

    public ControlPanel() {
	// applyButton = new JButton("apply");
	formularPanel = new JPanel();
	formula1 = new JLabel("y = ");
	a = new JTextField(2);
	formula2 = new JLabel("(x - ");
	d = new JTextField(2);
	formula3 = new JLabel(") + ");
	e = new JTextField(2);

	a.setText("1");
	d.setText("0");
	e.setText("0");

	// this.add(applyButton);
	formularPanel.add(formula1);
	formularPanel.add(a);
	formularPanel.add(formula2);
	formularPanel.add(d);
	formularPanel.add(formula3);
	formularPanel.add(e);

	this.add(formularPanel);
    }

}
