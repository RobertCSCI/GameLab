package gameWorld;

public class World {
	public static Room buildWorld() {
		Room quarters = new Room("Living Quarters.");
		Room entrance = new Room("Front Entrance.");
		Room armory = new Room("Armory.");
		Room office = new Room("Office.");
		Room observatory = new Room("Observatory.");
		Room cantina = new Room("Cantina.");
		Room hanger = new Room("Hanger");
		Room vault = new Room("Vault");
		Item item1 = new Item("item1", "This is Item1");
		Item item2 = new Item("item2", "This is Item2");
		Item item3 = new Item("item3", "This is Item3");
		
		quarters.addExit(entrance, 'e');
		quarters.addExit(armory, 'n');
		quarters.addExit(office, 'u');
		quarters.addItem("item1", item1);
		
		entrance.addExit(quarters, 'w');
		entrance.addExit(observatory, 'n');
		entrance.addExit(cantina, 'e');
		entrance.addExit(hanger, 's');
		
		cantina.addExit(entrance, 'w');
		quarters.addItem("item2", item2);
		
		office.addExit(quarters, 'd');
		office.addExit(vault, 'w');
		quarters.addItem("item3", item3);
		
		armory.addExit(quarters, 's');
		armory.addExit(observatory, 'e');
		
		observatory.addExit(armory, 'w');
		observatory.addExit(entrance, 's');
		
		hanger.addExit(entrance, 'n');
		
		vault.addExit(office, 'e');
		
		return quarters;
	}
}
