package app.buttons.mazecase;

import app.MazeSolver;
import app.buttons.Colors;

@SuppressWarnings("serial")
public class WallButton extends MazeCase {

	public WallButton(MazeSolver mazeSolver, int x, int y) {
		super(mazeSolver, x, y);
		setBackground(Colors.wall);
	}

}
