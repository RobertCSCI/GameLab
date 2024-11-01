package gameWorld;

import java.util.ArrayList;

public class Safe extends Item {
	public Safe(String name, String desc) {
		super(name,desc);
	}
	
	ArrayList<Item> inventory = new ArrayList<Item>();
	
	Combination c = new Combination("combo","Combination for a safe.");
	
	public void open() {
		boolean found = false;
		for(Item it : inventory) {
			if(it == c) {
				Game.print("Using the combination, you open the safe and find a\n"
						+ "diamond inside! Naturally, you pocket the diamond.");;
				inventory.add(new Item("Diamond", "This is a diamond!"));
				found = true;
			}
		}
		if(found == false) {
			Game.print("The safe is locked and you don't have the\n"
					+ "combination.");
		}
	}
}
