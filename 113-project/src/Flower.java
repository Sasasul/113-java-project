public class Flower extends Items {

	public int type; // each number represents a flower type #1 Rose, 2# Lily, 3#Blossom
	private int flowerStock = 250;
	private int numOfFlowers;// number of flowers the coustmer want to add

	// Constructor
	public Flower(int type, int numofFlowes) {
		this.type = type;
		this.numOfFlowers = numofFlowes;
		switch (this.type) {

		case 1:
			price = 6;
			break;
		case 2:
			price = 7;
			break;

		case 3:
			price = 5;
			break;

		default:
			price = 0;
			break;
		} // end switch
		flowerStock--;
	}

	public Flower(Flower i) {
		super(i);
		type = i.type;
	}

	// methods
	public double caculatePrice() {
		switch (type) {

		case 1:
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
		String nameOfFlower="";
		if(type==1)
			nameOfFlower="Rose";		
		if(type==2)
			nameOfFlower="Lily";
		if(type==3)
			nameOfFlower="Blossom";

		return super.toString() + " " + " Flower type is: " + nameOfFlower + "\n";
	}

	// setters and getters
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

}
