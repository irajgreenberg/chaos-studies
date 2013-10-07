import processing.core.*;


abstract class SegmentedBase {

	protected PApplet p;
	protected int segs;
	float chaosSeed = .6f;

	abstract public void init();
	abstract public void draw();

	enum ChaosMode {
		RANDOM, QUADRATIC, CUBIC, PERLIN
	};

	public SegmentedBase(){}
			
	public SegmentedBase(PApplet p, int segs){
		this.p = p;
		this.segs = segs;
	}

	public void setChaos(float chaosSeed) {
		this.chaosSeed = chaosSeed;
		init();
	}

	float getChaos(float seed, ChaosMode mode) {
		float chaos = 0;
		switch(mode) {
		case RANDOM:
			chaos = p.random(-chaosSeed, chaosSeed);
			break;
		} // add more chaos modes eventually

		return chaos;
	}
}
