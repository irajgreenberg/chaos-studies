import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

public class ChaosTest extends PApplet{

	private SegmentedBase r01;
	private SegmentedBase e01;
	private SegmentedBase c01;

	public void setup() {
		size(1024, 768, P3D);
		stroke(0, 105);
		strokeWeight(.75f);

		// rect
		float w = 350; float h = 100;
		int edgeSegs = 10; int rectSegs = 20;
		r01 = new SegmentedRect(this, w, h, edgeSegs, rectSegs);
		r01.setChaos(2.6f);

		// ellipse
		w = 150; h = 150;
		edgeSegs = 20; int ellipseSegs = 30;
		e01 = new SegmentedEllipse(this, w, h, edgeSegs, ellipseSegs);
		e01.setChaos(3.6f);

		// cube
		w = 200; h = 200; float d = 200;
		edgeSegs = 15;
		c01 = new SegmentedCube(this, w, h, d, edgeSegs);
		c01.setChaos(2.75f);
	}

	public void draw() {
		background(255);
		pushMatrix();
		translate(width/4, height/4);
		r01.draw();
		popMatrix();

		pushMatrix();
		translate(width/4, height*.675f);
		e01.draw();
		popMatrix();
		
		pushMatrix();
		translate(width*.75f, height/4, -30);
		rotateY(frameCount*PI/720);
		rotateX(frameCount*PI/560);
		c01.draw();
		popMatrix();
	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "ChaosTest" });
	}

}
