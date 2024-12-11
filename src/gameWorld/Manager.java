package gameWorld;

public class Manager extends NPC {
	public Manager(String name, String desc) {
		super(name,desc);
	}
	
	int count = 0;
	Keycard Armorykey = new Keycard("Armorykey", "This is the keycard to the Armory.");
	Diamond Diamond = new Diamond("Diamond", "This is a diamond! You should eventually return this to the Cantina manager.");
	
	public void talk() {
		if(count == 0) {
			say("Hey, you're finally awake. I'm Dominick, I ran the Cantina of this facility before it was abandoned.");
			String[] options = {
					"What happened here?",
					"Is there any way to get out of here."
			};
			getResponse(options);
		} else if(count == 1) {
			say("\nI have a battery needed for the spaceship, if you can get me the diamond in the Captain's vault then I'll give this to you.");
			String[] options = {
					"Sounds easy enough, I'll get you that diamond.",
					"Fine, whatever..."
			};
			getResponse(options);
		} else {
			say("Good luck getting back home!\n");
		}
		count++;
	}
	
	public void response(int option) {
		if(count == 0) {
			switch(option) {
				case 1:
					say("It's a long story, you'll have to get back to Earth to find out. And lucky for you there's a spaceship in the hanger, "
							+ "you just have to fix it.\n");
					break;
				case 2:
					say("There is a spaceship in the hanger, but it needs a lot of repairs.\n");
					break;
			}
		} else {
			switch(option) {
				case 1:
					say("Thank you. Oh, by the way, you might need this.");
					Game.print("Dominick gives you the Armorykey, he tells you that this keycard unlocks the armory.\n");
					Game.inventory.add(Armorykey);
					break;
				case 2:
					say("You're gonna have to anyway if you wanna get outta here. Also, take this with you.");
					Game.print("Dominick gives you the Armorykey, he tells you that this keycard unlocks the armory.\n");
					Game.inventory.add(Armorykey);
					break;
			}
		}
	}

	public void give(Item i) {
		if(i.toString().equals("Diamond")) {
			say("I appreciate you getting this diamond for me. As promised, here's the battery.");
			Game.print("You trade with Dominick the diamond for the battery.");
			Game.inventory.remove(Diamond);
			Game.inventory.add(new Battery("Battery", "This is a battery needed to start up a spaceship."));
		}
	}
}
