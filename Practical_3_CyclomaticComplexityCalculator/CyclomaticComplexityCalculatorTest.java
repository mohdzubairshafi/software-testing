import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CyclomaticComplexityCalculatorTest {

	@Test
	void testCalculate() {
		String fileName = "Example.java";
		int expectedComplexity = 3; // Expected complexity based on the example code
		int actualComplexity = CyclomaticComplexityCalculator.calculate(fileName);
		assertEquals(expectedComplexity, actualComplexity);
	}

	@Test
	public void testCyclomaticComplexityWithInvalidFile() {
		int actualComplexity = CyclomaticComplexityCalculator.calculate("NonexistentFile.java");
		// Cyclomatic complexity calculation should return -1 for an invalid file
		assertEquals(-1, actualComplexity);
	}
}
