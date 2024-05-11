import java.io.*;
public abstract class Items implements Serializable  { 
 protected double price; 

 public Items(Items i) { 
 this.price = i.price; 
 } 

 public Items(){};

 // methods 
 public abstract double caculatePrice(); // abstract method 
 public String toString() { 

 return "price is: " + price+ " SR"; 

 } 
// setters and getters 

 public double getPrice() { 

 return price; 

 } 
 public void setPrice(double price) { 

 this.price = price; 
 } 
} 

 
