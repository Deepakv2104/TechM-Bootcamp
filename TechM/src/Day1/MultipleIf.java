package Day1;



public class MultipleIf {
public static void main(String args[]) {
	int m1,m2,m3,total;
	float aveg;
	
	m1=Integer.parseInt(args[0]);
	m2=Integer.parseInt(args[1]);
	m3=Integer.parseInt(args[2]);
	
	total=m1+m2+m3;
	aveg=total/3;
	
	if(aveg>=80)
		System.out.println("Grade is A");
	else if(aveg>=70 && aveg<=79)
		System.out.println("Grade is B");
	else if(aveg>=60 && aveg<=69)
		System.out.println("Grade is C");
	else
		System.out.println("Fail...Better Luck Next Time");
	}
}