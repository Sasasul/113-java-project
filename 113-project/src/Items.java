
public abstract  class Items {
    
protected String name;
protected double price;


public Items(String name, int price){  
this.name=name;
this.price=price;
}

public abstract double caculatePrice();

public String toString(){
    return "name is : " + name + "price is: " + price;
}

}
