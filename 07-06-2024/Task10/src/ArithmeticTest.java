import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ArithmeticTest {
	@BeforeClass
	public static void setUpClass() {
	// This block is executed before all the methods of test
	}
	@Before
	public void setUp() {
	// This block is executed before each method of test
	}
	@Test
	public void testArithmetic() {
	// This block is executed for testing product method of Arithmetic class
	Arithmetic arithmetic = new Arithmetic();
	int number1 = 20;
	int number2 = 19;
	int actualvalue = arithmetic.add(number1, number2);
	int expectedvalue = 39;
	assertEquals(expectedvalue, actualvalue);
	}
	@Test
	public void testDivision() {
	// This block is executed for testing division method of Arithmetic class
	}
	@After
	public void tearDown() {
	// This block is executed after ech method of test
	}
	@AfterClass
	public static void tearDownClass() {
	// This block is executed after all the methods of test
	}
	
	
}
