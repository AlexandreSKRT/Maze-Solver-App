package app;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import app.panels.WindowPanel;
import maze.Maze;

public class MazeSolver extends JFrame {

	private static final long serialVersionUID = 1L;
	private final WindowPanel windowPanel;
	private final MazeSolverModel model;
	private String caseEditor; // Informs the case editor which type of case was chosen

	public MazeSolver(Maze maze) {

		// Window title
		super("Maze Solver");

		// Adding an icon
		try {
			setIconImage(ImageIO.read(new File("images/iconMaze.png")));
		} catch (final IOException e) {
			e.printStackTrace();
		}

		// Adding a model
		model = new MazeSolverModel(maze);

		// Setting default values
		caseEditor = "E";

		// Content panels
		setContentPane(windowPanel = new WindowPanel(this));

		// Window closing operations
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public MazeSolverModel getModel() {
		return this.model;
	}

	public void setEditor(String string) {
		caseEditor = string;
		windowPanel.getCaseEditorPanel().getColorIndicator().changeBackground(string);
	}

	public String getEditorStatus() {
		return caseEditor;
	}
}
