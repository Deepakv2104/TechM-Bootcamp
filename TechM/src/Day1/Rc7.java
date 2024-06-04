package Day1;

import java.util.Scanner;

public class Rc7 {
public static void main(String args[]) {
	//creating instance (object) in java.
	Scanner s = new Scanner(System.in);
	int num1,num2,temp;
	
	System.out.println("Enter the Value of num1");
	num1=s.nextInt();
	
	System.out.println("Enter the Value of num2");
	num2=s.nextInt();
	
	//Swapping
	temp=num1;
	num1=num2;
	num2=temp;
	
	System.out.println("After Swapping the values are" + num1 + " " + num2);
	
	}
}