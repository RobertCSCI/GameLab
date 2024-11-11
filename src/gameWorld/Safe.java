package gameWorld;

import java.util.ArrayList;

public class Safe extends Item {
	public Safe(String name, String desc) {
		super(name,desc);
	}
	
	//Combination c = new Combination("combo","Combination for a safe.");
	
	public void open() {
		int count = 0;
		for(Item it : Game.inventory) {
			if(it.getInvItem("combo").equals(new Combination("combo","Combination for a safe."))) {
				Game.print("Using the combination, you open the safe and find a\n"
						+ "diamond inside! Naturally, you pocket the diamond.\n");
				count++;
			} else {
				Game.print("The safe is locked and you don't have the "
				+ "combination.\n");
			}
			if (count >= 1) {
				Item Diamond = new Item("Diamond", "This is a diamond!");
				Game.inventory.add(Diamond);
			}
		}
	}
}

