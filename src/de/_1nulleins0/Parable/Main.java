package de._1nulleins0.Parable;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferStrategy;
import java.util.Vector;

public class Main extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private boolean running = false;
    private Thread thread;

    private Vector dataPoints;

    public static int WIDTH;
    public static int HEIGHT;

    private void init() {
	WIDTH = getWidth();
	HEIGHT = getHeight();
	dataPoints = new Vector();
    }

    public synchronized void start() {
	if (running) {
	    return;
	}

	running = true;
	thread = new Thread(this);
	thread.start();
    }

    @Override
    public void run() {
	init();
	this.requestFocus();

	while (running) {
	    update();
	    render();
	}
    }

    private void update() {
	float variableA;
	float variableD;
	float variableE;

	try {
	    variableA = Float.parseFloat(ControlPanel.a.getText());
	    variableD = Float.parseFloat(ControlPanel.d.getText());
	    variableE = Float.parseFloat(ControlPanel.e.getText());
	} catch (Exception e) {
	    variableA = 1;
	    variableD = 0;
	    variableE = 0;
	}

	float x;
	float y;

	dataPoints.clear();

	for (float i = (0 - WIDTH); i < WIDTH; i += 0.01) {
	    x = i;
	    y = (float) (variableA * Math.pow((x - variableD), 2) + variableE);
	    Point p = new Point();
	    p.setLocation(x, y);
	    dataPoints.add(p);
	}
    }

    private void render() {
	BufferStrategy bs = getBufferStrategy();

	if (bs == null) {
	    createBufferStrategy(3);
	    return;
	}

	Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

	g2d.setColor(Color.black);
	g2d.fillRect(0, 0, WIDTH, HEIGHT);
	g2d.translate(WIDTH / 2, HEIGHT / 2);
	// g2d.rotate(Math.toRadians(180)); // moep ...
	g2d.scale(1.0, -1.0); // this seems to be a better solution to flip the
			      // coords-system

	// --- coords _ start

	g2d.setStroke(new BasicStroke(1.0f));
	g2d.setPaint(Color.WHITE);

	GeneralPath xAxis = new GeneralPath();

	xAxis.moveTo(-(WIDTH / 2), 0);
	xAxis.lineTo(WIDTH / 2, 0);
	g2d.draw(xAxis);

	GeneralPath yAxis = new GeneralPath();

	yAxis.moveTo(0, WIDTH / 2);
	yAxis.lineTo(0, -(WIDTH / 2));
	g2d.draw(yAxis);

	// --- coords _ end

	// --- path _ start

	g2d.setStroke(new BasicStroke(1.0f));
	g2d.setPaint(Color.GREEN);

	GeneralPath path = new GeneralPath();

	path.moveTo(
		((Point) dataPoints.firstElement()).getX(),
		((Point) dataPoints.firstElement()).getY()
		);
	for (int i = 1; i < dataPoints.size(); i++) {
	    path.lineTo(
		    ((Point) dataPoints.elementAt(i)).getX(),
		    ((Point) dataPoints.elementAt(i)).getY()
		    );
	}
	g2d.draw(path);

	// --- path _ end

	g2d.dispose();
	bs.show();
    }

    public static void main(String[] args) {
	new Window(800, 600, "Parable", new Main());
    }

}
