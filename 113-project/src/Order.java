import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class Order implements Serializable {
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
		boolean itemAdded = false;
		boolean thereIsChocoBox = false;
		if (numOfItems < itemList.length) {
			if (i instanceof ChocolateBox) {
				for (int j = 0; j < numOfItems; j++) {
					if (itemList[j] instanceof ChocolateBox) {// chacking if there is a ChocolateBox or not befour
																// adding .
						System.out.print("there is allrady a ChocolateBox");
						thereIsChocoBox = true;
					}

				}
				if (!thereIsChocoBox) {
					itemList[numOfItems++] = new ChocolateBox((ChocolateBox) i);
					itemAdded = true;
				}
			}

			else if ((i instanceof Flower)) {
				System.out.println("how many Flowers do want from this type? ");// asking user for the numOfFlower he
				// want
				// to add
				int numperOfFlowes = input.nextInt();
				itemList[numOfItems++] = new Flower(((Flower) i).type, numperOfFlowes);
				itemAdded = true;
			} //
		} // end if
		return itemAdded;
	}

	public boolean removeItem(int numOfitem) {
		boolean ItemRemoved = false;
		if (numOfitem < 4) {
			for (int i = 0; i < numOfItems; i++) {
				if (itemList[i] instanceof Flower && ((Flower) itemList[i]).getType() == numOfitem)
					for (int j = i; j < numOfItems - 1; j++) {
						itemList[j] = itemList[j + 1];
					}

			}
			itemList[--numOfItems] = null;
			ItemRemoved = true;
		} else if (numOfitem == 4) {
			itemList[numOfitem] = itemList[++numOfitem];
			itemList[--numOfItems] = null;
			ItemRemoved = true;
		} // else if

		// if

		return ItemRemoved;
	}

	public boolean searchChocolateBox(String s) {
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
		}

		return TotalPrice;

	}

	// File method to Write
	public void Save(String fileName) {
		try {
			FileOutputStream fOut = new FileOutputStream(fileName);
			PrintWriter fileOut = new PrintWriter(fOut);

			fileOut.println(numOfItems);
			fileOut.println(customer.getName());

			for (int i = 0; i < numOfItems; i++)
				fileOut.println(itemList[i]);

			fileOut.close();
			JOptionPane.showMessageDialog(this, "Successfully Saved");
			// checked exception
		} catch (IOException ef) {
			JOptionPane.showMessageDialog(this, + ef.toString());
			
		}

	}

// file method to read 
	public void load(String fileName) {

		try {

			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ji = new ObjectInputStream(fis);

			int size = ji.readInt();
			String name = (String) ji.readObject();
			customer.setName(name);

			for (int i = 0; i < size; i++) {
				Items obj = (Items) ji.readObject();
				this.addItem(obj);
			}
			ji.close();
			JOptionPane.showMessageDialog(this, + "Successfully Loaded!");

		}
		// checked exception
		catch (EOFException e) {
			JOptionPane.showMessageDialog(this, + e.toString());
		}

		// uncheack exception
		catch (ClassNotFoundException ef) {
			JOptionPane.showMessageDialog(this, + ef.toString());
		}
		// checked exception
		catch (IOException ef) {
			JOptionPane.showMessageDialog(this, + ef.toString());
		}

	}

	public String toString() {
		String info = "Order Number: " + numOfOrder + "\n" + "_____Customer info_____ \n" + customer;
		for (int i = 0; i < numOfItems; i++) {
			info += itemList[i].toString();

		}
		return info;
	}

}
