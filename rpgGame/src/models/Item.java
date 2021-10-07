package models;

public class Item {	
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	private String name;
	private int power;
	private int price;
	
	public void setItem(String n , int p , int pr) {
		this.name = n;
		this.power = p;
		this.price = pr;
	}

	public String getName() {
		return name;
	}
	
	
}
