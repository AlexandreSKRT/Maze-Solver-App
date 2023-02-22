package app.buttons.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import app.MazeSolver;
import app.buttons.Colors;

@SuppressWarnings("serial")
public class ColorIndicator extends JButton {

	public ColorIndicator(MazeSolver mazeSolver) {
		// Styling
		Border border = new LineBorder(Color.WHITE, 12);
		setBackground(Color.LIGHT_GRAY);
		setBorder(border);
		setFocusable(false);
		setFont(new Font("Calibri", Font.BOLD, 20));
		setPreferredSize(new Dimension(100, 100));
	}

	/**
	 * Each time the user chooses a maze case type he wants to add in the maze: <br>
	 * the following method is notified and used. Depending on the maze case <br>
	 * type chosen, the background of the button is changed. This provides a <br>
	 * visual information in order to indicate the user which case he chose.
	 * 
	 * @param String caseEditorStatus
	 * @return void
	 */
	public void changeBackground(String caseEditorStatus) {
		switch (caseEditorStatus) {
		case "E":
			setBackground(Colors.empty);
			break;
		case "D":
			setBackground(Colors.start);
			break;
		case "W":
			setBackground(Colors.wall);
			break;
		case "A":
			setBackground(Colors.finish);
			break;
		}
		repaint();
	}
}
