import processing.core.*;

public class ChaosTest extends PApplet{

	private SegmentedBase r01;
	private SegmentedBase e01;

	public void setup() {
		size(1024, 768);
		stroke(0, 105);
		strokeWeight(.75f);
		
		// rect
		float w = 550; float h = 150;
		int edgeSegs = 10; int rectSegs = 20;
		r01 = new SegmentedRect(this, w, h, edgeSegs, rectSegs);
		r01.setChaos(2.6f);
		
		// ellipse
		w = 150; h = 150;
		edgeSegs = 20; int ellipseSegs = 30;
		e01 = new SegmentedEllipse(this, w, h, edgeSegs, ellipseSegs);
		e01.setChaos(3.6f);
	}

	public void draw() {
		background(255);
		pushMatrix();
		translate(width/2, height/4);
		r01.draw();
		popMatrix();
		
		pushMatrix();
		translate(width/2, height*.675f);
		e01.draw();
		popMatrix();
	}
	
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "ChaosTest" });
	  }

}
