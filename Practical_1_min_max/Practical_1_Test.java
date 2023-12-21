import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class Practical_1_Test {

	@Test
	public void testFindMinAndMax() {
		int[] numbers = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };

		Practical_1.Pair result = Practical_1.findMinAndMax(numbers);

		assertEquals(1, result.min);
		assertEquals(9, result.max);
	}

	@Test
	public void testFindMinAndMaxEmptyList() {
		int[] emptyList = {};

		// empty list.
		assertThrows(IllegalArgumentException.class, () -> {
			Practical_1.findMinAndMax(emptyList);
		});
	}
}
