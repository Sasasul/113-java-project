
public class Order {
	//private numOfOrder;
	private int numOfItems;
	private Items[] itemList;
	
	public Order() {
		itemList=new Items[10];
		numOfItems=0;
		
	}
	
	public boolean addItem(Items i) {
		if(numOfItems<itemList.length) {
			if(i instanceof ChocolateBox)
				itemList[numOfItems++]=new ChocolateBox((ChocolateBox)i);//لماذا!
			else
				itemList[numOfItems++]=new Flower((Flower)(i.getName(),i.getPrice(),i.getType()));
		}//end if
	
	}
	
	public boolean removeItem(String name) {
		boolean ItemRemoved=false;
		for(int i=0;i<numOfItems;i++) {
			if(itemList[i].getName().equals(name)) {
				itemList[i]=null;
				ItemRemoved=true;
			}//end if
		}//end for
		return ItemRemoved;
	}
	
	public boolean serchItem(String s) {
		boolean IsThereChoclateBox=false;
		for(int i=0;i<numOfItems;i++) {
			if(itemList[i] instanceof ChocolateBox ) {}
			IsThereChoclateBox=true;
		}
		return IsThereChoclateBox;
	}

	public double calculateTotalprice() {
		double TotalPrice=0;
		for(int i=0;i<numOfItems;i++) {
			TotalPrice+=itemList[i].caculatePrice();
		}
		return TotalPrice;
	}
	
	public String toString() {
		String info="";
	} 

}