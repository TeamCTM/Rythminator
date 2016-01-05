//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014
package model;

public class SoundBank
{

  private Sound[] _sounds;
  
  public SoundBank(Sound[] sounds)
  {
    _sounds = sounds;
  }

  public void play(boolean[] noteValues)
  {
    for(int n=0; n<noteValues.length; n++)
      if(noteValues[n])
      {
        Sound sound = _sounds[n];
        if(sound != null)
          _sounds[n].play();
      }
  }

  public void play(int soundNumber)
  {
    _sounds[soundNumber].play();
  }

  public void setSound(int soundNumber, Sound sound)
  {
    _sounds[soundNumber] = sound;
  }
  
  public String toString(){
	  String s = "";
	  for(int i = 0; i < _sounds.length; i++){
		  if( _sounds[i] != null){
			  s += _sounds[i].toString();
		  }
		  else
		  {
			  System.out.println("null");
		  }
	  }
	  return s;
  }
  
  
}
