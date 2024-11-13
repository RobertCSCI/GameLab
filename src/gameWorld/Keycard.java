package gameWorld;

public class Keycard extends Item {
	public Keycard(String name, String desc) {
		super(name, desc);
	}
	
	public void use() {
		if(getRoom().getExit('e') == null) {
			Game.print("The keycard doesn't work here.\n");
		} else {
			if(getRoom().getExit('e').getName().equals("Cantina")) {
				getRoom().getExit('e').setLock(false);
				Game.print("You unlocked the door to the entrance.\n");
			} else {
				Game.print("The keycard doesn't work here.\n");
			}
		}
	}
}

//getExit('e').getName().equals("Entrance")
