package app.buttons.mazecase;

import app.MazeSolver;
import app.buttons.Colors;

@SuppressWarnings("serial")
public class FinishButton extends MazeCase {

	public FinishButton(MazeSolver mazeSolver, int x, int y) {
		super(mazeSolver, x, y);
		setBackground(Colors.finish);
	}

}
