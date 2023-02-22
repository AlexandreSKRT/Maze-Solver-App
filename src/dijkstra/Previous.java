package dijkstra;

import java.util.Hashtable;

@SuppressWarnings({ "rawtypes", "serial" })
public class Previous extends Hashtable implements PreviousInterface {

	@SuppressWarnings("unchecked")
	@Override
	public void addPrevious(VertexInterface y, VertexInterface p) {
		super.put(y, p);
	}

	@Override
	public VertexInterface getPrevious(VertexInterface s) {
		return (VertexInterface) super.get(s);
	}
}
