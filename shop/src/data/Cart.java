package data;

public class Cart {

	String itemName; 
	int itemCount;
	int itmPrice;
	
	public Cart(String itemName, int itemCount, int itemPrice) {
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.itmPrice = itemPrice;
	}
	
	
	
	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public int getItemCount() {
		return itemCount;
	}



	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}



	public int getItmPrice() {
		return itmPrice;
	}



	public void setItmPrice(int itmPrice) {
		this.itmPrice = itmPrice;
	}



	@Override
	public String toString() {
		String str = "";
		str += "[" + this.itemName + "] ";
		str += this.itmPrice;
		str += " ( " + this.itemCount + "개 )";
		return str;
	};
}
