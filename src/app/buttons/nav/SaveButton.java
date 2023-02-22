package app.buttons.nav;

import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;

import app.MazeSolver;

@SuppressWarnings("serial")
public class SaveButton extends NavButtons {

	public SaveButton(MazeSolver mazeSolver) {
		super(mazeSolver, "Save");
	}

	/**
	 * When the button is pressed: a new JFileChooser is created. The user can <br>
	 * then navigate through its files to choose a text file. The current maze <br>
	 * as displayed to the user will be saved in the chosen text file.
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
			this.getMazeSolver().getModel().saveMazeToFile(selectedFile.getAbsolutePath());
		}
	}
}
