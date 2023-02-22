package app.buttons.nav;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import app.MazeSolver;

@SuppressWarnings("serial")
public class SolveButton extends NavButtons implements ActionListener, MouseListener {

	public SolveButton(MazeSolver mazeSolver) {
		super(mazeSolver, "Solve");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		getMazeSolver().getModel().solveMaze();
	}

}
