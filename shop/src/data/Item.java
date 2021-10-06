package data;

public class Item {
	
	private String name;
	private int price;
	private String category;
	
	public Item(String name, int price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}


	@Override
	public String toString() {
		String str = "";
		str += "[" + this.category + "] ";
		str += this.name;
		str += " ( " + this.price + "원 )";
		return str;
	};
	
}
