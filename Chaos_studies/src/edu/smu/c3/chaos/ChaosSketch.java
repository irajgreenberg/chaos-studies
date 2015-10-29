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
	
	static final int DIMENSION_FUCK_FACTOR = 200;
	static final int COLOR_FUCK_FACTOR = 2;
	
	private ThreadLocalRandom r = ThreadLocalRandom.current();
	
	@Override
	public void size(int width, int height) {
		super.size(width + r.nextInt(-DIMENSION_FUCK_FACTOR, DIMENSION_FUCK_FACTOR),
				height + r.nextInt(-DIMENSION_FUCK_FACTOR, DIMENSION_FUCK_FACTOR));
	}
	
	@Override
	public void size(int width, int height, String renderer) {
		super.size(width + r.nextInt(-DIMENSION_FUCK_FACTOR, DIMENSION_FUCK_FACTOR),
				height + r.nextInt(-DIMENSION_FUCK_FACTOR, DIMENSION_FUCK_FACTOR),
				renderer);
	}
	
	/* Drawing methods */
	
	@Override
	public void background(int rgb) {
		super.background(rgb + r.nextInt(-COLOR_FUCK_FACTOR, COLOR_FUCK_FACTOR));
	}
	
	@Override
	public void background(int rgb, float alpha) {
		super.background(rgb, alpha);
	}

    public void background(float gray) {
    	super.background(gray);
	}

    public void background(float gray, float alpha) {
		super.background(gray, alpha);
	}

    public void background(float v1, float v2, float v3) {
    	super.background(v1, v2, v3);
	}

    public void background(float v1, float v2, float v3, float alpha) {
		super.background(v1, v2, v3, alpha);
	}
    
    public void background(PImage image) {
    	super.background(image);
	}
	
}
