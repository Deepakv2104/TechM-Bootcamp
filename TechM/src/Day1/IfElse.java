package Day1;
import java.util.Scanner;
public class IfElse {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int num;
		
		System.out.println("Enter the Value of num");
		num=s.nextInt();
		
		if(num%2==0)
			System.out.println("Even Number");
		else
			System.out.println("Odd Number");
	 }
}
