
public class ChocolateBox extends Items {

	private int chocolateStock = 50;
	private char size;

	public ChocolateBox(char size) {
		super();
		this.size = size;
		chocolateStock--;
	}

	public ChocolateBox(ChocolateBox i) {
		super(i);
		size = i.size;
	}

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

	public void setPrice(double price) {
		this.price = price; // #@
	}

	public String toString() {
		return super.toString() + "size is: " + size + "\n";
	}

	public int getChocolateStock() {
		return chocolateStock;
	}

	public void setChocolateStock() {
		this.chocolateStock -= 1;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

}
