package view;

import gui.Box;
import gui.Button;
import gui.NumberSlider;
import controller.Controller;

//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014

/**
 * Puts it all togethor in the window
 * 
 * @author tcharles94
 * 
 */
public class View {

	public static final int TRACK_HEIGHT = 40; // this one must be public
	private static final int LEFT_MARGIN = 20;
	private static final int TOP_MARGIN = 20;

	private BeatNumbers _beatNumbers;
	private SoundBank _soundBank;
	private Header _header;
	private Tracks _track;
	private NumberSlider _slider;
	public View(Controller controller, int numTracks, int numBeats) {
		Window window = new Window(controller, "Rhythminator");
		window.setSize(900, 500);
		// 30
		_header = new Header(controller);
		window.add(_header);
		_header.setLocation(20, 20);
		// gap 10
		_track = new Tracks(controller, numTracks, numBeats);
		window.add(_track);
		_track.setLocation(170, 70);

		_soundBank = new SoundBank(controller, numTracks);
		_soundBank.setLocation(20, 70);
		window.add(_soundBank);

		int k = 30 + 10 + (numTracks * (30 + 10) + 30);
		ControlButtons buttons = new ControlButtons(controller);
		buttons.setLocation(20, k);
		window.add(buttons);

		_beatNumbers = new BeatNumbers(numBeats);
		_beatNumbers.setLocation(170, k);
		window.add(_beatNumbers);

		_slider = new NumberSlider(controller, "number", 10, 200, 60);
		_slider.setLocation(170, k + 40);
		window.add(_slider);

		window.setVisible(true);

	}

	public void clearBeatNumbers() {
		_beatNumbers.clear();
	}

	public void setBeatNumber(int beatNumber) {
		_beatNumbers.setBeatNumber(beatNumber);
	}

	public void setSoundName(int trackNumber, String soundName) {
		_soundBank.setSoundBank(trackNumber, soundName);
	}
	
	public String getHeader(){
		return _header.getFileName();
	}
	
	public String getNoteSquare(){
		return _track.toString();
	}
	
	public String getSlider(){
		return _slider.toString();
	}
	
}


