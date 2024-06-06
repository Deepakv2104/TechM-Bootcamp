import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SimpleTest {
	@BeforeClass
	public static void setUpClass() {
	// This block is executed before all the methods of test
	}
	@Before
	public void setUp() {
	// This block is executed before each method of test
	}
	@Test
	public void testProduct() {
	// This block is executed for testing product method of Arithmetic class
	Arithmetic arithmetic = new Arithmetic();
	int number1 = 100;
	int number2 = 5;
	int actualvalue = arithmetic.product(number1, number2);
	int expectedvalue = 500;
	assertEquals(expectedvalue, actualvalue);
	}
	@Test
	public void testDivision() {
	// This block is executed for testing division method of Arithmetic class
	}
	@After
	public void tearDown() {
	// This block is executed after each method of test
	}
	@AfterClass
	public static void tearDownClass() {
	// This block is executed after all the methods of test
	}
	
	
}
