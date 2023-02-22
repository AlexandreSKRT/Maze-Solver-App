package dijkstra;

public interface ASetInterface {
	/**
	 * Adds a vertex in the Aset
	 * 
	 * @param VertexInterface s
	 * @return void
	 */
	public void addVertex(VertexInterface s);

	/**
	 * Checks if the Aset contains the input vertex. Returns a boolean.
	 * 
	 * @param VertexInterface s
	 * @return boolean
	 */
	public boolean inASet(VertexInterface s); // check if A contains s
}
