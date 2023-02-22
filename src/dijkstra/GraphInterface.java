package dijkstra;

import java.util.ArrayList;

public interface GraphInterface {
	/**
	 * return the successor of the input vertex.
	 * 
	 * @param VertexInterface s
	 * @return ArrayList/<VertexInterface/> A
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface s);

	/**
	 * return the number of vertices of the maze.
	 * 
	 * @param VertexInterface s
	 * @return ArrayList/<VertexInterface/> A
	 */
	public int getSize();

	/**
	 * return an ArrayList of all the vertices.
	 * 
	 * @param none
	 * @return int n
	 */
	public ArrayList<VertexInterface> getAllVertices();

	/**
	 * return the weight of the {src, dst} edge.
	 * 
	 * @param VertexInterface src, VertexInterface dst
	 * @return float f
	 */
	public float getWeight(VertexInterface src, VertexInterface dst);

	/**
	 * return an ArrayList of all vertices not contained in A.
	 * 
	 * @param ASetInterface A
	 * @return ArrayList/<VertexInterface/> A
	 */
	public ArrayList<VertexInterface> NotIn(ASetInterface A); // create a list of vertices not in A

	/**
	 * return the root of the maze
	 * 
	 * @param none
	 * @return VertexInterface s
	 */
	public VertexInterface getRoot();
}