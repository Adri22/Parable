package de._1nulleins0.Parable;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	Graphics g = bs.getDrawGraphics();
	Graphics2D g2d = (Graphics2D) g;

	g.setColor(Color.black);
	g.fillRect(0, 0, getWidth(), getHeight());

	// render stuff here

	g.dispose();
	bs.show();
    }

    public static void main(String[] args) {
	new Window(1024, 768, "Parable", new Main());
    }

}
