package model;

import message.ISubscriber;
import message.Message;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014
public class Chord implements ISubscriber
{

  private SoundBank _soundBank;
  private boolean[] _notes;

  public Chord(SoundBank soundBank, int numNotes)
  {
    _soundBank = soundBank;
    _notes = new boolean[numNotes];
  }

  @Override
  public void notify(Message message)
  {
    this.play();
  }

  public void play()
  {
    _soundBank.play(_notes);
  }

  public void setNote(int noteNumber, boolean noteValue)
  {
    _notes[noteNumber] = noteValue;
  }

}
