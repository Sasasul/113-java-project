
public class Flower extends Items{
private String type;
private int flowerStock=250;


public Flower (String name, int price, String type){   
super(name,price);
this.type=type;
}

public double caculatePrice(){

    ///////////////////////
}

public String toString(){
    return super.toString() + " " + "Type is: " + type +"\n";
}

}
