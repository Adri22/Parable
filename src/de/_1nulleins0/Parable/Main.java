package de._1nulleins0.Parable;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private boolean running = false;
    private Thread thread;

    public static int WIDTH;
    public static int HEIGHT;

    private void init() {
	WIDTH = getWidth();
	HEIGHT = getHeight();
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

    }

    private void render() {
	BufferStrategy bs = this.getBufferStrategy();

	if (bs == null) {
	    this.createBufferStrategy(3);
	    return;
	}

	Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

	g2d.setColor(Color.black);
	g2d.fillRect(0, 0, getWidth(), getHeight());

	// render stuff here

	// --- path testing
	
        g2d.setStroke(new BasicStroke(4.0f));
        g2d.setPaint(Color.GREEN);
 
        int[] xPoints = {10, 50, 100, 150, 200, 250, 300, 350};
        int[] yPoints = {10, 50,  10,  50,  10,  50,  10,  50};
        GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                xPoints.length);
 
        //
        // Adds point to the path by moving to the specified
        // coordinates.
        //
        path.moveTo(xPoints[0], yPoints[0]);
        for (int i = 1; i < xPoints.length; i++) {
            //
            // Adds a point to the path by drawing a straight
            // line from the current position to the specified
            // coordinates.
            //
            path.lineTo(xPoints[i], yPoints[i]);
        }
        path.curveTo(150, 150, 300, 300, 50, 250);
        path.closePath();
        g2d.draw(path);
 
        //
        // Draw another path, a start
        //
        g2d.setPaint(Color.RED);
        g2d.setStroke(new BasicStroke(2.0f));
        path = new GeneralPath(GeneralPath.WIND_NON_ZERO);
        path.moveTo(200, 50);
        path.lineTo(270, 300);
        path.lineTo(100, 120);
        path.lineTo(300, 120);
        path.lineTo(130, 300);
        path.closePath();
        g2d.draw(path);
	
	// --- path testing _ end
	
	g2d.dispose();
	bs.show();
    }

    public static void main(String[] args) {
	new Window(1024, 768, "Parable", new Main());
    }

}
