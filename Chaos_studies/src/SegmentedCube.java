import java.util.ArrayList;
import processing.core.*;


public class SegmentedCube extends SegmentedBase {

	private PVector[] verts;
	private SegmentedEdge[] edges;
	private float w, h, d;

	public SegmentedCube(PApplet p, float w, float h, float d, int segs) {
		super(p, segs);
		this.w = w;
		this.h = h;
		this.d = d;
		verts = new PVector[8];
		edges = new SegmentedEdge[12];
	}

	@Override
	public void init() {

		/* 
		 
		   6-------4
		 '  '     ' ' 
		0----'---2   '
		 '    7--'----5
		  '  '    '  '
		   1-------3
		   
		   
		 */
		// vertices
		float theta = -p.PI/4;
		for(int i=0, j=0; i<4; ++i){
			// top verts
			verts[j++] = new PVector(getChaos(chaosSeed, ChaosMode.RANDOM)+p.sin(theta)*w/2+getChaos(chaosSeed, ChaosMode.RANDOM), 
					-h/2+getChaos(chaosSeed, ChaosMode.RANDOM), getChaos(chaosSeed, ChaosMode.RANDOM)+p.cos(theta)*d/2+getChaos(chaosSeed, ChaosMode.RANDOM));
			// bottom verts
			verts[j++] = new PVector(getChaos(chaosSeed, ChaosMode.RANDOM)+p.sin(theta)*w/2+getChaos(chaosSeed, ChaosMode.RANDOM), 
					h/2+getChaos(chaosSeed, ChaosMode.RANDOM), getChaos(chaosSeed, ChaosMode.RANDOM)+p.cos(theta)*d/2+getChaos(chaosSeed, ChaosMode.RANDOM));
			theta += p.TWO_PI/4;
		}

		// Edges
		// brute 
//		edges[0] = new SegmentedEdge(p, verts[0], verts[1], segs);
//		edges[1] = new SegmentedEdge(p, verts[2], verts[3], segs);
//		edges[2] = new SegmentedEdge(p, verts[4], verts[5], segs);
//		edges[3] = new SegmentedEdge(p, verts[6], verts[7], segs);
//		
//		edges[4] = new SegmentedEdge(p, verts[0], verts[2], segs);
//		edges[5] = new SegmentedEdge(p, verts[2], verts[4], segs);
//		edges[6] = new SegmentedEdge(p, verts[4], verts[6], segs);
//		edges[7] = new SegmentedEdge(p, verts[6], verts[0], segs);
//		
//		edges[8] = new SegmentedEdge(p, verts[1], verts[3], segs);
//		edges[9] = new SegmentedEdge(p, verts[3], verts[5], segs);
//		edges[10] = new SegmentedEdge(p, verts[5], verts[7], segs);
//		edges[11] = new SegmentedEdge(p, verts[7], verts[1], segs);
		
		
		 // nasty 
		int j = 0;
		for(int i=0; i<verts.length; i+=2){
			// verticals
			edges[j++] = new SegmentedEdge(p, verts[i], verts[i+1], segs);
			
			// top
			if(i==verts.length-2){
				edges[j++] = new SegmentedEdge(p, verts[i], verts[0], segs);
			} else {
				edges[j++] = new SegmentedEdge(p, verts[i], verts[i+2], segs);
			}
		}

		// bottom 
		for(int i=1; i<verts.length; i+=2){
			if(i==verts.length-1){
				edges[j++] = new SegmentedEdge(p, verts[i], verts[1], segs);
			} else {
				edges[j++] = new SegmentedEdge(p, verts[i], verts[i+2], segs);
			}
		}

		// edge chaos
		for(int i=0; i<edges.length; ++i){
			edges[i].setChaos(chaosSeed*.5f); // lazy hack
		}

	}

	@Override
	public void draw() {
		p.pushMatrix();
		p.noFill();
		for (int i=0; i<edges.length; ++i) {
			edges[i].draw();
		}
		p.popMatrix();
	}

}
