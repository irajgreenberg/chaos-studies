/** Sketch.java
 * A "pure Java" Processing sketch for tinkering with the Chaos. 
 * @author Ira Greenberg, Yong Bakos
 * @since 0.0.1
 */
import edu.smu.c3.chaos.*;

public class Sketch extends ChaosSketch {

	public void settings() {
		size(1024, 768, P3D);
//		fullScreen(P3D, SPAN);
	}
	
	public void setup() {
		
	}

	public void draw() {
		background(255);
		strokeWeight(50);
		point(width / 2, height / 2);
		rectMode(CENTER);
		rect(width / 2, height / 2, 1024, 768);
	}

}
