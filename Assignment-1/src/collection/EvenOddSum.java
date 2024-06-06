package collection;

import java.util.List;
import java.util.ArrayList;
public class EvenOddSum {
	public static void main(String args[]) {
		List<Integer> nums=new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		
		int evenSum=nums.stream().mapToInt(Integer::intValue).filter(num -> num%2==0).sum();
		int oddSum=nums.stream().mapToInt(Integer::intValue).filter(num -> num%2!=0).sum();
		
		System.out.println("EvenSum = " + evenSum + " OddSum = " + oddSum);
	}
}