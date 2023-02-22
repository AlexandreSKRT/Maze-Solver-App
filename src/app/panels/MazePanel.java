package app.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.MazeSolver;
import app.buttons.mazecase.EmptyButton;
import app.buttons.mazecase.FinishButton;
import app.buttons.mazecase.PathButton;
import app.buttons.mazecase.StartButton;
import app.buttons.mazecase.WallButton;
import dijkstra.VertexInterface;

@SuppressWarnings("serial")
public class MazePanel extends JPanel implements ChangeListener {

	private final MazeSolver mazeSolver;

	public MazePanel(MazeSolver mazeSolver) {
		this.mazeSolver = mazeSolver;

		// MazePanel is considered a Listener
		mazeSolver.getModel().addObserver(this);

		// Update display
		updateMazeCases();

		// Styling
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

	}

	/**
	 * Each time the MazePanel is notified that the MazeSolverModel was changed: the
	 * panel updates its display by using the method "updateMazeCases".
	 * 
	 * @param ChangeEvent e
	 * @return void
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		updateMazeCases();
	}

	/**
	 * Removes all the items -buttons included- of the MazePanel. Creates a new
	 * GridBagLayout in which new buttons are created.<br>
	 * Each button correspond to a maze case of the model's maze.
	 * 
	 * @param none
	 * @return void
	 */
	public void updateMazeCases() {
		removeAll();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		for (VertexInterface v : mazeSolver.getModel().getMazeTab()) {
			int x = v.getx();
			int y = v.gety();
			gbc.gridx = x;
			gbc.gridy = y;
			switch (v.getLabel()) {
			case "A":
				add(new FinishButton(mazeSolver, x, y), gbc);
				break;
			case "D":
				add(new StartButton(mazeSolver, x, y), gbc);
				break;
			case "E":
				add(new EmptyButton(mazeSolver, x, y), gbc);
				break;
			case "W":
				add(new WallButton(mazeSolver, x, y), gbc);
				break;
			case "X":
				add(new PathButton(mazeSolver, x, y), gbc);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + v.getLabel());
			}
		}
		revalidate();
		repaint();
	}
}
