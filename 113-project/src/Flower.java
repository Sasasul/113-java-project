
public class Flower extends Items {

	public int type; // each number represents a flower type #1 Rose, 2# Lily, 3#Blossom 	
	private int flowerStock = 250; // يحتاج اسوي عداد في كلاساتي؟
	private int numOfFlowers;// number of flowers the coustmer want to add

	public Flower(int type,int numofFlowes) {
		super();
		this.type = type;
		this.numOfFlowers=numofFlowes;

		switch (this.type) {

		case 1:
			price = 100;
				break;
		case 2:
			price = 200;
			break;

		case 3:
			price = 300;
			break;

		default:
			price = 0;
			break;
		}
		flowerStock--;
	}

	public Flower(Flower i) {
		super(i);
		type = i.type;
	}

	public double caculatePrice() {
		System.out.println("num is "+numOfFlowers);
		switch (type) {

		case 1:
			System.out.println(" i am in case one ");
			System.out.println(numOfFlowers);
			return price * numOfFlowers;
		
		case 2:
			return price * numOfFlowers;

		case 3:
			return price * numOfFlowers;

		default:
			return 0;
		}
	}

	public String toString() {
		return super.toString() + " " + "Type is: " + type + "\n";
	}

	public int getNumOfFlowers() {
		return numOfFlowers;
	}

	public void setNumOfFlowers(int numOfFlowers) {
		this.numOfFlowers = numOfFlowers;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFlowerStock() {
		return flowerStock;
	}

	public void setPrice(double price) {
		this.price = price; // @@
	}

}
