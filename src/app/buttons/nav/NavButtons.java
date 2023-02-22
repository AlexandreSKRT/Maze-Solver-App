package app.buttons.nav;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import app.MazeSolver;

@SuppressWarnings("serial")
public abstract class NavButtons extends JButton implements ActionListener, MouseListener {

	private final MazeSolver mazeSolver;

	public NavButtons(MazeSolver mazeSolver, String label) {
		// Default values
		super(label);
		this.mazeSolver = mazeSolver;

		// Styling
		Border whiteline = BorderFactory.createLineBorder(Color.white);
		setBorder(whiteline);
		setFocusable(false);
		setPreferredSize(new Dimension(30, 60));
		setFont(new Font("Calibri", Font.BOLD, 20));

		// Listeners
		addActionListener(this);
		addMouseListener(this);

	}

	public MazeSolver getMazeSolver() {
		return mazeSolver;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
