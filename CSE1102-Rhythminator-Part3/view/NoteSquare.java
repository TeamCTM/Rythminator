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
 * 
 * @author tcharles94
 *
 */
public class NoteSquare extends Box {
	private static final long serialVersionUID = 1L;
	public static final int SIZE = 30;
	public Controller controller;
	public int trackNum;
	public int beatNum;
	public int value = 0;

	public NoteSquare(Controller c, int track, int beat) {
		super();
		controller = c;
		trackNum = track;
		beatNum = beat;
		setSize(SIZE, SIZE);
		setBackground(Colors.NOTESQUARE_OFF);
	}

	public int getBeat() {
		return beatNum;
	}

	public int getTrack() {
		return trackNum;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int x) {
		value = x;
		if (value == 0)
			setBackground(Colors.NOTESQUARE_OFF);
		else if (value == 1)
			setBackground(Colors.NOTESQUARE_ON);
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent mev) {
		this.setValue(1 - value);
	    controller.noteSquareClicked(this);
	}

	@Override
	public String toString() {
		return "NoteSquare (track = " + trackNum + ", beat = " + beatNum + ") ";
	}
}
