package app.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import app.MazeSolver;

@SuppressWarnings("serial")
public class WindowPanel extends JPanel {

	private final NavPanel buttonsPanel;
	private final MazePanel mazePanel;
	private final CaseEditorPanel caseEditorPanel;

	public WindowPanel(MazeSolver mazeSolver) {
		setLayout(new BorderLayout());
		add(mazePanel = new MazePanel(mazeSolver), BorderLayout.CENTER);
		add(caseEditorPanel = new CaseEditorPanel(mazeSolver), BorderLayout.WEST);
		add(buttonsPanel = new NavPanel(mazeSolver), BorderLayout.SOUTH);
	}

	public CaseEditorPanel getCaseEditorPanel() {
		return caseEditorPanel;
	}

}
