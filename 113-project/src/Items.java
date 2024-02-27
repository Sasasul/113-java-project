
public abstract  class Items {
protected String name;
protected double price;

public items(String name, int price){
this.name=name;
this.price=price;
}

public abstract double caculatePrice();

public String toString(){
    return "nameis : " + name + "price is: " + price;
}

}
