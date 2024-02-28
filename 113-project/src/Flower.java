
public class Flower extends Items{
    
private int type;                   // each number represents a flower type #1 Rose, 2# Lily, 3#Blossom         وش فرق النوع عن الاسم؟ عموما بعتبر           
private int flowerStock=250;       // يحتاج اسوي عداد في كلاساتي؟


public Flower (String name, int price, int type){   
super(name,price);
this.type=type;
}

public double caculatePrice(){

switch(this.type){

    case 1:
    return 100;                  
                                  // الحين ذا سعر وردة ولاباقة
    case 2:
    return 200;

    case 3:
    return 300;

    default:
    return 0;                    
}   
}

public void setPrice(double price){
this.price=price;                    //@@
}

public String toString(){
    return super.toString() + " " + "Type is: " + type +"\n";
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

public void setFlowerStock(int flowerStock) {
	this.flowerStock = flowerStock;
}


}
