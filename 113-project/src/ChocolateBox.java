public class ChocolateBox extends Items {

	private char size;
	private int chocolateStock = 50;

	// Constructor
	public ChocolateBox(char size) {
		this.size = size;
		chocolateStock--;
	}

	public ChocolateBox(ChocolateBox i) {
		super(i);
		size = i.size;
	}

	// methods
	public double caculatePrice() {

		switch (this.size) {

		case 'S':
			price=60;
			return price;

		case 'M':
			price=80;

			return price;

		case 'L':
			price=100;
			return price;

		default:
			return 0;
		}
	}

	public String toString() {
		return super.toString() + "Chocolate Box size is: " + size + "\n";
	}

	// setters and getters
	public int getChocolateStock() {
		return chocolateStock;
	}

	public void setChocolateStock(int chocolateStock) {
		this.chocolateStock = chocolateStock;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}
}
