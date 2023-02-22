package app.panels;

import java.awt.GridLayout;

import javax.swing.JPanel;

import app.MazeSolver;
import app.buttons.editor.ABoxChooser;
import app.buttons.editor.ColorIndicator;
import app.buttons.editor.DBoxChooser;
import app.buttons.editor.EBoxChooser;
import app.buttons.editor.WBoxChooser;

@SuppressWarnings("serial")
public class CaseEditorPanel extends JPanel {
	private final ABoxChooser aBoxChooser;
	private final DBoxChooser dBoxChooser;
	private final EBoxChooser eBoxChooser;
	private final WBoxChooser wBoxChooser;
	private final ColorIndicator colorIndicator;

	public CaseEditorPanel(MazeSolver mazeSolver) {
		setLayout(new GridLayout(5, 1));
		add(dBoxChooser = new DBoxChooser(mazeSolver));
		add(aBoxChooser = new ABoxChooser(mazeSolver));
		add(eBoxChooser = new EBoxChooser(mazeSolver));
		add(wBoxChooser = new WBoxChooser(mazeSolver));
		add(colorIndicator = new ColorIndicator(mazeSolver));
	}

	public ColorIndicator getColorIndicator() {
		return colorIndicator;
	}

}
