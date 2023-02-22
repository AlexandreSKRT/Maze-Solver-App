package dijkstra;

public interface VertexInterface {
	/**
	 * Return True if the two input vertices are equal.
	 * 
	 * @param VertexInterface s
	 * @return boolean
	 */
	public boolean equalsVertex(VertexInterface s);

	/**
	 * Setter. Set a new Label.
	 * 
	 * @param String s
	 * @return void
	 */
	public void setLabel(String s);

	/**
	 * Getter. Return the label of the designated vertex.
	 * 
	 * @param none
	 * @return String
	 */
	public String getLabel();

	/**
	 * Getter. Return the x attribute of the designated vertex.
	 * 
	 * @param none
	 * @return int
	 */
	public int getx();

	/**
	 * Getter. Return the y attribute of the designated vertex.
	 * 
	 * @param none
	 * @return int
	 */
	public int gety();

}
