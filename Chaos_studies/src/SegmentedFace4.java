import java.util.ArrayList;
import processing.core.*;


public class SegmentedFace4 extends SegmentedBase {

	PVector v0, v1, v2, v3;
	ArrayList<PVector> verts;
	ArrayList<SegmentedEdge> edges;
	ArrayList<Face4> faces;


	public SegmentedFace4(){}

	// Requirement: points passed in CW/CCW order only
	// Note: if doing "for real" test for this
	public SegmentedFace4(PApplet p, int segs, PVector v0, PVector v1, PVector v2,  PVector v3) {
		super(p, segs);
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	// Requirement: points passed in CW/CCW order only
	// Note: if doing "for real" test for this
	public SegmentedFace4(PApplet p, int segs, PVector[] pts) {
		super(p, segs);
		this.v0 = pts[0];
		this.v1 = pts[1];
		this.v2 = pts[2];
		this.v3 = pts[3];
	}

	@Override
	public void init() {
		verts = new ArrayList<PVector>();
		edges = new ArrayList<SegmentedEdge>();
		faces = new ArrayList<Face4>();

		int totalVerts = 4 + segs*segs + segs*4;


		// lame-ass approach, but...
		int edgeCount = segs+2;
		PVector[] topEdgeVerts = new PVector[edgeCount];
		PVector[] rtEdgeVerts = new PVector[edgeCount];
		PVector[] botEdgeVerts = new PVector[edgeCount];
		PVector[] ltEdgeVerts = new PVector[edgeCount];

		PVector topDelta = new PVector(v1.x-v0.x, v1.y-v0.y, v1.z-v0.z);
		PVector rtDelta = new PVector(v2.x-v1.x, v2.y-v1.y, v2.z-v1.z);
		PVector botDelta = new PVector(v2.x-v3.x, v2.y-v3.y, v2.z-v3.z);
		PVector ltDelta = new PVector(v3.x-v0.x, v3.y-v0.y, v3.z-v0.z);
		topDelta.div(segs+1);
		rtDelta.div(segs+1);
		botDelta.div(segs+1);
		ltDelta.div(segs+1);


		for(int i=0; i<edgeCount; i++){
			topEdgeVerts[i] = new PVector(v0.x + topDelta.x*i, v0.y + topDelta.y*i, v0.z + topDelta.z*i );
			rtEdgeVerts[i] = new PVector(v1.x + rtDelta.x*i, v1.y + rtDelta.y*i, v1.z + rtDelta.z*i );
			botEdgeVerts[i] = new PVector(v3.x + botDelta.x*i, v3.y + botDelta.y*i, v3.z + botDelta.z*i );
			ltEdgeVerts[i] = new PVector(v0.x + ltDelta.x*i, v0.y + ltDelta.y*i, v0.z + ltDelta.z*i );
		}

		for(int i=0; i<edgeCount; i++){
			for(int j=0; j<edgeCount; j++){
				verts[i] = topEdgeVerts[i] = new PVector(v0.x + topDelta.x*i, v0.y + topDelta.y*i, v0.z + topDelta.z*i );
				rtEdgeVerts[i] = new PVector(v1.x + rtDelta.x*i, v1.y + rtDelta.y*i, v1.z + rtDelta.z*i );
				botEdgeVerts[i] = new PVector(v3.x + botDelta.x*i, v3.y + botDelta.y*i, v3.z + botDelta.z*i );
				ltEdgeVerts[i] = new PVector(v0.x + ltDelta.x*i, v0.y + ltDelta.y*i, v0.z + ltDelta.z*i );
			}
		}

		// calc deltas between corner vertices based on seg count


		// calc temp axial verts
		for(int i=0; i<segs+2; ++i){ 

		}


		for(int i=0; i<segs+2; ++i){ // across
			for(int j=0; j<segs+2; ++j){ // down


				v0 + xgap*i + ygap*j
				verts.add(new PVector(v0.x + v0_v1Delta.x*i, v0.y + v0_v1Delta.y*i, v0.z + v0_v1Delta.z*i));
			}
		}

		// FIX: This should be nested
		for(int i=0; i<totalVerts; ++i){
			// first store face corners
			if(i==0) {
				verts.add(v0); // top lft
			} else if(i == segs+1){ // top rt
				verts.add(v1);
			} else if(i == totalVerts-1){ // bot rt
				verts.add(v2);
			} else if(i == totalVerts-2 - segs){ // bot lft
				verts.add(v3);
			} else { // now all the rest of the verts
				verts.add(new PVector()); // --> START HERE
			}
		}
	}


	//	public void init() {
	//	verts = new ArrayList<PVector>();
	//	edges = new ArrayList<SegmentedEdge>();
	//	faces = new ArrayList<Face4>();

	//	int totalVerts = 4 + segs*segs + segs*4;

	//	// calc deltas between corner vertices based on seg count
	//	PVector v0_v1Delta = new PVector(v1.x-v0.x, v1.y-v0.y, v1.z-v0.z);
	//	PVector v1_v2Delta = new PVector(v2.x-v1.x, v2.y-v1.y, v2.z-v1.z);
	//	PVector v2_v3Delta = new PVector(v3.x-v2.x, v3.y-v2.y, v3.z-v2.z);
	//	PVector v3_v0Delta = new PVector(v0.x-v3.x, v0.y-v3.y, v0.z-v3.z);
	//	v0_v1Delta.div(segs+1);
	//	v1_v2Delta.div(segs+1);
	//	v2_v3Delta.div(segs+1);
	//	v3_v0Delta.div(segs+1);

	//	// FIX: This should be nested
	//	for(int i=0; i<totalVerts; ++i){
	//	// first store face corners
	//	if(i==0) {
	//	verts.add(v0); // top lft
	//	} else if(i == segs+1){ // top rt
	//	verts.add(v1);
	//	} else if(i == totalVerts-1){ // bot rt
	//	verts.add(v2);
	//	} else if(i == totalVerts-2 - segs){ // bot lft
	//	verts.add(v3);
	//	} else { // now all the rest of the verts
	//	verts.add(new PVector()); // --> START HERE
	//	}
	//	}
	//	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

}
