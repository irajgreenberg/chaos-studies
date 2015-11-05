/** Chaotic.java
 * The main abstraction of chaos generation, encapsulating things
 * like number smudging.
 * @author Yong Bakos
 * @since 0.0.1
 */
package edu.smu.c3.chaos;

import java.util.concurrent.ThreadLocalRandom;

public class Chaotic {
	
	// Coefficients
	public final float C_DIMENSION = 0.15f;
	
	private ThreadLocalRandom r = ThreadLocalRandom.current();
	
	public int width(int original) {
		return r.nextInt((int)(original * (1 - C_DIMENSION)),
						 (int)(original * (1 + C_DIMENSION)));
	}
	
	public int height(int original) {
		return r.nextInt((int)(original * (1 - C_DIMENSION)),
						 (int)(original * (1 + C_DIMENSION)));
	}
	
}