import processing.core.*;


public class SegmentedEdge extends SegmentedBase{
	  PVector v0, v1;
	  PVector[] nodes;

	  public SegmentedEdge(PApplet p, PVector v0, PVector v1, int segs) {
	    super(p, segs);
	    this.v0 = v0;
	    this.v1 = v1;
	    nodes = new PVector[segs];
	    init();
	  }

	  @Override
	  public void init() {
	    PVector temp = new PVector();
	    temp.set(v1);
	    temp.sub(v0);
	    temp.div(segs-1);
	    for (int i=0; i<segs; ++i) {
	      if (i != 0 && i < segs-1){
	    	  nodes[i] = new PVector(v0.x + temp.x*i + getChaos(chaosSeed, ChaosMode.RANDOM), 
	    			  v0.y + temp.y*i + getChaos(chaosSeed, ChaosMode.RANDOM), v0.z + temp.z*i + getChaos(chaosSeed, ChaosMode.RANDOM));
	      } else if (i==0){
	    	  nodes[i] = v0;
	      } else {
	    	  nodes[i] = v1;
	      }
	    }
	  }

	  
	  @Override
	  public void draw() {
	    p.noFill();
	    p.beginShape();
	    for (int i=0; i<nodes.length; ++i) {
	      p.vertex(nodes[i].x, nodes[i].y, nodes[i].z);
	    }
	    p.endShape();
	  }
	}
