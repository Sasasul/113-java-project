
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

public String toString(){
    return "name is : " + name + "price is: " + price;
}

}
