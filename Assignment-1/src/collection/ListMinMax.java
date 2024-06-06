package collection;

import java.util.List;
import java.util.Arrays;

import java.util.Collections;

public class ListMinMax {
	public static void main(String args[]) {
		List<Integer> num=Arrays.asList(40,39,8,44,10,16,33);
		int mini=Collections.min(num);
		int maxi=Collections.max(num);
		
		System.out.println("Min= " + mini + " Max= " + maxi);
	}
}