package collection;

import java.util.Collections;
import java.util.Vector;
public class VectorMax {
	public static void main(String args[]) {
		Vector<Integer> vec=new Vector<Integer>();
		vec.add(40);
		vec.add(39);
		vec.add(8);
		vec.add(44);
		vec.add(10);
		vec.add(16);
		vec.add(33);
		
		int maxi=Collections.max(vec);
		System.out.println("Maximum Element in Vector is " + maxi);
	}
}