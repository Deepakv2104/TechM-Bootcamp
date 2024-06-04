package Day1;

import static java.lang.Float.*;
import static java.lang.Integer.*;

public class Ex6 {
public static void main(String args[]) {
	float p,r,si;
	int t;
	p = parseFloat(args[0]);
	r = parseFloat(args[1]);
	t = parseInt(args[2]);
	
	si=p*t*r/100;
	System.out.println("Simple interest is" + si);
	}
}