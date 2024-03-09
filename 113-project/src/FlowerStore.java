import java.util.Scanner;
public class FlowerStore {
public static void main(String[]args) {
	 Scanner input= new Scanner(System.in);	

				//hhhh
System.out.println("_______Flower Store_______");	
System.out.println("Welcome to Flower Store, enter your name and id : ");	
String name= input.next();
String ID = input.next();

Customer c1= new Customer(name,ID);
Order order= new Order(c1);

int customerChose;
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
	customerChose= input.nextInt();
	
    switch(customerChose){

        case 1:
	    // Add item
        System.out.println("Do you want to add Flowers 'F' or ChocolateBox 'C': ");
        char typeOrder = input.next().charAt(0);
  
        if (Character.toUpperCase(typeOrder)== 'F') {
        System.out.println("Enter the type each number represents a flower type #1 Rose, 2# Lily, 3#Blossom: ");
        int typeOfFlower = input.nextInt();

        //System.out.println("how many Flowers do want from this type? ");
       int numperOfFlowes=0;//ذاا
        Items it1 = new Flower(typeOfFlower,numperOfFlowes);
        //((Flower)it1).setNumOfFlowers(numperOfFlowes); 
        
        //هنا مفروض يطلب من اليوزر التايب وعدد الوردات
        if (order.addItem(it1))

  //     ** System.out.println("how many Flowers do want from this type? ");
       // int numOfFlowers= input.nextInt();
     //   Items it1 = new Flower(typeOfFlower, numOfFlowers);
        if (order.addItem(it1))
            System.out.println("Adding flower successfully");
        else
            System.out.println("Sorry, cannot add flower");
    } // end if
    else if (typeOrder == 'C') {  // new obj from user
    	 System.out.println("Enter the name ,price and size L,M,S :");
  
           
       
                char sizeOfChocolate = input.next().charAt(0);
     
                Items it2 = new ChocolateBox(sizeOfChocolate);
                				
        if (order.addItem(it2))
            System.out.println("Adding ChocolateBox successfully");
        } // end if

    
        else if (Character.toUpperCase(typeOrder) == 'C') {  
    	System.out.println("Enter the name ,price and size L,M,S :");
        char sizeOfChocolate = input.next().charAt(0);
        Items it2 = new ChocolateBox(sizeOfChocolate);    				
        if (order.addItem(it2))
        System.out.println("Adding ChocolateBox successfully");
        else
        System.out.println("Sorry, cannot add ChocolateBox");
        } // end if
        break;


        case 2:
	    // remove item
	    System.out.println("Enter the item name you want to remove: Rose, Lily,Blossom and ChocolateBox ");
	    String removeItem = input.next();
        if(order.removeItem(removeItem))
        System.out.println("removing succssfuly.");
        else
        System.out.println("Sorry, can not remove");
	    break;	


        case 3:
	    System.out.println("Check  is there  a ChocolateBox ?, enter ChocolateBox  ");
	    String serchItem = input.next();
	    if(order.serchChocolateBox(serchItem))
	    System.out.println("Yes, there is Chocolate Box. ");
        else
        System.out.println("No, there is not Chocolate Box. ");
	    break;


        case 4:
        double total=0;
        total= order.calculateTotalprice();
        System.out.println("The total price is: "+ total + "" );
	    break;


        case 5:
	    System.out.println(order);
	    break;	


        default:
        System.out.println("invaild input");
	
	
			
	
    } // end switch

System.out.println("Do you want to select another option?");
System.out.println("Enter yes or 6 to exite: ");
 end =input.next();

} // end do
while(customerChose!=6 && end.equalsIgnoreCase("yes"));

} // end main
} // end class
