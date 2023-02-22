package dijkstra;

public interface PiInterface {
	/**
	 * Setter.
	 * 
	 * @param VertexInterface s, float x
	 * @return void
	 */
	public void setPi(VertexInterface s, float x);

	/**
	 * Getter. Return Pi(s).
	 * 
	 * @param VertexInterface s
	 * @return int
	 */
	public int getPi(VertexInterface s);

	/**
	 * Used to streamline Dijkstra's code. <br>
	 * Return the mentioned vertex in Dijkstra : assertion 1
	 * 
	 * @param ASetInterface A, GraphInterface g
	 * @return VertexInterface s
	 */
	public VertexInterface getVertexPiMin(ASetInterface A, GraphInterface g);

	/**
	 * Initialize the PiInterface with the GraphInterface g and the root r.
	 * 
	 * @param GraphInterface g, VertexInterface r
	 * @return void
	 */
	public void initPi(GraphInterface g, VertexInterface r);
}