import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SliceBasedTestingTest {

	@Test
	void testCalculateSum() {
		int result = SliceBasedTesting.calculate(5, "Sum");
		assertEquals(15, result, "Sum calculation is incorrect for N=5");
	}

	@Test
	void testCalculateProduct() {
		int result = SliceBasedTesting.calculate(5, "Product");
		assertEquals(120, result, "Product calculation is incorrect for N=5");
	}

	@Test
	void testInvalidCriterion() {
		int result = SliceBasedTesting.calculate(5, "InvalidCriterion");
		assertEquals(0, result, "Invalid criterion should return 0");
	}
}
