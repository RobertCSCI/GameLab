package gameWorld;

public class World {
	public static Room buildWorld() {
		Room quarters = new Room("Living Quarters", "Living Quarters.");
		Room entrance = new Room("Entrance","Entrance.");
		Room armory = new Room("Armory","Armory.");
		Room office = new Room("Office","Office.");
		Room observatory = new Room("Observatory","Observatory.");
		Room cantina = new Room("Cantina","Cantina.");
		Room hanger = new Room("Hanger","Hanger");
		Room vault = new Room("Vault","Vault");
		Keycard keycard = new Keycard("Keycard", "This is a keycard.");
		Item battery = new Item("Battery", "This is a battery for a spaceship.");
		Item codes = new Item("Codes","These are the codes required to operate the spaceship.");
		Item hyperdrive = new Item("Hyperdrive","This is the hyperdrive for the spaceship.");
		Item beamsword = new Item("Beamsword", "This is a Beamsword.");
		Item suit = new Item("Suit", "This is a Space Suit.");
		Safe safe = new Safe("safe", "It's an impressive safe!");
		Combination combo = new Combination("combo","Combination for a safe.");
		
		quarters.addExit(entrance, 'e');
		quarters.addExit(armory, 'n');
		quarters.addExit(office, 'u');
		quarters.addItem("Keycard", keycard);
		quarters.setLock(false);
		quarters.addItem("combo", combo);
		
		entrance.setLock(false);
		entrance.addExit(quarters, 'w');
		entrance.addExit(observatory, 'n');
		entrance.addExit(cantina, 'e');
		entrance.addExit(hanger, 's');
		
		cantina.addExit(entrance, 'w');
		cantina.addItem("Battery", battery);
		cantina.setLock(true);
		
		office.addExit(quarters, 'd');
		office.addExit(vault, 'w');
		office.setLock(false);
		office.addItem("safe", safe);
		
		armory.addExit(quarters, 's');
		armory.addExit(observatory, 'e');
		armory.addItem("Beamsword", beamsword);
		armory.addItem("Suit", suit);
		armory.setLock(false);
		
		observatory.addExit(armory, 'w');
		observatory.addExit(entrance, 's');
		observatory.setLock(false);
		
		hanger.addExit(entrance, 'n');
		hanger.addItem("Hyperdrive", hyperdrive);
		hanger.setLock(true);
		
		vault.addExit(office, 'e');
		vault.addItem("Codes", codes);
		vault.setLock(true);
		
		return quarters;
	}
}
