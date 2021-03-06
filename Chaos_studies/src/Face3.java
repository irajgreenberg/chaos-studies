import processing.core.PVector;

public class Face3 {
	private PVector v0, v1, v2, norm;

	// cstrs
	public Face3() {
	}
	
	public Face3(PVector v0, PVector v1, PVector v2) {
		this.v0 = v0;
		this.v1 = v1;
		this.v2 = v2;
		norm = new PVector();
		calcNorm();
	}
	
	public Face3(PVector[] verts) {
		this.v0 = verts[0];
		this.v1 = verts[1];
		this.v2 = verts[2];
		norm = new PVector();
		calcNorm();
	}
	
	// calculate normalized surface normal
	private void calcNorm(){
		PVector a = new PVector();
		PVector b = new PVector();
		a.set(v2);
		b.sub(v1);
		a.sub(v0);
		b.sub(v0);
		norm.x = a.y*b.z - a.z*b.y;
		norm.y = a.z*b.x - a.x*b.z;
		norm.z = a.x*b.y - a.y*b.x;
		norm.normalize();
	}
	
	
	// getters/setters
	public PVector getV0() {
		return v0;
	}

	public void setV0(PVector v0) {
		this.v0 = v0;
	}

	public PVector getV1() {
		return v1;
	}

	public void setV1(PVector v1) {
		this.v1 = v1;
	}

	public PVector getV2() {
		return v2;
	}

	public void setV2(PVector v2) {
		this.v2 = v2;
	}

	public PVector getNorm() {
		return norm;
	}

	public void setNorm(PVector norm) {
		this.norm = norm;
	}

}
