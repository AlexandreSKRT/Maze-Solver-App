package app.buttons.editor;

import java.awt.event.MouseEvent;

import app.MazeSolver;

@SuppressWarnings("serial")
public class DBoxChooser extends ChooserButtons {

	public DBoxChooser(MazeSolver mazeSolver) {
		super(mazeSolver, "D");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		getMazeSolver().setEditor("D");

	}
}
