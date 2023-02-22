package app;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dijkstra.CoordKeeper;
import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.Maze;
import maze.MazeReadingException;
import maze.WBox;

public class MazeSolverModel {

	private ArrayList<VertexInterface> mazeTab;
	private final ArrayList<ChangeListener> listeners;
	private CoordKeeper start;
	private CoordKeeper finish;
	private Maze maze;
	private boolean solved;

	public MazeSolverModel(Maze maze) {
		listeners = new ArrayList<ChangeListener>();
		updateModel(maze);
	}

	/**
	 * Recieves a link to a file. Creates a maze out of the text file. Updates the
	 * maze of the model if the maze is valid. <br>
	 * If not: throws a MazeReadingException.
	 * 
	 * @param String path
	 * @return void
	 */
	public void openFile(String path) throws MazeReadingException {
		maze = new Maze(path);
		updateModel(maze);
		notifyObserver();
	}

	/**
	 * Recieves a link to a file. Saves the model's maze to the linked text file.
	 * 
	 * @param String path
	 * @return void
	 */
	public void saveMazeToFile(String path) {
		maze.saveToTextFile(path);
	}

	private void updateModel(Maze maze) {
		mazeTab = maze.getAllVertices();
		start = new CoordKeeper(maze.getRoot().getx(), maze.getRoot().gety());
		finish = new CoordKeeper(maze.getFinish().getx(), maze.getFinish().gety());
		solved = false;
	}

	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}

	private void notifyObserver() {
		for (ChangeListener listener : listeners) {
			listener.stateChanged(new ChangeEvent(this));
		}
	}

	/**
	 * 
	 * If the maze is already solved: a message dialog will pop-up informing the
	 * user. <br>
	 * If not: a maze is created out of the mazeTab attribute and is pasted in the
	 * maze attribute. It will then be solved using Dijkstra's method.<br>
	 * Enventually the solved maze is pasted in the mazeTab so it can be displayed
	 * through the graphic interface.
	 * 
	 * @param none
	 * @return void
	 */
	public final void solveMaze() {
		if (solved) {
			JOptionPane.showMessageDialog(null, "Maze already solved, please create a new maze", "Maze Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			solved = true;
			maze = new Maze(mazeTab);
			PreviousInterface p = Dijkstra.dijkstra(maze, maze.getRoot());
			try {
				VertexInterface a = p.getPrevious(maze.getFinish());
				a.setLabel("X");
				while (p.getPrevious(a) != null) {
					a = p.getPrevious(a);
					if (a != null && a.getLabel() != "D") {
						a.setLabel("X");
					}
				}
				mazeTab = maze.getAllVertices();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Maze cannot be solved", "Maze Error", JOptionPane.WARNING_MESSAGE);
				solved = false;
			}
			notifyObserver();
		}
	}

	public Maze getMaze() {
		return maze;
	}

	public ArrayList<VertexInterface> getMazeTab() {
		return mazeTab;
	}

	/**
	 * Recieves integers specified by the user. The method creates an empty maze out
	 * of those dimensions. <br>
	 * It will also add a single start case and a single finish case. The created
	 * maze is pasted in the mazeTab attribute.
	 * 
	 * @param int height, int length
	 * @return void
	 */
	public void createEmptyMaze(int n, int m) {
		solved = false;
		mazeTab = new ArrayList<VertexInterface>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0) {
					VertexInterface temp1 = new DBox(0, 0);
					mazeTab.add(temp1);
					start.setCoord(0, 0);
				} else if (i == n - 1 && j == m - 1) {
					VertexInterface temp2 = new ABox(j, i);
					mazeTab.add(temp2);
					finish.setCoord(j, i);
				} else {
					mazeTab.add(new EBox(j, i));
				}
			}
		}
		maze = new Maze(mazeTab);
		notifyObserver();
	}

	/**
	 * Recieves both coordinates and editorStatus. The targeted maze case is
	 * replaced with a maze case corresponding to the editorStatus letter.
	 * 
	 * @param int x, int y, String editorStatus
	 * @return void
	 */
	public void setMazeTabElement(int x, int y, String editorStatus) {
		if (solved) {
			JOptionPane.showMessageDialog(null, "You cannot edit a maze already solved, please create a new maze",
					"Maze Error", JOptionPane.WARNING_MESSAGE);
		} else {
			int columnCounter = mazeTab.get(mazeTab.size() - 1).getx() + 1;
			int k = x + y * columnCounter;
			switch (editorStatus) {
			case "E":
				if ((x == finish.getX() && y == finish.getY()) || (x == start.getX() && y == start.getY())) {
					break;
				} else {
					mazeTab.set(k, new EBox(x, y));
					break;
				}
			case "D":
				if (x == finish.getX() && y == finish.getY()) {
					break;
				} else {
					mazeTab.set(start.getMazeTabCoord(columnCounter), new EBox(start.getX(), start.getY()));
					mazeTab.set(k, new DBox(x, y));
					start.setCoord(x, y);
					break;
				}
			case "A":
				if (x == start.getX() && y == start.getY()) {
					break;
				} else {
					mazeTab.set(finish.getMazeTabCoord(columnCounter), new EBox(finish.getX(), finish.getY()));
					mazeTab.set(k, new ABox(x, y));
					finish.setCoord(x, y);
					break;
				}
			case "W":
				if ((x == finish.getX() && y == finish.getY()) || (x == start.getX() && y == start.getY())) {
					break;
				} else {
					mazeTab.set(k, new WBox(x, y));
					break;
				}
			}
			notifyObserver();
		}
	}
}
