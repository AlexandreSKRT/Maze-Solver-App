package app.buttons.mazecase;

import app.MazeSolver;
import app.buttons.Colors;

@SuppressWarnings("serial")
public class EmptyButton extends MazeCase {

	public EmptyButton(MazeSolver mazeSolver, int x, int y) {
		super(mazeSolver, x, y);
		setBackground(Colors.empty);
	}

}
