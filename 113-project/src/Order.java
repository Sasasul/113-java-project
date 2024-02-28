
public class Order {
	private int numOfItems;
	private Items[] itemList;
	
	public Order() {
		itemList=new Items[10];
		numOfItems=0;
		
	}
	
	public boolean addItem(Items i) {
		if(numOfItems<itemList.length) {
			itemList[numOfItems++]=new Items(i);//لماذا!
		return true;
		}
	return false;
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
			if(itemList[i] instanceof  )
		}
	}


}