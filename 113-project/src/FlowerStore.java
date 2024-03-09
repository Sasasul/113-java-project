import java.util.Scanner;
public class FlowerStore {
public static void main(String[]args) {

Scanner input= new Scanner(System.in);		
System.out.println("_______Flower Store_______");	
System.out.println("Welcome to our Flower Store, enter your name and id: ");	
String name= input.next();
String ID = input.next();

Customer customer01= new Customer(name,ID);
Order order= new Order(customer01);

int customerChose;
String chooseAnotherOption;
do {
	System.out.println("\nEnter your menu option:");	
	System.out.println("1-Add Item");		
	System.out.println("2-Remove Item");		
	System.out.println("3-There  is a ChoclateBox");		
	System.out.println("4-Calculate Total price");	
	System.out.println("5-Disply all order information:");
	System.out.println("6-Exite");
	System.out.println("your choice is:");
	customerChose= input.nextInt();
	
    switch(customerChose){

        case 1:
	    // Add item
        System.out.println("Do you want to add Flowers 'F' or ChocolateBox 'C': ");
        char typeOrder = input.next().charAt(0);
  
        if (Character.toUpperCase(typeOrder)== 'F') {
        System.out.println("Enter the type each number represents a flower type #1 Rose, 2# Lily, 3# Blossom: ");
        int typeOfFlower = input.nextInt();
        System.out.println("How many flowers do want from this type? ");
        int numOfFlowers= input.nextInt();
        Items it1 = new Flower(typeOfFlower, numOfFlowers);
        if (order.addItem(it1))
            System.out.println("Added flower successfully\n");
        else
            System.out.println("Sorry, we can't add the flower\n");
        } // end if

    
        else if (Character.toUpperCase(typeOrder) == 'C') {  
    	System.out.println("Enter the name, price, and size (L)or(M)or(S):");
        char sizeOfChocolate = input.next().charAt(0);
        Items it2 = new ChocolateBox(sizeOfChocolate);    				
        if (order.addItem(it2))
        System.out.println("Added ChocolateBox successfully");
        else
        System.out.println("Sorry, we can't add the Chocolate Box");
        } // end if
        break;


        case 2:
	    // remove item
	    System.out.println("Enter the item name that you want to remove: Rose, Lily, Blossom or Chocolate Box name");
	    String removeItem = (input.next()).toUpperCase();
        if(order.removeItem(removeItem))
        System.out.println("Removed succssfuly.\n");
        else
        System.out.println("Sorry, we can't remove it.\n");
	    break;	


        case 3:
        // serch item
	    System.out.println("Check is there a ChocolateBox? enter Chocolate Box name: ");
	    String serchItem = input.next();
	    if(order.serchChocolateBox(serchItem))
	    System.out.println("Yes, there is a Chocolate Box.\n");
        else
        System.out.println("No, there is no Chocolate Box.\n");
	    break;


        case 4:
        // calculate Total price
        double total=0;
        total= order.calculateTotalprice();
        System.out.println("The total price is: " + total + "" );
	    break;


        case 5:
        //Disply all order information
	    System.out.println(order);
	    break;	


        default:
        System.out.println("## invaild input ##\n");
	
	
			
	
    } // end switch

System.out.println("Do you want to select another option?");
System.out.println("Enter yes or 6 to exite: "); // what if it is another input
chooseAnotherOption =input.next();

} // end do
while(customerChose!=6 && chooseAnotherOption.equalsIgnoreCase("yes"));

} // end main
} // end class
