package app.buttons.editor;

import java.awt.event.MouseEvent;

import app.MazeSolver;

@SuppressWarnings("serial")
public class WBoxChooser extends ChooserButtons {

	public WBoxChooser(MazeSolver mazeSolver) {
		super(mazeSolver, "W");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		getMazeSolver().setEditor("W");

	}

}
