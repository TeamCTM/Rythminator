package view;
import javax.swing.JPanel;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014

/**
 * Makes the BeatNumber instances in the GUI
 * @author tcharles94
 *
 */
public class BeatNumbers extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int GAP_SIZE = 10;
	public static BeatNumberSquare[] beatNuminstances;

	public BeatNumbers(int beatNums) {
		setLayout(null);

		beatNuminstances = new BeatNumberSquare[beatNums];

		int x = 0;
		int y = 0;

		for (int t = 0; t < beatNuminstances.length; t++) {

			beatNuminstances[t] = new BeatNumberSquare(t + 1);
			beatNuminstances[t].setLocation(x, y);

			add(beatNuminstances[t]);
			x = x + NoteSquare.SIZE + GAP_SIZE;

		}
		this.setSize((NoteSquare.SIZE * beatNums) + (GAP_SIZE * (beatNums - 1)),30);
	}
	public void clear(){
		for (int i = 0; i < beatNuminstances.length; i++) {
			beatNuminstances[i].setState(false);
		}
	}
	public void setBeatNumber(int beat) {
		for (int i = 0; i < beatNuminstances.length; i++) {
			beatNuminstances[i].setState(false);
		}
		beatNuminstances[beat].setState(true);
	
	}
}
