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
		//this.customer = new Customer(customer.getName(), customer.getId());
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
			FileOutputStream fOut = new FileOutputStream(new File(fileName));
			PrintWriter fileOut = new PrintWriter(fOut);

			fileOut.println(numOfItems);
			//fileOut.println(customer.getName());

			for (int i = 0; i < numOfItems; i++)
				fileOut.println(itemList[i]);

			fileOut.close();
			JOptionPane.showMessageDialog(null, "Successfully Saved");
			// checked exception
		} catch (IOException ef) {
			 System.out.println("IOE error"+ ef.toString());
		}
	}

// file method to read 
	public void load(String fileName) {
		try {
			FileInputStream fis = new FileInputStream(new File(fileName));
			ObjectInputStream ji = new ObjectInputStream(fis);
			System.out.println("**");
			int size = ji.readInt();
			System.out.println("*");

			for (int i = 0; i < size; i++) {
				Items obj = (Items) ji.readObject();
				this.addItem(obj);
			}
			ji.close();	
		}
		
		// checked exception
		catch (EOFException e) {
			System.out.println("End of file reached"+ e.toString());

		}

		// uncheack exception
		catch (ClassNotFoundException ef) {
			System.out.println("CNF error"+ ef.toString());

		}
		// checked exception
		catch (IOException ef) {
			System.out.println("IOE error"+ ef.toString());
		}

	}
	   
   public void need(){
try{

File f1= new File("Items.dat");
FileOutputStream of= new FileOutputStream (f1);
ObjectOutputStream jo= new ObjectOutputStream(of);

			

			

jo.close();


File f2= new File("Report.txt");
FileOutputStream of2= new FileOutputStream (f2);
PrintWriter TextFile = new PrintWriter (of2);


			TextFile.println(numOfItems);
			//fileOut.println(customer.getName());

			for (int i = 0; i < numOfItems; i++)
				TextFile.println(itemList[i]);



FileInputStream fis =new FileInputStream (f1);
ObjectInputStream ji= new ObjectInputStream(fis);

try {
while (true)
{

			int size = ji.readInt();
			String name = (String) ji.readObject();
			//customer.setName(name);

			for (int i = 0; i < numOfItems; i++) {
				Items obj = (Items) ji.readObject();
				this.addItem(obj);
            TextFile.println(itemList[i]);}}





}catch(EOFException ef)
{
System.out.println(" EOF error");
}
ji.close();
TextFile.close();
}
catch(ClassNotFoundException ef)
{
System.out.println("CNF error");
}

catch(IOException ef)
{
System.out.println("IOE error");
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
