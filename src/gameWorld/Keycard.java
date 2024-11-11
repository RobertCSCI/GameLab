package gameWorld;

public class Keycard extends Item {
	public Keycard(String name, String desc) {
		super(name, desc);
	}
	
	public void use() {
		if(Game.currentRoom.getExit('e').getLock() != true) {
			Game.print("The key doesn't work here.\n");
		} else {
			Game.currentRoom.getExit('e').setLock(false);
			Game.print("You unlocked the door to the entrance.\n");
		}
	}
}
