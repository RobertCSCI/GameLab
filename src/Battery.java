package gameWorld;

public class Battery extends Item {
	public Battery(String name, String desc) {
		super(name, desc);
	}
	
	Battery battery = new Battery("Battery", "This is a battery needed to start up a spaceship.");
	
	public void use() {
		if(Game.currentRoom.getName().equals("Hanger")) {
			Game.spaceship.add(battery);
			Game.print("You replaced the spaceship's battery.");
			Game.inventory.remove(battery);
		}
	}
}
