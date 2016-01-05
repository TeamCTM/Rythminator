package view;
import java.awt.event.MouseEvent;

import controller.Controller;
import gui.Box;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014

/**
 * Makes the SoundNameBox in the GUI
 * @author tcharles94
 *
 */
public class SoundNameBox extends Box {
	public final static int WIDTH = 130;
	public final static int HEIGHT = 30;
	public Controller cont;
	public int trackNum;
	private static final long serialVersionUID = 1L;

	public SoundNameBox(Controller c, int num) {
		super();
		cont = c;
		trackNum = num;
		setSize(WIDTH, HEIGHT);
	}

	@Override
	public void mousePressed(MouseEvent mev) {
		String text = this.getText();
		SoundChooser.open(cont, trackNum, text);
	}
}
