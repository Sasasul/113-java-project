
public class Order {
	private int numOfOrder;
	private Items[] itemList;
	private int numOfItems;
	private Customer customer;

	public Order(Customer customer) { // Constructor
		customer = new Customer(customer.getName(), customer.getId());
		itemList = new Items[10];
		numOfItems = 0;
		numOfOrder++;
	}

	// Methods
	public boolean addItem(Items i) {
		if (numOfItems < itemList.length) {
			if (i instanceof ChocolateBox) {
				itemList[numOfItems++] = new ChocolateBox((ChocolateBox) i);
				}
			else {
				
				itemList[numOfItems++] = new Flower((Flower) (i));
			}//}
			return true;
		} // end if
		else
			return false;
	}

	public boolean removeItem(String name) {
		boolean ItemRemoved = false;
		for (int i = 0; i < numOfItems; i++) {
			if (itemList[i].getClass().getName().equals(name)) {
				itemList[i] = null;
				ItemRemoved = true;
			} // end if
		} // end for
		return ItemRemoved;
	}

	public boolean serchChocolateBox(String s) {
		boolean IsThereChoclateBox = false;
		for (int i = 0; i < numOfItems; i++) {
			if (itemList[i] instanceof ChocolateBox) {
			}
			IsThereChoclateBox = true;
		}
		return IsThereChoclateBox;
	}

	public double calculateTotalprice() {
		double TotalPrice = 0;
		for (int i = 0; i < numOfItems; i++) {
			TotalPrice += itemList[i].caculatePrice();
		}
		return TotalPrice;
	}

	public String toString() {
		String info = "Order Number: " + numOfOrder + "\n" + "Customer info: " + customer.toString();
		for (int i = 0; i < numOfItems-1; i++) {
			info += itemList[i].toString();
		}
		return info;
	}

}