package Day1;

//for reversing a number
import java.lang.System;
import java.lang.String;
import java.util.Scanner;

public class Reverse {
public static void main(String args[]) {
	int num,rev;
	rev=0;
	Scanner s = new Scanner(System.in);
	
	System.out.println("Enter the Number");
	num=s.nextInt();   //1234
	
	while(num>0) {
		rev=rev*10 + num%10;
	    num/=10;
	}
	System.out.println("Reverse of a given number is" + rev);
 }
}
