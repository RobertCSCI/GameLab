package gameWorld;

public class Scientist extends NPC {
	public Scientist(String name, String desc) {
		super(name,desc);
	}
	
	int count = 0;
	Item notes = new Item("Notes","These are lab notes, they look very important");
	
	public void talk() {
		if(count == 0) {
			say("I thought I'd be stuck in here forever, Thanks for getting the door open."
					+ "I'm Alya, the head scientist of this facility.");
			String[] options = {
					"Nice to meet you.",
					"Whatever, can you help me get out of here or not?"
			};
			getResponse(options);
		} else if(count == 1) {
			say("\nIf you go down the elevator, there's a Masterkey which you need to go up the elevator to the office."
					+ "There's also a spacesuit which you need to reach the hanger, and if you get me some important lab notes,"
					+ "I'll give you the combination for the safe in the office.");
			String[] options = {
					"I think I got all that, No problem.",
					"I hate doing chores, but I'll do what I can."
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
					say("I'm guessing you're trying to get back to Earth, I can help you if you need it.\n");
					break;
				case 2:
					say("Sure, as long as you don't give me that attitude.");
					break;
			}
		} else {
			switch(option) {
				case 1:
					say("I have faith in you, I'll be waiting.");
					break;
				case 2:
					say("Don't worry, you'll be out of here in no time.");
					break;
			}
		}
	}

	public void give(Item i) {
		if(i.toString().equals("Notes")) {
			say("Thank you so much for getting me these notes, here's that combination for the safe.");
			Game.print("You trade with Ayla the lab notes for the safe combination.");
			Game.inventory.remove(notes);
			Game.inventory.add(new Combination("Combo","This is a combination for a safe."));
		}
	}
}
