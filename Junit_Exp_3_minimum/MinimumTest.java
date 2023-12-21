import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MinimumTest {

	@Test
	void testFindMinimum() {
		// Test case 1
		int[] numbers1 = { 5, 3, 8, 2, 7 };
		assertEquals(2, Minimum.findMinimum(numbers1), "Minimum should be 2");
		// Test case 2
		int[] numbers2 = { -1, 0, 10, -5, 8 };
		assertEquals(-5, Minimum.findMinimum(numbers2), "Minimum should be -5");
		// Test case 3
		int[] numbers3 = { 100, 200, 50, 300 };
		assertEquals(50, Minimum.findMinimum(numbers3), "Minimum should be 50");
		// Test case 4: Empty array
		int[] emptyArray = {};
		assertThrows(IllegalArgumentException.class, () -> Minimum.findMinimum(emptyArray),
				"Exception should be thrown for empty array");
	}
}
