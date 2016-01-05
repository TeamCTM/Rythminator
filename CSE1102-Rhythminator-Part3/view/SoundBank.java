package view;
import javax.swing.JPanel;

import model.Sound;
import controller.Controller;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014

/**
 * Makes the soundBank instances on the left hand of the GUI
 * @author tcharles94
 *
 */
public class SoundBank extends JPanel {
	private static final long serialVersionUID = 1L;
	public static SoundNameBox soundNamebox[];
	private final int GAP_SIZE = 10;

	public SoundBank(Controller c, int numTracks) {
		setLayout(null);
		soundNamebox = new SoundNameBox[numTracks];
		int x = 0;
		int y = 0;
		for (int i = 0; i < soundNamebox.length; i++) {
			soundNamebox[i] = new SoundNameBox(c, i + 1);
			soundNamebox[i].setLocation(x, y);
			add(soundNamebox[i]);
			y = y + SoundNameBox.HEIGHT + GAP_SIZE;
		}
		this.setSize(
				SoundNameBox.WIDTH,
				((SoundNameBox.HEIGHT * soundNamebox.length) + (GAP_SIZE * soundNamebox.length)));
	}

	public void setSoundBank(int trackNum, String name) {
		soundNamebox[trackNum - 1].setText(name);
	}
}

