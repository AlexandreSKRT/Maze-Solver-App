package dijkstra;

import java.util.HashSet;

@SuppressWarnings("serial")
public class Aset extends HashSet<VertexInterface> implements ASetInterface {

	@Override
	public void addVertex(VertexInterface s) {
		this.add(s);
	}

	public void initAset(VertexInterface r) {
		this.addVertex(r);
	}

	@Override
	public boolean inASet(VertexInterface s) {
		return this.contains(s);
	}
}
