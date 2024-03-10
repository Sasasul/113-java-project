import java.util.Scanner;

public class Order {
	static Scanner input = new Scanner(System.in);

	private int numOfOrder;
	private Items[] itemList;
	private int numOfItems;
	private Customer customer;

	// Constructor
	public Order(Customer customer) {
		this.customer = new Customer(customer.getName(), customer.getId());
		itemList = new Items[10];
		numOfItems = 0;
		numOfOrder++;
	}

	// Methods
	public boolean addItem(Items i) {
		if (numOfItems < itemList.length) {
			if (i instanceof ChocolateBox) {
				itemList[numOfItems++] = new ChocolateBox((ChocolateBox) i);
			} else if ((i instanceof Flower)) {
				System.out.println("how many Flowers do want from this type? ");// asking user for the numOfFlower he
																				// want
																				// to add
				int numperOfFlowes = input.nextInt();
				itemList[numOfItems++] = new Flower(((Flower) i).type, numperOfFlowes);
			} // }
			return true;
		} // end if
		else
			return false;
	}

	public boolean removeItem(String name) {

		boolean ItemRemoved = false;
		for (int i = 0; i < numOfItems ; i++) {
			if (itemList[i]!=null&&itemList[i].getClass().getName().equalsIgnoreCase(name)) {
				itemList[i] = itemList[++i];
				itemList[--numOfItems] = null;
				ItemRemoved= true;
			} // end if
		} // end for
		return ItemRemoved;
	}

	public boolean serchChocolateBox(String s) {
		boolean IsThereChoclateBox = false;
		for (int i = 0; i < numOfItems; i++) {
			if (itemList[i] instanceof ChocolateBox)
				IsThereChoclateBox = true;
		}
		return IsThereChoclateBox;
	}

	public double calculateTotalprice() {
		double TotalPrice = 0;
		for (int i = 0; i < numOfItems; i++) {
			if (itemList[i] != null)
				TotalPrice += itemList[i].caculatePrice();
			System.out.println(TotalPrice);
		}
		System.out.println(TotalPrice);
		return TotalPrice;
	}

	public String toString() {
		String info = "Order Number: " + numOfOrder + "\n" + "Customer info: " + customer;
		for (int i = 0; i < numOfItems; i++) {
			info += itemList[i].toString();
		}
		return info;
	}
}