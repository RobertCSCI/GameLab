package gameWorld;

public class World {
	public static Room buildWorld() {
		//Rooms
		Room quarters = new Room("Living Quarters", "Living Quarters.");
		Room entrance = new Room("Entrance","Entrance.");
		Room armory = new Room("Armory","Armory.");
		Room office = new Room("Office","Office.");
		Room observatory = new Room("Observatory","Observatory.");
		Room cantina = new Room("Cantina","Cantina.");
		Room hanger = new Room("Hanger","Hanger");
		Room vault = new Room("Vault","Vault");
		Room hallway = new Room("Hallway","Hallway.");
		Room lab = new Room("Lab","Lab.");
		Room storage = new Room("Storage","Storage Room.");
		Room main = new Room("Maintenance","Maintenance Room.");
		
		//Items
		Keycard keycard = new Keycard("Keycard", "This is a keycard.");
		Keycard keycard2 = new Keycard("Armorykey", "This is the keycard to the Armory.");
		Keycard masterkey = new Keycard("Masterkey", "This is the Masterkey.");
		Map map = new Map("Map", "This is a map of the facility.");
		Item battery = new Item("Battery", "This is a battery for a spaceship.");
		Item codes = new Item("Codes","These are the codes required to operate the spaceship.");
		Item hyperdrive = new Item("Hyperdrive","This is the hyperdrive for the spaceship.");
		Beamsword beamsword = new Beamsword("Beamsword", "This is a Beamsword.");
		Item suit = new Item("Spacesuit", "This is a Space Suit.");
		Safe safe = new Safe("Safe", "It's an impressive safe!");
		Combination combo = new Combination("Combo","This is a combination for a safe.");
		
		//NPCs
		Scientist sci = new Scientist("Scientist","Head Scientist of the facility");
		Manager man = new Manager("Manager","Manager of the Cantina.");
		
		quarters.addExit(entrance, 'e');
		quarters.addExit(armory, 'n');
		quarters.addExit(office, 'u');
		quarters.addExit(hallway, 'd');
		quarters.addItem("Keycard", keycard);
		quarters.setLock(false);
		
		entrance.addExit(quarters, 'w');
		entrance.addExit(observatory, 'n');
		entrance.addExit(cantina, 'e');
		entrance.addExit(hanger, 's');
		entrance.addItem("Map", map);
		entrance.setLock(false);
		
		cantina.addExit(entrance, 'w');
		cantina.addItem("Battery", battery);
		cantina.addItem("Armorykey", keycard2);
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
		lab.addItem("Spacesuit", suit);
		lab.setLock(false);
		
		storage.addExit(hallway, 'n');
		storage.addItem("Masterkey", masterkey);
		storage.setLock(false);
		
		armory.addExit(quarters, 's');
		armory.addItem("Beamsword", beamsword);
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

		return quarters;
	}
}
