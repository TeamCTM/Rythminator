package model;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014
import message.Sequencer;

public class Model {

	public int _numTracks;
	public int _numBeats;
	public int i;
	private SoundBank _soundBank;
	public Sequencer _sequencer;
	private Chord[] _chords;
	private Clock _clock;

	/**
	 * The model sets up the clock. Most of the work of running the application
	 * happens in the clock.
	 * 
	 * @param numTracks
	 * @param numBeats
	 */
	public Model(int numTracks, int numBeats) 
	{
		_numTracks = numTracks;
		_numBeats = numBeats;
		_sequencer = new Sequencer(numBeats);//numBeats
		Sound sounds[] = new Sound[numTracks];
		_soundBank = new SoundBank(sounds);
		_chords = new Chord[numBeats];
		for(int i=0; i < _chords.length; i++)
		{
			Chord cho = new Chord(_soundBank, _numTracks);
			_chords[i] = cho;
			_sequencer.subscribe(_chords[i]);
		}
		_clock = new Clock();
		_clock.subscribe(_sequencer);

	}

	public int getBeatNumber() {
		return _sequencer.getStepNumber();
	}

	public Clock getClock() {
		return _clock;
	}

	public void startPlaying() {
		_clock.start();
	}

	public void stopPlaying() {
		_clock.stop();
	}

	public void setNote(int trackNum, int beatNum, boolean value) {
		_chords[beatNum].setNote(trackNum, value);
	}

	public void setSoundName(int trackNum, String soundName) 
	{
		Sound sound = new Sound(soundName);
		_soundBank.setSound(trackNum, sound);
	}
	
	public String getSound()
	{
		return _soundBank.toString();
	}

	
}
