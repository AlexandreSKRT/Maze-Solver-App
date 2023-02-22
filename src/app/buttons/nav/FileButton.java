package app.buttons.nav;

import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;

import app.MazeSolver;
import maze.MazeReadingException;

@SuppressWarnings("serial")
public class FileButton extends NavButtons {

	public FileButton(MazeSolver mazeSolver) {
		super(mazeSolver, "File");
	}

	/**
	 * When the button is pressed: a new JFileChooser is created. The user can <br>
	 * then navigate through its files to choose a text file representing a <br>
	 * mazes. Eventually this text file is opened with the method openFile from <br>
	 * the MazeSolverModel class.
	 * 
	 * @param MouseEvent e
	 * @return void
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			try {
				this.getMazeSolver().getModel().openFile(selectedFile.getAbsolutePath());
			} catch (MazeReadingException e1) {
				e1.printStackTrace();
			}
		}
	}
}
