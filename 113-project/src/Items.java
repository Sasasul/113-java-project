public abstract class Items {

	protected double price;

	// Constructors
	public Items() {
		//this.price=0;
	}

	public Items(Items i) {
		this.price = i.price;

	}

	// methods
	public abstract double caculatePrice(); // abstract method

	public String toString() {
		return "price is: " + price;
	}

	// setters and getters
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
