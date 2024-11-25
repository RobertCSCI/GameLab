package gameWorld;

public class Dog extends NPC {
	public Dog(String name, String desc) {
		super("Dog", "A hideous puppy wags his tail.");
	}
	
	int count = 0;
	
	public void talk() {
		if(count == 0) {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
					"Yes you are! Who's a good boy?",
					"Ew, no. You're actually kinda hideous."
			};
			getResponse(options);
		} else if(count == 1) {
			say("\nHey! Wanna play fetch? Say yes! Say yes!");
			String[] options = {
					"Yes! I love fetch!",
					"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(options);
		} else {
			say("Yip!\n");
		}
		count++;
	}
	
	public void response(int option) {
		if(count == 0) {
			switch(option) {
				case 1:
					say("I am! I'm a good boy!\n");
					break;
				case 2:
					say("I am adorable! Why are you so mean?");
					Game.print("The puppy bites you. You deserve it.\n");
					break;
			}
		} else {
			switch(option) {
				case 1:
					say("Yay! Fetch!");
					Game.print("The puppy runs off and returns with a ball. The player receives the ball.\n");
					break;
				case 2:
					say("You're a bad person! I don't like you!");
					Game.print("The puppy runs away and doesn't come back.\n");
					break;
			}
		}
	}
}
