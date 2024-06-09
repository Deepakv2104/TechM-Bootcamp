package assign3;

import java.util.ArrayList;
import java.util.List;

public class Even_odd_Sum {
	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		lst.add(15);
		lst.add(48);
		lst.add(73);
		lst.add(90);
		System.out.println(lst);
		
		double oddsum = lst.stream().mapToInt(Integer::intValue).filter(n -> n%2 != 0).sum();
		System.out.println("the odd elements sum = "+oddsum);

		double evensum = lst.stream().mapToInt(Integer::intValue).filter(n -> n%2 == 0).sum();
		System.out.println("the even elements sum = "+evensum);
	}
}
