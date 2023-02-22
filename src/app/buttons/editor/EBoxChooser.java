package app.buttons.editor;

import java.awt.event.MouseEvent;

import app.MazeSolver;

@SuppressWarnings("serial")
public class EBoxChooser extends ChooserButtons {

	public EBoxChooser(MazeSolver mazeSolver) {
		super(mazeSolver, "E");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		getMazeSolver().setEditor("E");

	}

}
