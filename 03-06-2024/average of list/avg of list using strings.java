package assign3;

import java.util.ArrayList;
import java.util.List;

public class List_Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst = new ArrayList<>();
		lst.add(15);
		lst.add(52);
		lst.add(80);
		lst.add(90);
		System.out.println(lst);
		
		double avg = lst.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
		System.out.println("the average of elements in List :: "+avg);
	}

}
