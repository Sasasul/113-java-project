
public class Flower extends items{
private String type;
private int flowerStock=250;


public Flower (String name, int price, String type){   // مدري ذا مفروض يجيه قيم ولا نعين شي ثابت :D
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
