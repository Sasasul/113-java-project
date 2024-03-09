public abstract  class Items {
    
protected double price;

//Constructors 
public Items(){  
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

