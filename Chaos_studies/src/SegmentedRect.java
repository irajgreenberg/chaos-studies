import java.util.ArrayList;
import processing.core.*;


public class SegmentedRect extends SegmentedBase {

	private ArrayList<PVector> verts;
	private ArrayList<SegmentedEdge> edges;
	private float w, h;
	private int rectSegs;

	public SegmentedRect(PApplet p, float w, float h, int segs, int rectSegs) {
		super(p, segs);
		this.w = w;
		this.h = h;
		this.rectSegs = rectSegs;
		init();
	}

	@Override
	public void init() {
		verts = new ArrayList<PVector>();
		edges = new ArrayList<SegmentedEdge>();
		
		// vertices
		float rectSegW = w/(rectSegs+1);
		for(int i=0; i<rectSegs+2; i++){
			verts.add(new PVector(-w/2 + getChaos(chaosSeed, ChaosMode.RANDOM)*2 + rectSegW*i + 
					getChaos(chaosSeed, ChaosMode.RANDOM), -h/2+ getChaos(chaosSeed, ChaosMode.RANDOM) + getChaos(chaosSeed, ChaosMode.RANDOM)));
			verts.add(new PVector(-w/2 + getChaos(chaosSeed, ChaosMode.RANDOM)*2 + rectSegW*i + 
					getChaos(chaosSeed, ChaosMode.RANDOM), h/2+ getChaos(chaosSeed, ChaosMode.RANDOM) + getChaos(chaosSeed, ChaosMode.RANDOM)));
		}

		// vertical bars
		for(int i=0; i<verts.size(); i+=2){
			edges.add(new SegmentedEdge(p, verts.get(i), verts.get(i+1), segs));
		}

		// perimeter
		for(int i=0; i<rectSegs*2+1; i+=2){
			edges.add(new SegmentedEdge(p, verts.get(i), verts.get(i+2), segs/2));
			edges.add(new SegmentedEdge(p, verts.get(i+1), verts.get(i+3), segs/2));
		}

		// edge chaos
		for(int i=0; i<edges.size(); ++i){
			edges.get(i).setChaos(chaosSeed*.5f); // lazy hack
		}
	}

	@Override
	public void draw() {
		p.pushMatrix();
		p.noFill();
		for (int i=0; i<edges.size(); ++i) {
			edges.get(i).draw();
		}
		p.popMatrix();
	}

}
