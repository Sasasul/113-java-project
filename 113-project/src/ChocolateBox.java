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
			return 60;

		case 'M':
			return 80;

		case 'L':
			return 100;

		default:
			return 0;
		}
	}

	public String toString() {
		return super.toString() + "size is: " + size + "\n";
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
