package view;
import java.awt.Component;

import gui.Button;
import gui.TextBox;

import javax.swing.JPanel;

import controller.Controller;
//Rhythminator part 3 Project
//CSE 1102
//Thomas Charles
//Saad Quador Section 4
//May 1, 2014
/**
 * Makes the header in the GUI
 * @author tcharles94
 *
 */
public class Header extends JPanel {
	private static final long serialVersionUID = 1L;
	private TextBox _fileNameBox;	public String textBoxName;

	public Header(Controller n) {
		setLayout(null);
		Button load = new Button(n, "Load");
		Button save = new Button(n, "Save");
		Button quit = new Button(n, "Quit");
		_fileNameBox = new TextBox("Unnamed", "Enter a new name:", "Change name");
	    _fileNameBox.setSize(200, 30);
	    _fileNameBox.setLocation(0, 0);
	    this.add(_fileNameBox);
		this.add(load);
		this.add(save);
		this.add(quit);
		load.setSize(60, 30);
		save.setSize(60, 30);
		quit.setSize(60, 30);
		_fileNameBox.setSize(200, 30);
		_fileNameBox.setLocation(0, 0);
		load.setLocation(210, 0);
		save.setLocation(280, 0);
		quit.setLocation(380, 0);
		this.setSize(440, 30);
	}

	public String getFileName() {
		textBoxName = _fileNameBox.getText();
		return textBoxName;
	}
}
