package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import dijkstra.ASetInterface;
import dijkstra.GraphInterface;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;

public class Maze implements GraphInterface {
	// Graph implemented with an adjacency list

	/*
	 * adjList is an Adjacency List, using K : VertexInterface v, you can easily
	 * access a linked list containing v's neighbors.
	 */
	private final HashMap<VertexInterface, LinkedList<VertexInterface>> adjList;
	/*
	 * vertice is an ArrayList containing all the vertices of the maze.
	 */
	private final ArrayList<VertexInterface> vertices;

	private VertexInterface root;
	private VertexInterface finish;
	private int lineNumber;
	private int columnNumber;

	public Maze(String fileName) throws MazeReadingException {

		this.vertices = new ArrayList<VertexInterface>();
		this.adjList = new HashMap<VertexInterface, LinkedList<VertexInterface>>();

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line = br.readLine();

			int columnCounter = 0;
			int lineCounter = 0;
			int startCounter = 0;
			int finishCounter = 0;
			this.columnNumber = line.toCharArray().length;

			while (line != null) {

				for (char c : line.toCharArray()) {
					switch (c) {
					case 'A': {
						VertexInterface EndBox = new ABox(columnCounter, lineCounter);
						this.vertices.add(EndBox);
						this.finish = EndBox;
						finishCounter += 1;
						break;
					}
					case 'D': {
						VertexInterface StartBox = new DBox(columnCounter, lineCounter);
						this.vertices.add(StartBox);
						this.root = StartBox;
						startCounter += 1;
						break;
					}
					case 'E': {
						this.vertices.add(new EBox(columnCounter, lineCounter));
						break;
					}
					case 'W': {
						this.vertices.add(new WBox(columnCounter, lineCounter));
						break;
					}
					default: {
						throw new MazeReadingException(fileName, lineCounter,
								"Character not matching any maze case structure");
					}
					}

					if (columnCounter == this.columnNumber - 1) {
						columnCounter = 0;
						lineCounter += 1;
					} else {
						columnCounter += 1;
					}
				}
				line = br.readLine();
			}
			this.lineNumber = lineCounter;

			if (startCounter != 1 || finishCounter != 1) {
				throw new MazeReadingException(fileName,
						"the input maze doesn't have the required number of start case or finish case : one of each");
			}

			// adjList construction
			for (int i = 0; i < this.getSize(); i++) {
				LinkedList<VertexInterface> value = new LinkedList<VertexInterface>();
				if (i - this.columnNumber >= 0) {
					if (this.vertices.get(i - this.columnNumber).getLabel() != "W") {
						value.add(this.vertices.get(i - this.columnNumber));
					}
				}
				if (i + this.columnNumber < this.getSize()) {
					if (this.vertices.get(i + this.columnNumber).getLabel() != "W") {
						value.add(this.vertices.get(i + this.columnNumber));
					}
				}
				if (i % this.columnNumber != 0) {
					if (this.vertices.get(i - 1).getLabel() != "W") {
						value.add(this.vertices.get(i - 1));
					}
				}
				if ((i + 1) % this.columnNumber != 0) {
					if (this.vertices.get(i + 1).getLabel() != "W") {
						value.add(this.vertices.get(i + 1));
					}
				}
				// add value & associated key to adjList
				adjList.put(this.vertices.get(i), value);
			}
			System.out.println("///////////////////// WELCOME /////////////////////");
		}

		catch (FileNotFoundException e) {
			System.out.println(fileName + "path isn't valid. File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error Input Output");
			e.printStackTrace();
		}

		finally {
			try {
				fr.close();
				br.close();
			} catch (Exception e) {
			}
		}
	}

	public Maze(ArrayList<VertexInterface> mazeTab) {
		this.adjList = new HashMap<VertexInterface, LinkedList<VertexInterface>>();
		vertices = mazeTab;
		columnNumber = mazeTab.get(mazeTab.size() - 1).getx() + 1;
		lineNumber = mazeTab.get(mazeTab.size() - 1).gety() + 1;

		// Locate Root and Finish
		for (int i = 0; i < mazeTab.size(); i++) {
			switch (vertices.get(i).getLabel()) {
			case "D": {
				root = vertices.get(i);
				break;
			}
			case "A": {
				finish = vertices.get(i);
				break;
			}
			default:
			}
		}

		// adjList construction
		for (int i = 0; i < this.getSize(); i++) {
			LinkedList<VertexInterface> value = new LinkedList<VertexInterface>();
			// add vertices to value
			if (i - this.columnNumber >= 0) {
				if (this.vertices.get(i - this.columnNumber).getLabel() != "W") {
					value.add(this.vertices.get(i - this.columnNumber));
				}
			}
			if (i + this.columnNumber < this.getSize()) {
				if (this.vertices.get(i + this.columnNumber).getLabel() != "W") {
					value.add(this.vertices.get(i + this.columnNumber));
				}
			}
			if (i % this.columnNumber != 0) {
				if (this.vertices.get(i - 1).getLabel() != "W") {
					value.add(this.vertices.get(i - 1));
				}
			}
			if ((i + 1) % this.columnNumber != 0) {
				if (this.vertices.get(i + 1).getLabel() != "W") {
					value.add(this.vertices.get(i + 1));
				}
			}
			adjList.put(this.vertices.get(i), value);

		}
	}

	/**
	 * Change the label of the path vertex to an "X". The new maze is then solved
	 * <br>
	 * in a specific text file.
	 * 
	 * @param PreviousInterface p
	 * @return void
	 */
	public void dijkstraTest(PreviousInterface p) {
		try {
			VertexInterface a = p.getPrevious(this.finish);
			a.setLabel("X");
			while (p.getPrevious(a) != null) {
				a = p.getPrevious(a);
				if (a != null && a.getLabel() != "D") {
					a.setLabel("X");
				}
			}
			this.saveToTextFile("data/labyrintheSolved.txt");
		} catch (NullPointerException e) {
			System.out.println("maze cannnot be solved");
		}

	}

	/**
	 * Save the maze in the input file.
	 * 
	 * @param String fileName
	 * @return void
	 */
	public final void saveToTextFile(String fileName) {

		// print into a new text file : fileName.txt
		PrintWriter pw = null;
		int counter = 0;
		try {
			pw = new PrintWriter(fileName);
			String line = "";
			for (VertexInterface v : this.vertices) {
				line = line + v.getLabel();
				counter += 1;
				if (counter % this.columnNumber == 0) {
					pw.println(line);
					line = new String();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public ArrayList<VertexInterface> getSuccessors(VertexInterface s) {
		ArrayList<VertexInterface> Successors = new ArrayList<VertexInterface>();
		Successors.addAll(this.adjList.get(s));
		return Successors;
	}

	@Override
	public ArrayList<VertexInterface> getAllVertices() {
		return this.vertices;
	}

	@Override
	public int getSize() {
		return this.columnNumber * lineNumber;
	}

	public VertexInterface getFinish() {
		return this.finish;
	}

	@Override
	public float getWeight(VertexInterface src, VertexInterface dst) {
		// for a maze, arcs are not weighted {=1}
		return 1;
	}

	/**
	 * Read the input text file line by line.
	 * 
	 * @param fileName
	 * @return void
	 */
	public final void initFromTextFile(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String ligne = br.readLine();

			while (ligne != null) {
				System.out.println(ligne);
				ligne = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "path isn't valid. File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error Input-Output");
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public ArrayList<VertexInterface> NotIn(ASetInterface A) {
		ArrayList<VertexInterface> liste = new ArrayList<VertexInterface>();
		for (VertexInterface v : this.getAllVertices()) {
			if (!A.inASet(v)) {
				liste.add(v);
			}
		}
		return liste;
	}

	@Override
	public VertexInterface getRoot() {
		return this.root;
	}

}
