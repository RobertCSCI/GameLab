package gameWorld;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("Desc.txt"));
			while(input.hasNextLine()) {
				Thread.sleep(1000);
				String line = input.nextLine();
				System.out.println(line);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!!");
		} catch (InterruptedException ex) {
			System.out.println("Bummer.");
		}
	}
}
