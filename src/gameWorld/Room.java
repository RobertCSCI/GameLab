package gameWorld;

import java.util.HashMap;

public class Room {
	private String name;
	private String desc;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private HashMap<String, Item> item = new HashMap<String, Item>();
	private boolean lock;
	
	public Room(String n, String d) {
		name = n;
		desc = d;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
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
	
	public boolean getLock() {
		return lock;
	}
	
	public void setLock(boolean l) {
		lock = l;
	}
	
	public String toString() {
		return desc;
	}
}
