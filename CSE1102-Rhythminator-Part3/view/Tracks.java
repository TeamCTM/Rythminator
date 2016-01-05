package view;
import javax.swing.JPanel;

import controller.Controller;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014

/**
 * Puts all the noteSquares to the number of tracks
 * and the number of beats in the GUI
 * @author tcharles94
 *
 */
public class Tracks extends JPanel {
	private static final long serialVersionUID = 1L;
	public final int GAP_SIZE = 10;
	private NoteSquare[][] array;
	
	public Tracks(Controller c, int numTracks, int numBeats) {
		{
			setLayout(null);
			array = new NoteSquare[numTracks][numBeats];
			System.out.println(array.length + " " + array[0].length);
			int x = 0;
			int y = 0;
			for (int t = 0; t < array.length; t++) {
				x = 0;
				for (int j = 0; j < array[t].length; j++) {
					array[t][j] = new NoteSquare(c, t + 1, j + 1);
					array[t][j].setLocation(x, y);
					add(array[t][j]);
					x = x + NoteSquare.SIZE + GAP_SIZE;
				}
				y = y + NoteSquare.SIZE + GAP_SIZE;
			}
			this.setSize(
					(NoteSquare.SIZE * numBeats + (GAP_SIZE * (numBeats - 1))),
					(NoteSquare.SIZE * numTracks)
							+ (GAP_SIZE * (numTracks - 1)));
		}
	}
	
	public String toString()
	{
		String s = "";
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				s += array[i][j].toString() + array[i][j].getValue();
			}
	}
	return s;
}
}