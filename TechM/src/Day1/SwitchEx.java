package Day1;


public class SwitchEx {
public static void main(String args[]) {
	String str= "Java";
	
	switch(str)
	{
	case "Python":
		System.out.println("Python is used for Machine Learning");
		break;
	case "JavaScript":
		System.out.println("JavaScript is used as Web UI Development");
		break;
	default:
		System.out.println("None of the choice is selected");
		break;
	case "Java":
		System.out.println("Java is used for web application devleopment");
		break;
	}
}
}