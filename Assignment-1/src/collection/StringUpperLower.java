package collection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class StringUpperLower {
	public static void main(String args[]) {
		List<String> names=new ArrayList<String>();
		names.add("Tehith");
		names.add("Teja");
		names.add("Sai Tehith");
		names.add("Sai");
		
		List<String> lowerCase=names.stream().map(String::toLowerCase).collect(Collectors.toList());
		
		List<String> upperCase=names.stream().map(String::toUpperCase).collect(Collectors.toList());
		
		System.out.println(lowerCase);
		System.out.println(upperCase);
	}
}