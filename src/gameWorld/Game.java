package gameWorld;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {
		runGame();
	}
	
	public static void runGame() {
		Room currentRoom = World.buildWorld();
		Scanner input = new Scanner(System.in);
		ArrayList<Item> inventory = new ArrayList<Item>();
		
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
					currentRoom = nextRoom;
					System.out.print("\n");
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
			case "x":
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Unknown Command.\n");
			}
			
		} while(!command.equals("x"));
		
		input.close();
	}
}
