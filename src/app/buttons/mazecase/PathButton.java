package app.buttons.mazecase;

import app.MazeSolver;
import app.buttons.Colors;

@SuppressWarnings("serial")
public class PathButton extends MazeCase {

	public PathButton(MazeSolver mazeSolver, int x, int y) {
		super(mazeSolver, x, y);
		setBackground(Colors.path);
	}

}
