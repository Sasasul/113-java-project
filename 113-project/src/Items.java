
public abstract  class Items {
    
protected String name;
protected double price;

//Constructors 
public Items(String name, int price){  
this.name=name;
this.price=price;
}
public Items(Items i) {
	name=i.name; 
	price=i.price;
}


public abstract double caculatePrice();

// setters and getters
public String toString(){
    return "name is : " + name + "price is: " + price;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


}

