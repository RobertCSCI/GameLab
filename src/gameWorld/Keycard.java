package gameWorld;

public class Keycard extends Item {
	public Keycard(String name, String desc) {
		super(name, desc);
	}
	
	public void use() {
		for(Item it : Game.inventory) { 
			if(it.toString().equals("Keycard")) {
				if(getRoom().getExit('e') == null) {
					Game.print("The keycard doesn't work here.\n");
				} else {
					if(getRoom().getExit('e').getName().equals("Cantina")) {
						getRoom().getExit('e').setLock(false);
						Game.print("You used the Keycard and unlocked the door to the Cantina.\n");
					} else {
						Game.print("The keycard doesn't work here.\n");
					}
				}
			} else if(it.toString().equals("Masterkey")) {
				if(getRoom().getExit('u') == null) {
					Game.print("The Masterkey doesn't work here.\n");
				} else {
					if(getRoom().getExit('u').getName().equals("Office")) {
						getRoom().getExit('u').setLock(false);
						Game.print("You used the Masterkey in the elevator and unlocked the upper floor.\n");
					} else {
						Game.print("The Masterkey doesn't work here.\n");
					}
				}
			} else if(it.toString().equals("Armory Keycard")) {
				if(getRoom().getExit('n') == null) {
					Game.print("This Keycard doesn't work here.\n");
				} else {
					if(getRoom().getExit('n').getName().equals("Armory")) {
						getRoom().getExit('n').setLock(false);
						Game.print("You used the Keycard and unlocked the Armory.\n");
					} else {
						Game.print("This Keycard doesn't work here.\n");
					}
				}
			}
		}
	}
}
