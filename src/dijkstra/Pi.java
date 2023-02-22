
package dijkstra;

import java.util.Hashtable;

@SuppressWarnings({ "serial", "rawtypes" })
public class Pi extends Hashtable implements PiInterface {

	@SuppressWarnings("unchecked")
	@Override
	public void setPi(VertexInterface s, float x) {
		super.put(s, (int) x);
	}

	@Override
	public int getPi(VertexInterface s) {
		int a = (int) super.get(s);
		return a;
	}

	@Override
	public VertexInterface getVertexPiMin(ASetInterface a, GraphInterface g) {
		VertexInterface y = null;
		int minPi = Integer.MAX_VALUE;
		for (VertexInterface v : g.NotIn(a)) {
			if (this.getPi(v) <= minPi) {
				minPi = this.getPi(v);
				y = v;
			}
		}
		return y;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initPi(GraphInterface g, VertexInterface r) {
		for (VertexInterface v : g.getAllVertices()) {
			if (!v.equals(r)) {
				this.put(v, Integer.MAX_VALUE - 100);
			}
		}
		this.put(r, 0);
	}

}
