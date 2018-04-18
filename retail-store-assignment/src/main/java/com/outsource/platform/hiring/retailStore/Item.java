package main.java.com.outsource.platform.hiring.retailStore;

/**
 * This class store the item detail for each of the grocery item
 * @author manisha nandal
 *
 */
public class Item {

	private String name;
	private int quantity;
	private double price;
	private String category;
	
	public Item() {
		
	}
	
	public Item(String name, int quantity, double price, String category) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		
	}
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}
	
}
