/** SegmentedEllipse.java
 * TODO
 * @author Ira Greenberg
 * @since 0.0.0
 */
import java.util.ArrayList;
import processing.core.*;

public class SegmentedEllipse extends SegmentedBase {

	private ArrayList<PVector> verts;
	private ArrayList<SegmentedEdge> edges;
	private float radiusX, radiusY;
	private int ellipseSegs;
	
	public SegmentedEllipse(PApplet p, float radiusX, float radiusY, int segs, int ellipseSegs) {
		super(p, segs);
		this.radiusX = radiusX;
		this.radiusY = radiusY;
		this.ellipseSegs = ellipseSegs;
		init();
	}

	@Override
	public void init() {
		verts = new ArrayList<PVector>();
		edges = new ArrayList<SegmentedEdge>();
		
		// vertices
		float theta = 0.0f;
		for (int i = 0; i < ellipseSegs; ++i) {
			float x = p.cos(theta)*radiusX + getChaos(chaosSeed, ChaosMode.RANDOM);
			float y = p.sin(theta)*radiusY + getChaos(chaosSeed, ChaosMode.RANDOM);
			verts.add(new PVector(x, y));
			theta += p.TWO_PI/ellipseSegs;
		}

		// internal divisions
		for (int i = 0; i < verts.size(); ++i) {
			edges.add(new SegmentedEdge(p, new PVector(0, 0), verts.get(i), segs));
		}
		
		// perimeter
		for (int i = 0; i < verts.size(); ++i) {
			if (i < verts.size()-1) {
				edges.add(new SegmentedEdge(p, verts.get(i), verts.get(i+1), segs/2));
			} else {
				edges.add(new SegmentedEdge(p, verts.get(i), verts.get(0), segs/2));
			}
		}

		// edge chaos
		for (int i = 0; i < edges.size(); ++i) {
			edges.get(i).setChaos(chaosSeed*.5f); // lazy hack
		}
	}

	@Override
	public void draw() {
		//p.pushMatrix();
		p.noFill();
		for (int i = 0; i < edges.size(); ++i) {
			edges.get(i).draw();
		}
		//p.popMatrix();
	}

}
