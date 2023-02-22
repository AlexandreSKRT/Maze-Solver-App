import app.MazeSolver;
import maze.Maze;
import maze.MazeReadingException;

public class Main {

	public static void main(String[] args) throws MazeReadingException {

		final Maze maze = new Maze("data/labyrinthe.txt");
		new MazeSolver(maze);
	}

}
