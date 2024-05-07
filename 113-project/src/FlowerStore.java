import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.*;

import javax.swing.*;

public class FlowerStore extends JFrame {
	final private Font mainFont = new Font("Segoe UI Emoji", Font.BOLD,18); //vairble for name font
	JTextField tfFirstName, tfId; //text field
	JLabel lbwelcome;


	public void initializeinput() {

		//____________________form panel______________________

	 	JLabel lbFirstName = new JLabel("✿name ");
		lbFirstName.setFont(mainFont);

		tfFirstName=new JTextField();
		tfFirstName.setFont(mainFont);

		JLabel lbId = new JLabel("✿ID"); 
		lbId.setFont(mainFont);

		tfId=new JTextField();
		tfId.setFont(mainFont);	


		JPanel formPenel = new JPanel();
		formPenel.setLayout(new GridLayout(4,1,5,5));
		formPenel.setOpaque(false);
		formPenel.add(lbFirstName);
		formPenel.add(tfFirstName);
		formPenel.add(lbId);
		formPenel.add(tfId);

		//____________________welcome label______________________

		lbwelcome = new JLabel();
		lbwelcome.setFont(mainFont);
		lbwelcome.setHorizontalAlignment(SwingConstants.CENTER); // Align text horizontally to the center

		//____________________bottom______________________
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(mainFont);
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = tfFirstName.getText();
				lbwelcome.setText("❀✿ welcome "+ name + " ✿❀");

				throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
			}
			
		});


		JButton btnClear = new JButton("Clear");
		btnClear.setFont(mainFont);
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfFirstName.setText("");
				tfId.setText("");
				lbwelcome.setText("");

				throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
			}	
		});

		JPanel buttonsPanel=new JPanel();
		buttonsPanel.setLayout(new GridLayout(1,2,5,5));
		buttonsPanel.setOpaque(false);
		buttonsPanel.add(btnClear);
		buttonsPanel.add(btnNext);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(255,214,214));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.add(formPenel, BorderLayout.NORTH);
		mainPanel.add(lbwelcome, BorderLayout.CENTER);
		mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

		add(mainPanel);  //add mainPanel to JFrame
		
		ImageIcon flowerIcon=new ImageIcon("\"C:\\Users\\otaib\\Downloads\\FlowerImage.png\"");
		setTitle(" ‧₊˚❀༉‧₊˚.FLOWER STORE‧₊˚❀༉‧₊˚.");
		setIconImage(flowerIcon.getImage());
		setSize(400,300);
		setMinimumSize(new Dimension(300,400));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		setVisible(true);
	}

	public static void main(String[] args) {


		FlowerStore InputFrame = new FlowerStore();
		InputFrame.initializeinput();
		InputFrame.getDefaultCloseOperation();// سارة تجرب


		Scanner input = new Scanner(System.in);
		System.out.println("_______Flower Store_______");
		System.out.println("Welcome to our Flower Store, enter your name and id: ");
		String name = input.next();
		String ID = input.next();

		Customer customer01 = new Customer(name, ID);
		Order order = new Order(customer01);

		int costumerchoise;
		String chooseAnotherOption;
		do {
			System.out.println("\nEnter your menu option:");
			System.out.println("1-Add Item");
			System.out.println("2-Remove Item");
			System.out.println("3-is There a ChoclateBox ?");
			System.out.println("4-Calculate Total price ");
			System.out.println("5-Disply receipt:");
			System.out.println("6-Exite");
			System.out.println("your choice is:");
			costumerchoise = input.nextInt();

			switch (costumerchoise) {

			case 1:
				// Add item
				System.out.println("Do you want to add Flowers 'F' or ChocolateBox 'C': ");
				char typeOrder = input.next().charAt(0);

				if (Character.toUpperCase(typeOrder) == 'F') {
					System.out.println(
							"Enter the type each number represents a flower type #1 Rose, 2# Lily, 3# Blossom: ");
					int typeOfFlower = input.nextInt();
					int numOfFlowers = 0;
					Items it1 = new Flower(typeOfFlower, numOfFlowers);
					if (order.addItem(it1))
						System.out.println("Added flower successfully\n");
					else
						System.out.println("Sorry, we can't add the flower\n");
				} // end if

				else if (Character.toUpperCase(typeOrder) == 'C') {
					System.out.println("Enter size (L)or(M)or(S):");
					char sizeOfChocolate = input.next().charAt(0);
					Items it2 = new ChocolateBox(sizeOfChocolate);
					if (order.addItem(it2))
						System.out.println("Added ChocolateBox successfully");
					else
						System.out.println(" Sorry, we can't add the Chocolate Box");
				} // end if
				break;

			case 2:
				// remove item
				System.out.println(
						"Enter the item number that you want to remove: 1#Rose, 2#Lily, 3#Blossom or 4#ChocolateBox ");
				int removeItem = input.nextInt();
				if (order.removeItem(removeItem))
					System.out.println("Removed succssfuly.\n");
				else
					System.out.println("Sorry, we can't remove it.\n");
				break;

			case 3:
				// search item
				System.out.println("Checking for a ChocolateBox.....");
				 String searchItem ="ChocolateBox";
				if (order.searchChocolateBox(searchItem))
					System.out.println("Yes, there is a Chocolate Box.\n");
				else
					System.out.println("No, there is no Chocolate Box.\n");
				break;

			case 4:
				// calculate Total price
				double total = 0;
				total = order.calculateTotalprice();
				System.out.println("The total price is: " + total + "");
				break;

			case 5:
				// Disply all order information
				//ممكن هنا انادي الميثود اللي تسوي الفريم
				FlowerStore OutputFrame = new FlowerStore();
				OutputFrame.initializeOutput(order);
				//System.out.println(order);
				order.Save("test.text");
				break;

			default:
				System.out.println("## invaild input ##\n");

			} // end switch

			System.out.println("Do you want to select another option?");
			System.out.println("Enter yes or 6 to exite: "); // what if it is another input  
			chooseAnotherOption = input.next();

		} // end do
		while (costumerchoise != 6 && chooseAnotherOption.equalsIgnoreCase("yes"));

	} // end main
	public  void initializeOutput(Order order) {
		//___________Labels___________
		JLabel thxlabel=new JLabel();
		thxlabel.setText("❀ Thanks for shopping ❀");
		thxlabel.setFont(mainFont);
		thxlabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//JLabel receiptLabel=new JLabel();
		JTextArea receiptText = new JTextArea();
		receiptText.setText(order.toString());
		receiptText.setFont(mainFont);
		//receiptText.setSize(9,5);
		//receiptText.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel SULabel=new JLabel();
		SULabel.setText("See you soon <3");
		SULabel.setFont(mainFont);
		SULabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(255,214,214));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.add(thxlabel, BorderLayout.NORTH);
		mainPanel.add(receiptText, BorderLayout.CENTER);
		mainPanel.add(SULabel, BorderLayout.SOUTH);
		
		//____________Frame__________
		ImageIcon flowerIcon=new ImageIcon("\"C:\\Users\\otaib\\Downloads\\FlowerImage.png\"");
		JFrame OutputFrame=new JFrame();		
		OutputFrame.setTitle(" ‧₊˚❀༉‧₊˚.FLOWER STORE‧₊˚❀༉‧₊˚.");
		OutputFrame.setIconImage(flowerIcon.getImage());//ما ضبط 
		OutputFrame.setSize(400,300);
		OutputFrame.setMinimumSize(new Dimension(300,400));
		OutputFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		OutputFrame.setVisible(true);
		OutputFrame.add(mainPanel);  //add mainPanel to JFrame
		OutputFrame.pack();
	}
		
	
} // end class
