package gameWorld;

import java.util.HashMap;

public class Room {
	private String desc;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private HashMap<String, Item> item = new HashMap<String, Item>();
	
	public Room(String n) {
		desc = n;
	}
	
	public Room getExit(char x) {
		if (x == 'e') {
			return east;
		} else if (x == 'w') {
			return west;
		} else if (x == 'n') {
			return north;
		} else if (x == 's') {
			return south;
		} else if (x == 'u') {
			return up;
		} else if (x == 'd') {
			return down;
		} else {
			return null;
		}
	}
	
	public void addExit(Room r, char x) {
		if (x == 'e') {
			east = r;
		} else if (x == 'w') {
			west = r;
		} else if (x == 'n') {
			north = r;
		} else if (x == 's') {
			south = r;
		} else if (x == 'u') {
			up = r;
		} else if (x == 'd') {
			down = r;
		}
	}
	
	public void addItem(String name, Item i) {
		item.put(name, i);
	}
	
	public Item getItem(String n) {
		return item.get(n);
	}
	
	public void removeItem(String n) {
		item.remove(n);
	}
	
	public String toString() {
		return desc;
	}
}
