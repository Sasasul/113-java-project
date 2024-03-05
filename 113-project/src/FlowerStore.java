import java.util.Scanner;
public class FlowerStore {
static Scanner input= new Scanner(System.in);	
public static void main(String[]args) {
	
				
System.out.println("_______Flower Store_______");	
System.out.println("Welcome to Flower Store, enter your name and id : ");	
String name= input.next();
String ID = input.next();
Customer c1= new Customer(name,ID);

Order ord= new Order(c1);


int op;
String end;
do {
	System.out.println("Enter your menu option:");	
	System.out.println("1- Add Item");		
	System.out.println("2- Remove Item");		
	System.out.println("3- There  is a ChoclateBox ");		
	System.out.println("4- calculate Total price ");	
	System.out.println("5- Disply all order information: ");
	System.out.println("6- Exite ");
	System.out.println("your choice is :  ");
	op= input.nextInt();
	
switch(op)
{
case 1:
    System.out.println("Do you want to add Flowers 'F' or ChocolateBox 'C': ");
    char typeOrder = input.next().charAt(0);
    input.nextLine();  // Consume the newline character
    if (typeOrder == 'F') {
        System.out.println("Enter the name of flower, price, and type each number represents a flower type #1 Rose, 2# Lily, 3#Blossom:");
        String nF = input.next();
        int pF = input.nextInt();
        int tF = input.nextInt();
        Items it1 = new Flower(nF, pF, tF);
        
        if (ord.addItem(it1))
            System.out.println("Adding flower successfully");
        else
            System.out.println("Sorry, cannot add flower");
    } else if (typeOrder == 'C') {
               String nC = input.nextLine();
        int pC = input.nextInt();
        char sc = input.next().charAt(0);
        Items it2 = new ChocolateBox(nC, pC, sc);

        if (ord.addItem(it2))
            System.out.println("Adding ChocolateBox successfully");
        else
            System.out.println("Sorry, cannot add ChocolateBox");
    }
    break;
case 2:
	System.out.println("Enter the item name you want to remove: Rose, Lily,Blossom and ChocolateBox ");
	String removeItem = input.next();
if(ord.removeItem(removeItem))
System.out.println("removing succssfuly.");
else
System.out.println("Sorry, can not remove");
  

	break;	
case 3:
	System.out.println("Enter the item name you want to serch: Rose, Lily,Blossom and ChocolateBox ");
	String serchItem = input.next();
	if(ord.serchChocolateBox(serchItem))
	System.out.println("Yes, there is Chocolate Box. ");
else
System.out.println("No, there is not Chocolate Box. ");

	
	break;	
case 4:
double total=0;
total= ord.calculateTotalprice();
   System.out.println("The total price is:"+ total+ " ");
	break;	
case 5:
	System.out.println(ord.toString());
	break;	

default:
    System.out.println("invaild input");
	
	
			
	
}
System.out.println("Do you want to select another option?");
System.out.println("Enter yes or 6 to exite: ");
 end =input.next();

}
while(op!=6 && end.equalsIgnoreCase("yes"));

}
}

