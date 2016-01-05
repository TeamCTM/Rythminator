package view;
import gui.Box;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014

/**
 * Makes the single BeatNumber instance to be used
 * in BeatNumbers
 * @author tcharles94
 *
 */
public class BeatNumberSquare extends Box {
	private static final long serialVersionUID = 1L;
	public int beat;
	public boolean state;

	public BeatNumberSquare(int b) {
		super();
		beat = b;
		state = false;
		String x = Integer.toString(beat);
		setText(x); 
		setForeground(Colors.BEATNUMBER_OFF_FG);
		setBackground(Colors.BEATNUMBER_OFF_BG);
		setSize(NoteSquare.SIZE,NoteSquare.SIZE);
	}
	public void setState(boolean s)
	{
		state = s;
		if(state == true)
		{
		setForeground(Colors.BEATNUMBER_ON_FG);
		setBackground(Colors.BEATNUMBER_ON_BG);
		}
		if(state == false)
		{
		setForeground(Colors.BEATNUMBER_OFF_FG);
		setBackground(Colors.BEATNUMBER_OFF_BG);
		}
		invalidate();
	}
}
