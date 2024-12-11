package gameWorld;

//import java.util.ArrayList;

public class Safe extends Item {
	public Safe(String name, String desc) {
		super(name,desc);
	}
	
	Combination c = new Combination("combo","Combination for a safe.");
	
	public void open() {
		if(currentRoom.getName().equals("Office")) {
			int count = 0;
			for(Item it : Game.inventory) {
				if(it.getInvItem("combo").toString() == c.toString()) {
					Game.print("Using the combination, you open the safe and find a\n"
							+ "diamond inside! Naturally, you pocket the diamond.\n");
				count++;
				} else {
					Game.print("The safe is locked and you don't have the "
							+ "combination.\n");
				}
			}
			if (count >= 1) {
				Diamond Diamond = new Diamond("Diamond", "This is a diamond! You should eventually return this to the Cantina manager.");
				Game.inventory.add(Diamond);
			}
		} else if(currentRoom.getName().equals("Lab")) {
			Game.print("You opened the case and acquired a spacesuit, you can now get to the hanger.");
			Game.inventory.add(new Item("Spacesuit", "This is a Space Suit, it will be required to traverse outside the station to the Hanger."));
		}
	}
}
