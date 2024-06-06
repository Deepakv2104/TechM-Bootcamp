package collection;

import java.util.List;
import java.util.OptionalDouble;
import java.util.ArrayList;
public class ListAverage {
	public static void main(String args[]) {
		List<Integer> nums=new ArrayList<Integer>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		nums.add(40);
		nums.add(50);
		
		OptionalDouble average=nums.stream().mapToInt(Integer::intValue).average();
		System.out.println("Average= " + average.getAsDouble());
		
		int summ=nums.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Average= " + (double)summ/nums.size());
	}
}