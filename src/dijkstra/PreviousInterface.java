package dijkstra;

public interface PreviousInterface {
	/**
	 * Setter. Add a VertexInterface and its previous to the HashTable.
	 * 
	 * @param VertexInterface p, VertexInterface f
	 * @return void
	 */
	public void addPrevious(VertexInterface p, VertexInterface f);

	/**
	 * Getter. Return Previous(p).
	 * 
	 * @param VertexInterface p
	 * @return VertexInterface s
	 */
	public VertexInterface getPrevious(VertexInterface p);
}
