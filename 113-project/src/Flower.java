
public class Flower extends Items {

	public int type; // each number represents a flower type #1 Rose, 2# Lily, 3#Blossom 	
	private int flowerStock = 250; // يحتاج اسوي عداد في كلاساتي؟
	private int numOfFlowers;// number of flowers the coustmer want to add

<<<<<<< HEAD
	public Flower(int type,int numofFlowes) {
=======
	public Flower(int type, int numOfFlowers) {
>>>>>>> branch 'main' of https://github.com/Sasasul/113-java-project.git
		super();
		this.type = type;
<<<<<<< HEAD
		this.numOfFlowers=numofFlowes;
=======
		this.numOfFlowers=numOfFlowers;
>>>>>>> branch 'main' of https://github.com/Sasasul/113-java-project.git

		switch (this.type) {

		case 1:
			price = 100;
<<<<<<< HEAD
				break;
=======
			break;

>>>>>>> branch 'main' of https://github.com/Sasasul/113-java-project.git
		case 2:
			price = 200;
			break;
<<<<<<< HEAD
=======

>>>>>>> branch 'main' of https://github.com/Sasasul/113-java-project.git
		case 3:
			price = 300;
			break;
<<<<<<< HEAD
=======

>>>>>>> branch 'main' of https://github.com/Sasasul/113-java-project.git
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
<<<<<<< HEAD
			return price * numOfFlowers;
=======
			System.out.println(" i am in case one ");
			System.out.println(numOfFlowers);
			return price * numOfFlowers;
		
>>>>>>> branch 'main' of https://github.com/Sasasul/113-java-project.git
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
