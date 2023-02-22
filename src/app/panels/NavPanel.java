package app.panels;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import app.MazeSolver;
import app.buttons.nav.FileButton;
import app.buttons.nav.NewMazeButton;
import app.buttons.nav.SaveButton;
import app.buttons.nav.SolveButton;

@SuppressWarnings("serial")
public class NavPanel extends JPanel {

	private final SolveButton solveButton;
	private final FileButton fileButton;
	private final NewMazeButton newMazeButton;
	private final SaveButton saveButton;

	public NavPanel(MazeSolver mazeSolver) {
		setLayout(new GridLayout(1, 4));
		add(solveButton = new SolveButton(mazeSolver));
		add(fileButton = new FileButton(mazeSolver));
		add(saveButton = new SaveButton(mazeSolver));
		add(newMazeButton = new NewMazeButton(mazeSolver));

		// Styling
		setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
	}

}
