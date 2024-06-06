package collection;

import java.util.List;
import java.util.OptionalInt;
import java.util.ArrayList;

public class StreamMaxMin {
	public static void main(String args[]) {
		List<Integer> nums=new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		
		OptionalInt maxi=nums.stream().mapToInt(Integer::intValue).max();
		OptionalInt mini=nums.stream().mapToInt(Integer::intValue).min();
		
		System.out.println("Max = " + maxi.getAsInt() + " Min = " + mini.getAsInt());
	}
}