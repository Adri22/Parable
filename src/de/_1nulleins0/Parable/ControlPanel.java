package de._1nulleins0.Parable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel formularPanel;
    private JLabel formula1;
    public static JTextField a;
    private JLabel formula2;
    public static JTextField d;
    private JLabel formula3;
    public static JTextField e;

    public ControlPanel() {
	formularPanel = new JPanel();
	formula1 = new JLabel("y = ");
	a = new JTextField(3);
	formula2 = new JLabel("(x + ");
	d = new JTextField(3);
	formula3 = new JLabel(")² + ");
	e = new JTextField(3);

	a.setText("1");
	d.setText("0");
	e.setText("0");

	formularPanel.add(formula1);
	formularPanel.add(a);
	formularPanel.add(formula2);
	formularPanel.add(d);
	formularPanel.add(formula3);
	formularPanel.add(e);

	this.add(formularPanel);
    }

}
