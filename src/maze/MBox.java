
package maze;

import dijkstra.VertexInterface;

public class MBox implements VertexInterface {

	private final int x;
	private final int y;
	private String label; // Indicates the nature of the case

	public MBox(int x0, int y0, String label0) {
		this.x = x0;
		this.y = y0;
		this.label = label0;
	}

	@Override
	public boolean equalsVertex(VertexInterface s) {
		return (this.label == s.getLabel());
	}

	@Override
	public int getx() {
		return this.x;
	}

	@Override
	public int gety() {
		return this.y;
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public void setLabel(String s) {
		this.label = s;

	}

}
