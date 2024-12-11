package gameWorld;

public class Codes extends Item {
	public Codes(String name, String desc) {
		super(name, desc);
	}
	
	Codes codes = new Codes("Codes","These are the codes required to operate and pilot a spaceship.");
	
	public void use() {
		if(Game.currentRoom.getName().equals("Hanger")) {
			Game.spaceship.add(codes);
			Game.print("You used the spaceship's and can now operate the ship.");
			Game.inventory.remove(codes);
		}
	}
}
