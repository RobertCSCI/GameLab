package gameWorld;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Game extends World {
	public static void main(String[] args) {
		runGame();
	}
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	static Room currentRoom = World.buildWorld();
	
	static HashMap<String, String> rooms = new HashMap<String, String>();
	
	public static void popMap() {
		try {
			Scanner read = new Scanner(new File("Desc.txt"));
			while(read.hasNextLine()) {
				String key = read.nextLine();
				String value = read.nextLine();
				if(read.hasNextLine()) {
					String x = read.nextLine();
				}
				rooms.put(key, value);
			}
			read.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not Found");
		}
	}
	
	public static Room getRoom() {
		return currentRoom;
	}
	
	static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Item getInvItem(String name) {
		Item item = null;
		for(Item it : inventory) {
			if(it.toString().equals(name)) {
				item = it;
			}
		}
		if(item == null) {
			return null;
		} else {
			return item;
		}
	}
	
	public static void saveGame(String fileName) {
		File f = new File(fileName);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(currentRoom);
			stream.writeObject(rooms);
			stream.writeObject(inventory);
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File "+fileName+" not found.");
		} catch (IOException ex) {
		System.out.println("Bummers, man");
		}
	}
	
	public static void loadGame(String fileName) {
		File f = new File(fileName);
		try {
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream stream = new ObjectInputStream(fos);
			currentRoom = (Room) stream.readObject();
			rooms = (HashMap) stream.readObject();
			inventory = (ArrayList) stream.readObject();
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File "+fileName+" not found.");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Bummers, man");
		} catch (ClassNotFoundException ex) {
			System.out.println("Not an object.");
		}
	}
	
	public static Scanner input = new Scanner(System.in);
	
	public static void runGame() {
		currentRoom = getRoom();
		
		String command; // Player's command
		do {
			System.out.println(currentRoom);
			System.out.print("Where do you want to go? ");
			command = input.nextLine();
			String[] words = command.split(" ");
			
			switch(words[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Room nextRoom = currentRoom.getExit(command.charAt(0));
				if(nextRoom == null) {
					System.out.println("You cannot go that way.\n");
					} else {
						if(nextRoom.getName().equals("Hanger")) {
							int count = 0;
							for(Item it : inventory) {
								if(it.toString().equals("Spacesuit")) {
									count++;
								}
							}
						if(count == 0) {
							System.out.println("You need a spacesuit to reach the Hanger.\n");
						} else {
							currentRoom = nextRoom;
							System.out.print("\n");
						}
					} else if(nextRoom.getLock() == true) {
						System.out.println("This room is locked.\n");
					} else {
						currentRoom = nextRoom;
						System.out.print("\n");
						}
					}
				break;
			case "take":
				System.out.println("You are trying to take "+ words[1] +".");
				if(currentRoom.getItem(words[1]) != null) {
					inventory.add(currentRoom.getItem(words[1]));
					System.out.println("You picked up "+ currentRoom.getItem(words[1]) +".\n");
					currentRoom.removeItem(words[1]);
				} else {
					System.out.println("No item found.\n");
				}
				break;
			case "look":
				if(currentRoom.getItem(words[1]) != null) {
					System.out.println(currentRoom.getItem(words[1]).getDesc(words[1])+"\n");
				} else {
					boolean found = false;
					for(Item it : inventory) {
						if(words[1].equals(it.toString())) {
							System.out.println(it.getDesc(words[1])+"\n");
							found = true;
						}
					}
					if(found == false) {
						System.out.println("There is no such item.\n");
					}
				}
				break;
			case "i":
				if(inventory.size() == 0) {
					System.out.println("Inventory is empty.\n");
				} else {
					System.out.println("You are carrying: ");
					for(Item it : inventory) {
						System.out.println(it);
					}
				}
				System.out.print("\n");
				break;
			case "use":
				System.out.println("You are trying to use "+ words[1] +".");
				if(currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).use();
				} else {
					boolean found = false;
					for(Item it : inventory) {
						if(words[1].equals(it.toString())) {
							it.use();
							found = true;
						}
					}
					if(found == false) {
						System.out.println("No item to use.\n");
					}
				}
				break;
			case "open":
				System.out.println("You are trying to open "+ words[1] +".");
				if(currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).open();
				} else {
					boolean found = false;
					for(Item it : inventory) {
						if(words[1].equals(it.toString())) {
							it.open();
							found = true;
						}
					}
					if(found == false) {
						System.out.println("No item to open.\n");
					}
				}
				break;
			case "x":
				System.out.println("Goodbye!");
				break;
			case "save":
				saveGame("saveGame");
				break;
			case "load":
				loadGame("saveGame");
				break;
			case "talk":
				currentRoom.getNPC(words[1]).talk();
				break;
			default:
				System.out.println("Unknown Command.\n");
			}
			
		} while(!command.equals("x"));
		
		input.close();
	}
}
