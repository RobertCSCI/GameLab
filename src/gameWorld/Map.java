package gameWorld;

public class Map extends Item {
	public Map(String name, String desc) {
		super(name, desc);
	}

	public void use() {
		Game.print("\nYou are currently in " +getRoom().toString());
		if(getRoom().getExit('n') == null) {
			Game.print("North: nothing");
		} else {
			Game.print("North: " +getRoom().getExit('n').toString());
		}
		if(getRoom().getExit('s') == null) {
			Game.print("South: nothing");
			} else {
				Game.print("South: " +getRoom().getExit('s').toString());
		}
		if(getRoom().getExit('e') == null) {
			Game.print("East: nothing");
			} else {
				Game.print("East: " +getRoom().getExit('e').toString());
		}
		if(getRoom().getExit('w') == null) {
			Game.print("West: nothing");
			} else {
				Game.print("West: " +getRoom().getExit('w').toString());
		}
		if(getRoom().getExit('u') == null) {
				Game.print("Upwards: nothing");
		} else {
				Game.print("Upwards: " +getRoom().getExit('u').toString());
		}
		if(getRoom().getExit('d') == null) {
			Game.print("Downwards: nothing \n");
			} else {
				Game.print("Downwards: " +getRoom().getExit('d').toString()+"\n");
		}
	}
}
