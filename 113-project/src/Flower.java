
public class Flower extends Items {

	private int type; // each number represents a flower type #1 Rose, 2# Lily, 3#Blossom وش فرق النوع
						// عن الاسم؟ عموما بعتبر
	private int flowerStock = 250; // يحتاج اسوي عداد في كلاساتي؟
	private int numOfFlowers;// number of flowers the coustmer want to add
	// ^^-سوي لها سيت بالمين

	public Flower(int type, int numOfFlowers) {
		super();
		this.type = type;

		switch (this.type) {

		case 1:
			price = 100;

		case 2:
			price = 200;

		case 3:
			price = 300;

		default:
			price = 0;
		}
		flowerStock--;//
	}

	public Flower(Flower i) {
		super(i);
		type = i.type;
	}

	public double caculatePrice() {// عشاني حطيت السعر في الكونستركتر صار هذا ماله فايده

		switch (this.type) {

		case 1:
			return 7 * numOfFlowers;
		// الحين ذا سعر وردة ولاباقة
		case 2:
			return 5 * numOfFlowers;

		case 3:
			return 6 * numOfFlowers;

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
