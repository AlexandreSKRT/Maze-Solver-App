package app.buttons.nav;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.MazeSolver;

@SuppressWarnings("serial")
public class NewMazeButton extends NavButtons implements ActionListener {

	public NewMazeButton(MazeSolver mazeSolver) {
		super(mazeSolver, "New Maze");
	}

	/**
	 * Creates two JOptionPane. The user must enter two values : both <br>
	 * integers. Those will be used as the height and length of a new maze. If <br>
	 * both inputs are valid: the method createEmptyMaze from the <br>
	 * MazeSolverModel class is used.
	 * 
	 * @param ActionEvent e
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String height = JOptionPane.showInputDialog(getMazeSolver(), "height:");
		String length = JOptionPane.showInputDialog(getMazeSolver(), "length:");
		try {
			int n = Integer.parseInt(height);
			int m = Integer.parseInt(length);

			if (n > 10 || m > 10) {
				JOptionPane.showMessageDialog(null,
						"Maze dimensions are high, you might want to readjust the size of the app window", "Maze Error",
						JOptionPane.INFORMATION_MESSAGE);
			}

			getMazeSolver().getModel().createEmptyMaze(n, m);
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Invalid input, integers were expected", "Maze Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
