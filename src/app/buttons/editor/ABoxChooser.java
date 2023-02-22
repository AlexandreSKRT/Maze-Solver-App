package app.buttons.editor;

import java.awt.event.MouseEvent;

import app.MazeSolver;

@SuppressWarnings("serial")
public class ABoxChooser extends ChooserButtons {

	public ABoxChooser(MazeSolver mazeSolver) {
		super(mazeSolver, "A");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		getMazeSolver().setEditor("A");

	}

}
