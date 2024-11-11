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
		Item battery = new Item("Battery", "This is a battery.");
		Item locker = new Item("Locker", "This is a locker.");
		Item suit = new Item("Suit", "This is a Space Suit.");
		
		quarters.addExit(entrance, 'e');
		quarters.addExit(armory, 'n');
		quarters.addExit(office, 'u');
		quarters.addItem("Keycard", keycard);
		
		Combination combo = new Combination("combo","Combination for a safe.");
		quarters.addItem("combo", combo);
		
		//entrance.setLock(true);
		entrance.addExit(quarters, 'w');
		entrance.addExit(observatory, 'n');
		entrance.addExit(cantina, 'e');
		entrance.addExit(hanger, 's');
		
		Safe safe = new Safe("safe", "It's an impressive safe!");
		entrance.addItem("safe", safe);
		
		cantina.addExit(entrance, 'w');
		cantina.addItem("Battery", battery);
		
		office.addExit(quarters, 'd');
		office.addExit(vault, 'w');
		
		armory.addExit(quarters, 's');
		armory.addExit(observatory, 'e');
		armory.addItem("Locker", locker);
		armory.addItem("Suit", suit);
		
		observatory.addExit(armory, 'w');
		observatory.addExit(entrance, 's');
		
		hanger.addExit(entrance, 'n');
		
		vault.addExit(office, 'e');
		
		return quarters;
	}
}
