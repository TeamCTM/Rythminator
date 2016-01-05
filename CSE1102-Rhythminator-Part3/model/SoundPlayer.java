package model;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014
import message.ISubscriber;
import message.Message;

public class SoundPlayer implements ISubscriber
{

  private SoundBank _soundBank;
  private int _soundNumber;

  public SoundPlayer(SoundBank soundBank, int soundNumber)
  {
    _soundBank = soundBank;
    _soundNumber = soundNumber;
  }

  @Override
  public void notify(Message message)
  {
    _soundBank.play(_soundNumber);
  }

}
