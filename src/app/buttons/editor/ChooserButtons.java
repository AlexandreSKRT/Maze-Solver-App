package app.buttons.editor;

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
public class ChooserButtons extends JButton implements ActionListener, MouseListener {

	private final MazeSolver mazeSolver;

	public ChooserButtons(MazeSolver mazeSolver, String label) {
		// Button's Text
		super(label);
		Border whiteline = BorderFactory.createLineBorder(Color.white);

		this.mazeSolver = mazeSolver;
		// setBackground(new Color(69,123,157));
		setBorder(whiteline);
		setFocusable(false);
		setFont(new Font("Calibri", Font.BOLD, 20));
		setPreferredSize(new Dimension(70, 100));
		addActionListener(this);
		addMouseListener(this);

	}

	public MazeSolver getMazeSolver() {
		return mazeSolver;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// setBackground(new Color(29,53,87));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		// setForeground(Color.white);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// setBackground(new Color(69,123,157));
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		setForeground(Color.black);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
