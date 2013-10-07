import java.util.ArrayList;

import processing.core.*;


public class SegmentedFace4 extends SegmentedBase {
	
	PVector v0, v1, v2, v3;
	ArrayList<PVector> verts;
	ArrayList<SegmentedEdge> edges;
	ArrayList<Face4> faces;
	

	public SegmentedFace4(PApplet p, int segs, PVector v0, PVector v1, PVector v2,  PVector v3) {
		super(p, segs);
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	
	public SegmentedFace4(PApplet p, int segs, PVector[] pts) {
		super(p, segs);
		this.v0 = pts[0];
		this.v1 = pts[1];
		this.v2 = pts[2];
		this.v3 = pts[3];
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

}
