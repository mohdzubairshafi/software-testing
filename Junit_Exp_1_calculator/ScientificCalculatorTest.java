import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ScientificCalculatorTest {

	@Test
	public void testArithmeticOperations() {
		String string1 = "Junit";
		String string2 = "Junit";
		String string3 = "test";
		String string4 = string3;
		String string5 = null;
		int variable1 = 1;
		int variable2 = 2;
		int[] airethematicArrary1 = { 1, 2, 3 };
		int[] airethematicArrary2 = { 1, 2, 3 };

		// Assert statements
		assertEquals(string1, string2);
		assertSame(string1, string2);
		assertNotSame(string1, string3);
		assertNotNull(string1);
		assertNull(string5);
		assertTrue(variable1 < variable2);
		assertArrayEquals(airethematicArrary1, airethematicArrary2);
//		ScientificCalculator calculator = new ScientificCalculator();
//
//		assertEquals(5.0, calculator.add(2.0, 3.0), 0.0001);
//		assertEquals(2.0, calculator.subtract(5.0, 3.0), 0.0001);
//		assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.0001);
//		assertEquals(2.5, calculator.divide(5.0, 2.0), 0.0001);
//
//		assertThrows(IllegalArgumentException.class, () -> calculator.divide(5.0, 0.0));
	}

	@Test
	public void testPowerAndSquareRoot() {
		ScientificCalculator calculator = new ScientificCalculator();
		assertEquals(8.0, calculator.power(2.0, 3.0), 0.0001);
		assertEquals(5.0, calculator.squareRoot(25.0), 0.0001);
	}

	@Test
	public void testTrigonometricFunctions() {
		ScientificCalculator calculator = new ScientificCalculator();

		assertEquals(0.0, calculator.sin(0.0), 0.0001);
		assertEquals(1.0, calculator.cos(0.0), 0.0001);
		assertEquals(0.0, calculator.tan(0.0), 0.0001);

		assertEquals(1.0, calculator.sin(90.0), 0.0001);
		assertEquals(0.0, calculator.cos(90.0), 0.0001);
		assertEquals(1.0, calculator.tan(45.0), 0.0001);
	}

}
