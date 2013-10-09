import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

public class ChaosTest extends PApplet{

	private SegmentedBase r01;
	private SegmentedBase e01;
	private SegmentedBase c01;
	private SegmentedBase sf01;

	public void setup() {
		size(1024, 768, P3D);

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
		
		
		edgeSegs = 8;
		sf01 = new SegmentedFace4(this, edgeSegs, new PVector(-150, -100, -20), new PVector(150, -100, 5), new PVector(100, 120, 30), new PVector(-40, 190, -80));
		sf01.setChaos(0f);
	}

	public void draw() {
		background(255);
		
		stroke(0, 105);
		strokeWeight(.75f);
		
		pushMatrix();
		translate(width/4, height/4);
		rotateY(frameCount*PI/720);
		rotateX(-frameCount*PI/560);
		r01.draw();
		popMatrix();

		pushMatrix();
		translate(width/4, height*.675f);
		rotateY(-frameCount*PI/720);
		rotateX(frameCount*PI/560);
		e01.draw();
		popMatrix();
		
		pushMatrix();
		translate(width*.75f, height/4, -30);
		rotateY(frameCount*PI/720);
		rotateX(frameCount*PI/560);
		c01.draw();
		popMatrix();
		
		lightSpecular(255, 255, 255);
		directionalLight(50, 50, 50, 0, 0, -1);
		specular(255, 255, 255);
		
		pushMatrix();
		translate(width*.75f, height*.675f, -30);
		rotateY(frameCount*PI/400);
		rotateX(-frameCount*PI/560);
		sf01.draw();
		popMatrix();
	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "ChaosTest" });
	}

}
