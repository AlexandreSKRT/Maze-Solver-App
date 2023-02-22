package app.buttons.mazecase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import app.MazeSolver;

@SuppressWarnings("serial")
public abstract class MazeCase extends JButton implements ActionListener {
	private final MazeSolver mazeSolver;
	private final int x;
	private final int y;

	public MazeCase(MazeSolver mazeSolver, int x, int y) {
		// Default values
		this.x = x;
		this.y = y;
		this.mazeSolver = mazeSolver;
		this.addActionListener(this);

		// Styling
		Border whiteline = BorderFactory.createLineBorder(Color.white);
		setBackground(Color.gray);
		setBorder(whiteline);
		setPreferredSize(new Dimension(43, 43));
	}

	/**
	 * When pressed: the method "setMazeTabElement" is used in the <br>
	 * MazeSolverModel class using the coordinates of the pressed button and <br>
	 * the current editorStatus.
	 * 
	 * @param ActionEvent e
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mazeSolver.getModel().setMazeTabElement(x, y, mazeSolver.getEditorStatus());
	}

}
