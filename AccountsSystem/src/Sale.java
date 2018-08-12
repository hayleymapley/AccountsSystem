
public class Sale implements Transaction {

	private String name;
	private String product;
	private double price;
	
	public Sale(String n, String p, double pri) {
		name = n;
		product = p;
		price = pri;
	}
	
	public String getName() {
		return name;
	}

	public String getProduct() {
		return product;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Name: " + this.getName() + "\n" +
				"Product: " + this.getProduct() + "\n" +
				"Price: " + this.getPrice() + "\n";
	}
	
}
