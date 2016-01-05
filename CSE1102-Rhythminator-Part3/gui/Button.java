package gui;

import java.awt.event.MouseEvent;

import controller.Controller;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014
public class Button extends Box
{

  private Controller _controller;

  private static final long serialVersionUID = 1L;

  public Button(Controller controller, String text)
  {
    super();
    _controller = controller;
    this.setText(text);
    this.setForeground(Colors.BUTTON_FG);
    this.setBackground(Colors.BUTTON_BG);
  }

  @Override
  public void mousePressed(MouseEvent mev)
  {
    _controller.buttonPressed(this);
  }

  @Override
  public String toString()
  {
    return "Button(" + getText() + ")";
  }

}
