package de._1nulleins0.Parable;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private boolean running = false;
    private Thread thread;

    private Point[] dataPoints;

    public static int WIDTH;
    public static int HEIGHT;

    private void init() {
	WIDTH = getWidth();
	HEIGHT = getHeight();
	dataPoints = new Point[9];
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
	int variableA = Integer.parseInt(ControlPanel.a.getText());
	int variableD = Integer.parseInt(ControlPanel.d.getText());
	int variableE = Integer.parseInt(ControlPanel.e.getText());

	int x;
	int y;

	for (int i = 0; i < dataPoints.length; i++) {
	    x = (int) (Math.floor(dataPoints.length / 2) - i);
	    y = (int) ((variableA * Math.pow((x - variableD), 2)) + variableE);
	    dataPoints[i] = new Point();
	    dataPoints[i].setLocation(x, y);
	    // System.out.println("x: " + dataPoints[i].getX() + " - y: " +
	    // dataPoints[i].getY());
	}
	// System.out.println(" ------- ");
    }

    private void render() {
	int pixelStep = 10; // weird .. i know ...
	BufferStrategy bs = this.getBufferStrategy();

	if (bs == null) {
	    this.createBufferStrategy(3);
	    return;
	}

	Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

	g2d.setColor(Color.black);
	g2d.fillRect(0, 0, getWidth(), getHeight());

	g2d.translate(WIDTH / 2, HEIGHT / 2);

	// --- path _ start

	g2d.setStroke(new BasicStroke(1.0f));
	g2d.setPaint(Color.GREEN);

	GeneralPath path = new GeneralPath();

	path.moveTo((int) dataPoints[0].getX() * pixelStep, (int) dataPoints[0].getY() * pixelStep);
	for (int i = 0; i < dataPoints.length; i++) {
	    path.lineTo(dataPoints[i].getX() * pixelStep, dataPoints[i].getY() * pixelStep);
	}
	g2d.draw(path);

	// --- path _ end

	g2d.dispose();
	bs.show();
    }

    public static void main(String[] args) {
	new Window(1024, 768, "Parable", new Main());
    }

}
