import java.util.ArrayList;
import processing.core.*;


public class SegmentedFace4 extends SegmentedBase {

	PVector v0, v1, v2, v3;
	PVector[][] verts;
	ArrayList<SegmentedEdge> edges;
	ArrayList<Face3> faces;


	public SegmentedFace4(){}

	// Requirement: points passed in CCW order only
	/*
	 0--3
	 |  |
	 1--2
	 */ 
	// Note: if doing "for real" test for this
	public SegmentedFace4(PApplet p, int segs, PVector v0, PVector v1, PVector v2,  PVector v3) {
		super(p, segs);
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		init();
	}

	// Requirement: points passed in CCW order only
	/*
	 0--3
	 |  |
	 1--2
	 */ 
	// Note: if doing "for real" test for this
	public SegmentedFace4(PApplet p, int segs, PVector[] pts) {
		super(p, segs);
		this.v0 = pts[0];
		this.v1 = pts[1];
		this.v2 = pts[2];
		this.v3 = pts[3];
		init();
	}

	@Override
	public void init() {
		int edgeCount = segs+2;
		verts = new PVector[edgeCount][edgeCount];
		edges = new ArrayList<SegmentedEdge>();
		faces = new ArrayList<Face3>();

		int totalVerts = 4 + segs*segs + segs*4;
		int cols = segs + 1;

		/*
		 0--3
		 |  |
		 1--2
		 */ 
		// bilinear interpolation of face vertices
		PVector[] lftEdgeVerts = new PVector[edgeCount];
		PVector[] rtEdgeVerts = new PVector[edgeCount];


		// calc left and right edge verts
		PVector lftEdgeDelta = new PVector((v1.x-v0.x)/cols, (v1.y-v0.y)/cols, (v1.z-v0.z)/cols);
		PVector rtEdgeDelta = new PVector((v2.x-v3.x)/cols, (v2.y-v3.y)/cols, (v2.z-v3.z)/cols);

		for(int i=0; i<edgeCount; ++i){
			lftEdgeVerts[i] = new PVector(v0.x + lftEdgeDelta.x*i, v0.y + lftEdgeDelta.y*i, v0.z + lftEdgeDelta.z*i);
			rtEdgeVerts[i] = new PVector(v3.x + rtEdgeDelta.x*i, v3.y + rtEdgeDelta.y*i, v3.z + rtEdgeDelta.z*i);
		}

		// interpolate between edges
		for(int i=0; i<edgeCount; ++i){
			// calc delta for each row since no guarantee of orthogonality
			PVector dynamicXDelta = new PVector((rtEdgeVerts[i].x-lftEdgeVerts[i].x)/cols, (rtEdgeVerts[i].y-lftEdgeVerts[i].y)/cols, (rtEdgeVerts[i].z-lftEdgeVerts[i].z)/cols);
			for(int j=0; j<edgeCount; ++j){
				verts[i][j] = new PVector(lftEdgeVerts[i].x + dynamicXDelta.x*j + getChaos(chaosSeed, ChaosMode.RANDOM), lftEdgeVerts[i].y + dynamicXDelta.y*j + getChaos(chaosSeed, ChaosMode.RANDOM), lftEdgeVerts[i].z + dynamicXDelta.z*j + getChaos(chaosSeed, ChaosMode.RANDOM));
			}
		}

		// create faces from vertices, winding CCW
		for(int i=0; i<edgeCount-1; ++i){
			for(int j=0; j<edgeCount-1; ++j){
				faces.add(new Face3(verts[i][j], verts[i+1][j], verts[i+1][j+1]));
				faces.add(new Face3(verts[i][j], verts[i+1][j+1], verts[i][j+1]));
			}
		}
		
	}

	@Override
	public void draw() {
		p.noStroke();
		p.fill(200, 45, 120);
		p.beginShape(p.TRIANGLES);
		for(int i=0; i<faces.size(); ++i){
			p.vertex(faces.get(i).getV0().x, faces.get(i).getV0().y, faces.get(i).getV0().z);
			p.vertex(faces.get(i).getV1().x, faces.get(i).getV1().y, faces.get(i).getV1().z);
			p.vertex(faces.get(i).getV2().x, faces.get(i).getV2().y, faces.get(i).getV2().z);
		}
		p.endShape();
		p.noFill();
	}

	public void drawVertices() {
		p.noFill();
		p.strokeWeight(4);
		p.beginShape(p.POINTS);
		for(int i=0; i<verts.length; ++i){
			for(int j=0; j<verts[i].length; ++j){
				p.vertex(verts[i][j].x, verts[i][j].y, verts[i][j].z);
			}
		}
		p.endShape();
		p.strokeWeight(1);

	}

}
