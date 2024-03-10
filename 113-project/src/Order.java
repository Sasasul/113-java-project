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

	public boolean removeItem(int numOfitem) {
		boolean ItemRemoved = false;
		
	/////////////////////////محولاتي في الحل 
		if (numOfitem<4) {
			for (int i = 0; i < numOfItems; i++) {
				if(itemList[i] instanceof Flower && ((Flower)itemList[i]).getType())==numOfitem);{ // دمجت اللي تحت في اللي فوق 
				//if((((Flower)itemList[i]).getType())==numOfitem){
					for (int j = i; j < numOfItems-1; j++) {
					itemList[j]=itemList[j+1];
					}
					itemList[--numOfItems] = null;
					}
				else if (numOfitem==4) {
					itemList[numOfitem]=itemList[++numOfitem];
					itemList[--numOfItems] = null;
				}
			}
		return true;
		}
		
		///////////
		/*for (int i = 0; i < numOfItems ; i++) {
			if (itemList[i]!=null&&itemList[i].getClass().getName().equalsIgnoreCase(name)) {
				itemList[i] = itemList[++i];
				itemList[--numOfItems] = null;
				ItemRemoved= true;
			} // end if
		} // end for*/
		return false;
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
			//System.out.println(TotalPrice);  هنا حذفت جمل الطباعة وضبط 
		}
		//System.out.println(TotalPrice);
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
