
public class ChocolateBox extends Items {
    
private int chocolateStock = 50;
private char size;

public ChocolateBox(String name, int price, char size){
super(name,price);
this.size=size;
}

public double caculatePrice(){

switch(this.size){

    case 'S':
    return 60;

    case 'M':
    return 80;

    case 'L':
    return 100;

    default:
    return 0;
}  
}

public void setPrice(double price){
    this.price=price;                    //@@
    }


public String toString(){
    return super.toString() + "size is: " + size + "\n";
}
}
