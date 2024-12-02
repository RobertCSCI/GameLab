package gameWorld;

public class Manager extends NPC {
	public Manager(String name, String desc) {
		super(name,desc);
	}
	
	int count = 0;
	
	public void talk() {
		if(count == 0) {
			say("Introduction");
			String[] options = {
					"Option 1",
					"Option 2"
			};
			getResponse(options);
		} else if(count == 1) {
			say("\nNext Dialogue");
			String[] options = {
					"Option 1",
					"Option 2"
			};
			getResponse(options);
		} else {
			say("More Dialogue\n");
		}
		count++;
	}
	
	public void response(int option) {
		if(count == 0) {
			switch(option) {
				case 1:
					say("Response 1\n");
					break;
				case 2:
					say("Response 2");
					Game.print("Dialogue\n");
					break;
			}
		} else {
			switch(option) {
				case 1:
					say("Response 3");
					Game.print("Dialogue\n");
					break;
				case 2:
					say("Response 4");
					Game.print("Dialogue\n");
					break;
			}
		}
	}

	public void give(Item i) {
		//Keycard keycard2 = new Keycard("Armorykey", "This is the keycard to the Armory.");
		//Item battery = new Item("Battery", "This is a battery for a spaceship.");
	}
}
