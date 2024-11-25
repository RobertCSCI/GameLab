package gameWorld;

public class Beamsword extends Item {
	public Beamsword(String name, String desc) {
		super(name, desc);
	}

	public void use() {
		if(getRoom().getExit('n') == null) {
			Game.print("The Beamsword won't work here.\n");
		} else {
			if(getRoom().getExit('e').getName().equals("Observatory")) {
				getRoom().getExit('e').setLock(false);
				Game.print("You used the Beamsword to open the Observatory.\n");
			} else {
				Game.print("The Beamsword won't work here.\n");
			}
		}
		if(getRoom().getExit('e') == null) {
			Game.print("The Beamsword won't work here.\n");
		} else {
			if(getRoom().getExit('e').getName().equals("Maintenence")) {
				getRoom().getExit('e').setLock(false);
				Game.print("You used the Beamsword to open the Maintenence Room.\n");
			} else {
				Game.print("The Beamsword won't work here.\n");
			}
		}
	}
}
