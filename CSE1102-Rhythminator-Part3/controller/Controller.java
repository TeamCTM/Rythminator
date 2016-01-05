package controller;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014
import gui.Button;
import gui.Dialog;
import message.ISubscriber;
import message.Message;
import model.Clock;
import model.Model;
import view.Header;
import view.NoteSquare;
import view.View;

public class Controller implements ISubscriber {

	private Model _model;
	private Clock _clock;
	private View _view;

	public Controller(Clock clock, Model model) {
		_clock = clock;
		_model = model;
		_clock.subscribe(this);
	}

	public void buttonPressed(Button button) {
		if (button.getText().equals("Save"))
			_buttonSave();
		else if (button.getText().equals("Load"))
			_buttonLoad();
		else if (button.getText().equals("Play")) {
			_model.startPlaying();
			System.out.println("Controller.buttonPressed got Play button");
		} else if (button.getText().equals("Stop")) {
			_model.stopPlaying();
			_model._sequencer.reset();
			_view.setBeatNumber(_model.getBeatNumber());
			_view.clearBeatNumbers();
			System.out.println("Controller.buttonPressed got Stop button");
		} else if (button.getText().equals("Quit"))
			_buttonQuit();
		else
			System.out.println("Controller.buttonPressed " + button
					+ " pressed");
	}

	private void _buttonQuit() {
		if (Dialog.askYesNo("Exiting program", "Really quit?"))
			System.exit(0);
	}

	private void _buttonLoad() {
		System.out.println("Controller._buttonLoad called");
	}

	private void _buttonSave() {
		System.out.println(_view.getHeader());
		System.out.println(_model.getSound());
		System.out.println(_view.getNoteSquare());
		System.out.println(_view.getSlider());
		System.out.println("Controller._buttonSave called");
	}

	public void keyPressed(int keyCode) {
		System.out.println("Controller.keyPressed " + keyCode);
	}

	public void keyReleased(int keyCode) {
		System.out.println("Controller.keyReleased " + keyCode);
	}

	public void keyTyped(char keyChar) {
		System.out.println("Controller.keyTyped '" + keyChar + "'");
	}

	public void noteSquareClicked(NoteSquare noteSquare) {
		boolean value;
		if (noteSquare.getValue() == 0)
			value = false;
		else
			value = true;
		_model.setNote(noteSquare.getTrack() - 1, noteSquare.getBeat() - 1,
				value);
		System.out.println("Controller.noteSquareClicked " + noteSquare);
	}

	@Override
	public void notify(Message message) {
		int beatNum = _model.getBeatNumber() - 1;
		_view.setBeatNumber(beatNum);
		System.out.println("Controller.notify beat: " + beatNum);
	}

	public void soundNameSelected(int trackNumber, String soundName) {
		_model.setSoundName(trackNumber - 1, soundName);
		_view.setSoundName(trackNumber, soundName);
		System.out.println("Controller.soundNameSelected for track "
				+ trackNumber + ": " + soundName);
	}

	public void setView(View view) {
		_view = view;
	}

	public void sliderChange(String name, int value) {
		_clock.stop();
		_clock.setDelay(15000 / value);
		System.out.println("Controller.sliderChange " + name + " = " + value);
	}

}
