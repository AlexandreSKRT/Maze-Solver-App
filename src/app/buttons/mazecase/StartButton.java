package app.buttons.mazecase;

import app.MazeSolver;
import app.buttons.Colors;

@SuppressWarnings("serial")
public class StartButton extends MazeCase {

	public StartButton(MazeSolver mazeSolver, int x, int y) {
		super(mazeSolver, x, y);
		setBackground(Colors.start);
	}

}
