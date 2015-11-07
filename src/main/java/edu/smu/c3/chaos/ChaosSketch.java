/** ChaosSketch.java
 * A base class that hijacks (overrides) PApplet behavior.
 * Users of Chaos should extend this class instead of PApplet.
 * @author Yong Bakos
 * @since 0.0.1
 */
package edu.smu.c3.chaos;

import processing.core.*;
import java.util.concurrent.ThreadLocalRandom;

public class ChaosSketch extends PApplet {
	
	// TODO Replace with number generator. Issue #1.
	static final int COLOR_FUCK_FACTOR = 10;
	static final int STROKE_FUCK_FACTOR = 4;
	static final int COORDINATE_FUCK_FACTOR = 50;
	
	private ThreadLocalRandom r = ThreadLocalRandom.current();
	
	private Chaotic chaotic = new Chaotic(this);
	
	@Override
	public void size(int width, int height) {
		super.size(chaotic.width(width), chaotic.height(height));
	}
	
	@Override
	public void size(int width, int height, String renderer) {
		super.size(chaotic.width(width), chaotic.height(height), renderer);
	}
	
	/* Drawing methods */
	
	@Override
	public void background(int rgb) {
		super.background(rgb + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR));
	}
	
	@Override
	public void background(int rgb, float alpha) {
		super.background(rgb + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR),
						 alpha + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR));
	}
	
	@Override
    public void background(float gray) {
    	super.background(gray + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR));
	}

	@Override
    public void background(float gray, float alpha) {
		super.background(gray + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR),
						 alpha + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR));
	}

	@Override
    public void background(float v1, float v2, float v3) {
    	super.background(v1 + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR),
    					 v2 + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR),
    					 v3 + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR));
	}

	@Override
    public void background(float v1, float v2, float v3, float alpha) {
		super.background(v1 + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR),
						 v2 + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR),
						 v3 + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR),
						 alpha + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR));
	}
    
	@Override
    public void background(PImage image) {
    	// TODO Glitch out the PImage. Issue #2.
    	super.background(image);
	}
	
	@Override
	public void strokeWeight(float weight) {
		super.strokeWeight(weight + r.nextInt(-STROKE_FUCK_FACTOR, STROKE_FUCK_FACTOR));
	}
	
	@Override
	public void point(float x, float y) {
		super.point(x + r.nextInt(-COORDINATE_FUCK_FACTOR, COORDINATE_FUCK_FACTOR),
					y + r.nextInt(-COORDINATE_FUCK_FACTOR, COORDINATE_FUCK_FACTOR));
	}

	@Override
	public void point(float x, float y, float z) {
		super.point(x + r.nextInt(-COORDINATE_FUCK_FACTOR, COORDINATE_FUCK_FACTOR),
					y + r.nextInt(-COORDINATE_FUCK_FACTOR, COORDINATE_FUCK_FACTOR),
					z + + r.nextInt(-COORDINATE_FUCK_FACTOR, COORDINATE_FUCK_FACTOR));
	}
	
}
