package gameWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NPC {
	private String name;
	private String desc;
	
	public NPC(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void say(String dialog) {
		Game.print("\n"+name+": "+dialog);	
	}
	
	public void talk() {
		Game.print("You can't talk to "+name+".\n");
	}
	
	public void response(int option) {
		// This method intentionally left blank.
	}
	
	/*public void getResponse(String[] options) {
		for(int i=0; i<options.length; i++) {
			Game.print("Option "+(i+1)+": "+options[i]);
		}
		Game.print("Enter an option (1-"+options.length+"):");
		int option = Game.input.nextInt();
		Game.input.nextLine(); // Flush input buffer
		response(option);
	}*/
	
	public void getResponse(String[] options) {
		String s = " ";
		for (int i = 0; i < options.length; i++) {
			s += "Option " + (i + 1) + ": " + options[i] + "\n";
		}
		s += "Enter an option (1-" + options.length + "):";
		int option = Integer.parseInt(JOptionPane.showInputDialog(s));
		response(option);
	}
	
	public void give(Item i) {
		Game.print(name+" doesn't want that.");
	}
}
