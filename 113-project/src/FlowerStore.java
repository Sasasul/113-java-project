import java.util.Scanner;
public class FlowerStore {
public static void main(String[]args) {
	
	
			
Scanner input= new Scanner(System.in);	
System.out.println("Flower Store");	
System.out.println("Welcome to Flower Store, enter your name and id : ");	
String name= input.next();
String ID = input.next();
Customer c1= new Customer(name,ID);
Items obj1= new ChocolateBox("chocolate", 60,'M');
Items obj2= new Flower("Blossom", 5,1 );
do {
	System.out.println("Enter your menu option:");	
	System.out.println("1- Add Item");		
	System.out.println("2- Remove Item");		
	System.out.println("3- Search Item");		
	System.out.println("4- calculate Total price ");	
	System.out.println("5- Disply all order information: ");
	System.out.println("6- Exite ");
	System.out.println("your choice is :  ");
	int op= input.nextInt();
	
switch(op)
case 1:
	System.out.println("Enter item: "); // مو متأكدة منه 
	
	c1.addItem(obj1);
	c1.addItem(obj2);
break;	
case 2:
	System.out.println("Enter the item name you want to remove: Rose, Lily,Blossom and ChocolateBox ");
	String reitem = input.next();
	 c1.removeItem(reitem);
	break;	
case 3:
	System.out.println("Enter the item name you want to serch: Rose, Lily,Blossom and ChocolateBox ");
	String seitem = input.next();
	c1.serchChocolateBox(seitem);
	
	
	break;	
case 4:
	c1.calculateTotalprice();
	break;	
case 5:
	c1.toString()
	break;	

	
	
			
	
}
while(op!=6);








}
}
}
