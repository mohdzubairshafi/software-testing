import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AsciiSumConverterTest {

	@Test
	void testConvertToBinarySum() {
		// Test case 1
		String input1 = "Hello";
		assertEquals("111110100", AsciiSumConverter.convertToBinarySum(input1));

		// Test case 2
		String input2 = "JUnit";
		assertEquals("111101010", AsciiSumConverter.convertToBinarySum(input2));

		// Test case 3
		String input3 = "12345";
		assertEquals("11111111", AsciiSumConverter.convertToBinarySum(input3));
		// Test case 4
		String input4 = "@";
		assertEquals("1000000", AsciiSumConverter.convertToBinarySum(input4));

		// Test case 5
		String input5 = "@#$%^";
		assertEquals("100001010", AsciiSumConverter.convertToBinarySum(input5));
	}

	@Test
	void testConvertToBinarySumWithNullInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			AsciiSumConverter.convertToBinarySum(null);
		});
	}

	@Test
	void testConvertToBinarySumWithEmptyInput() {
		String input = "";
		assertEquals("0", AsciiSumConverter.convertToBinarySum(input));
	}
}
