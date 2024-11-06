package gameWorld;

public class Item extends Game {
	private String name;
	private String desc;

	public Item(String n, String d) {
		name = n;
		desc = d;
	}
	
	public void setDesc(String d) {
		desc = d;
	}
	
	public String getDesc(String d) {
		return desc;
	}
	
	public String toString() {
		return name;
	}
	
	public void open() {
		Game.print("You cannot open that.\n");
	}
	
	public void use() {
		Game.print("You cannot use that.\n");
	}
}