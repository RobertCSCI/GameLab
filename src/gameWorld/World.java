package gameWorld;

public class World {
	public static Room buildWorld() {
		//Rooms
		Room quarters = new Room("Living Quarters", "This is the Living Quarters, it's full of beds and futuristic furniture."
				+ "There is also some kind of deactivated droid in the corner.");
		Room entrance = new Room("Entrance","This is the Entrance to the facility, the front desk is empty and there is a picture of the facility."
				+ "The frame looks dented, this picture could be used as a map.");
		Room armory = new Room("Armory","This is the Armory, the room is full of empty lockers.");
		Room office = new Room("Office","This is the Captain's Office, behind the desk is a huge vault door.");
		Room observatory = new Room("Observatory","This is an Observatory, it's packed with science equipment you don't fully understand.");
		Room cantina = new Room("Cantina","This is a Cantina, the leisure area with food and drinks. Looks like the manager is still here.");
		Room hanger = new Room("Hanger","This is the Hanger, it's pretty much empty and the door to Maintenance is jammed."
				+ "Only one spaceship is left, you could escape the facility if you fix it.");
		Room vault = new Room("Vault","This is the facility Vault behind the Captain's Office, there is a table with codes for a spaceship.");
		Room hallway = new Room("Hallway","This is a Hallway.");
		Room lab = new Room("Lab","This is the Laboratory.");
		Room storage = new Room("Storage","This is a Storage Room, there are many boxes and luggage around the room."
				+ "One open box is labeled 'Masterkeys' has one key left.");
		Room main = new Room("Maintenance","This is the hanger's Maintenance Room.");
			
		//Items
		Item droid = new Item("Droid","This is a decommissioned patrol droid, it looks like it's carrying a keycard.");
		Keycard keycard = new Keycard("Keycard", "This is a keycard to the cantina.");
		Keycard keycard2 = new Keycard("Armorykey", "This is the keycard to the Armory.");
		Keycard masterkey = new Keycard("Masterkey", "This is the Masterkey.");
		Map map = new Map("Map", "This is a map of the facility.");
		Battery battery = new Battery("Battery", "This is a battery needed to start up a spaceship.");
		Codes codes = new Codes("Codes","These are the codes required to operate and pilot a spaceship.");
		Hyperdrive hyperdrive = new Hyperdrive("Hyperdrive","This is the hyperdrive for a spaceship.");
		Item lockers = new Item("Lockers","Most of the lockers are empty except one which has some kind of hilt for a sword,"
				+ "the locker has a nametag that says 'Beamsword'.");
		Beamsword beamsword = new Beamsword("Beamsword", "This is a Beamsword, it looks like something from those old Sci-Fi movies."
				+ "This can be used to open jammed doors or doors with no available keycards.");
		Item suit = new Item("Spacesuit", "This is a Space Suit, it will be required to traverse outside the station to the Hanger.");
		Safe safe = new Safe("Safe", "This is the safe in the Captain's Office, It's an impressive safe!");
		Diamond Diamond = new Diamond("Diamond", "This is a diamond! You should eventually return this to the Cantina manager.");
		Combination combo = new Combination("Combo","This is the combination needed to open the safe in the Captain's Office.");
		Item notes = new Item("Notes","These are lab notes, they look very important");
		Safe suitcase = new Safe("Suitcase","This is a case that contains the spacesuit needed to go outside the facility.");
			
		//NPCs
		Scientist sci = new Scientist("Scientist","Ayla; Head Scientist of the facility");
		Manager man = new Manager("Manager","Dominick; Manager of the Cantina.");
			
		quarters.addExit(entrance, 'e');
		quarters.addExit(armory, 'n');
		quarters.addExit(office, 'u');
		quarters.addExit(hallway, 'd');
		quarters.addItem("Droid", droid);
		quarters.addItem("Keycard", keycard);
		quarters.setLock(false);
			
		entrance.addExit(quarters, 'w');
		entrance.addExit(observatory, 'n');
		entrance.addExit(cantina, 'e');
		entrance.addExit(hanger, 's');
		entrance.addItem("Map", map);
		entrance.setLock(false);
				
		cantina.addExit(entrance, 'w');
		cantina.addNPC("Manager", man);
		cantina.setLock(true);
				
		office.addExit(quarters, 'd');
		office.addExit(vault, 'w');
		office.setLock(false);
		office.addItem("Safe", safe);
				
		hallway.addExit(quarters, 'u');
		hallway.addExit(lab, 'n');
		hallway.addExit(storage, 's');
		hallway.setLock(false);
				
		lab.addExit(hallway, 's');
		lab.addItem("Suitcase", suitcase);
		lab.addItem("Notes", notes);
		lab.setLock(false);
				
		storage.addExit(hallway, 'n');
		storage.addItem("Masterkey", masterkey);
		storage.setLock(false);
				
		armory.addExit(quarters, 's');
		armory.addItem("Beamsword", beamsword);
		armory.addItem("Lockers", lockers);
		armory.setLock(false);
				
		observatory.addExit(entrance, 's');
		observatory.addItem("Combo", combo);
		observatory.addNPC("Scientist", sci);
		observatory.setLock(true);
				
		hanger.addExit(entrance, 'n');
		hanger.addExit(main, 'w');
		hanger.setLock(true);
				
		main.addExit(hanger, 'e');
		main.addItem("Hyperdrive", hyperdrive);
		main.setLock(true);
				
		vault.addExit(office, 'e');
		vault.addItem("Codes", codes);
		vault.setLock(true);
				
		return quarters;
	}
}
