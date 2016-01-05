package view;
import gui.Button;

import javax.swing.JPanel;

import controller.Controller;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014

/**
 * Makes the play and stop buttons in the GUI
 * @author tcharles94
 *
 */
public class ControlButtons extends JPanel {
	private static final long serialVersionUID = 1L;

	public ControlButtons(Controller n) {
		setLayout(null);
		Button play = new Button(n, "Play");
		Button stop = new Button(n, "Stop");
		this.add(play);
		this.add(stop);
		play.setSize(60, 30);
		stop.setSize(60, 30);
		play.setLocation(0, 0);
		stop.setLocation(70, 0);
		this.setSize(130, 30);
	}
}
