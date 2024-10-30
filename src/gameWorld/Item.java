package gameWorld;

public class Item {
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
}