package collection;

import java.util.Arrays;
import java.util.ArrayList;
public class ArraytoCollection {
	public static void main(String args[]) {
		Integer[] arr= {1,2,3,4,5};
		ArrayList<Integer> al=new ArrayList<Integer>(Arrays.asList(arr));
		System.out.println(al);
	}
}