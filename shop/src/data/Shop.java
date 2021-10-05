package data;

public class Shop {

	public static Shop instance = new Shop();
	
	
	private String brand = "";
	
	public static int log = -1;
	
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
}
