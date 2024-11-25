package gameWorld;

public class Diamond extends Item {
	public Diamond(String name, String desc) {
		super(name, desc);
	}

	public void use() {
		if(getRoom().getExit('e') == null) {
			Game.print("The Diamond doesn't work here.\n");
		} else {
			if(getRoom().getExit('e').getName().equals("Vault")) {
				getRoom().getExit('e').setLock(false);
				Game.print("You unlocked the Vault.\n");
			} else {
				Game.print("The Diamond doesn't work here.\n");
			}
		}
	}
}
