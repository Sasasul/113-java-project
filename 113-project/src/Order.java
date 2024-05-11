import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class Order implements Serializable {
	static Scanner input = new Scanner(System.in);
	private int numOfOrder;
	private Items[] itemList;
	private int numOfItems;
	

	// Constructor
	public Order() {
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
	public void Save()throws IOException  {
		
			FileOutputStream fOut = new FileOutputStream(new File("orderInf.ser"));
         ObjectOutputStream oos = new  ObjectOutputStream (fOut);
         
					
				oos.writeObject(itemList);

			oos.close();
			JOptionPane.showMessageDialog(null, "Successfully Saved");
				}


// file method to read 
	public void load() {
		try {
			FileInputStream fis = new FileInputStream(new File("orderInf.ser"));
         ObjectInputStream ji = new ObjectInputStream(fis);
         
         File txt= new File("test.txt");
         FileOutputStream fos = new  FileOutputStream(txt);
         PrintWriter pr= new PrintWriter(fos);
         try {
        Items itemList[]  = (Items []) ji.readObject();
			pr.println(numOfItems);
		

			for (int i = 0; i < itemList.length ; i++)
         if(itemList[i]!= null)
         pr.println(itemList[i]);
         }
        
		
		// uncheack exception
		catch (ClassNotFoundException ef) {
			System.out.println("CNF error"+ ef.toString());

		}
      ji.close();
      pr.close();
		// checked exception
		}catch (IOException ef) {
			System.out.println("IOE error"+ ef.toString());
		}

	}

	   
 


	public String toString() {
		String info = "Order Number: " + numOfOrder;// + "_________Customer info_________ \n\n" + customer;
		for (int i = 0; i < numOfItems; i++) {
			info += itemList[i].toString();
		}
		return info;
	}

}
