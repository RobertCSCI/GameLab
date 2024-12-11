package gameLab;

public class Hyperdrive extends Item {
	public Hyperdrive(String name, String desc) {
		super(name, desc);
	}
	
	Hyperdrive hyperdrive = new Hyperdrive("Hyperdrive","This is the hyperdrive for a spaceship.");
	
	public void use() {
		if(Game.currentRoom.getName().equals("Hanger")) {
			Game.spaceship.add(hyperdrive);
			Game.print("You replaced the spaceship's hyperdrive.");
			Game.inventory.remove(hyperdrive);
		}
	}
}
