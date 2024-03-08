
public abstract  class Items {
    
//protected String name;*
protected double price;
//protected char size;   حذفتها لأن الورد ما عنه  حجم *

//Constructors 
public Items(){  
//this.name=name;*
this.price=0;

}

public Items(Items i){
	//this.name=i.name;*
	this.price=i.price;
	
}
//methods
public abstract double caculatePrice();

// setters and getters
public String toString(){
    return "price is: " + price;
}


public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


}

