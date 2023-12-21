import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class AssertStatementTest {

	@Test
	void testAssertEquals() {
		assertEquals(5, 2 + 3, "Addition should be correct");
	}

	@Test
	void testAssertNotEquals() {
		assertNotEquals(0, 2 * 3, "Multiplication should not result in zero");
	}

	@Test
	void testAssertTrue() {
		assertTrue((5 - 3) > 0, "Condition should be true");
	}

	@Test
	void testAssertFalse() {
		float a = 5 / 2;
		assertFalse(a == 2.0, "Condition should be false");
	}

	@Test
	void testAssertNull() {
		String str = null;
		assertNull(str, "String should be null");
	}

	@Test
	void testAssertNotNull() {
		String str = "Hello";
		assertNotNull(str, "String should not be null");
	}

	@Test
	void testAssertSame() {
		Object obj1 = new Object();
		Object obj2 = obj1;
		assertSame(obj1, obj2, "Objects should be the same");
	}

	@Test
	void testAssertNotSame() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		assertNotSame(obj1, obj2, "Objects should not be the same");
	}

	@Test
	void testAssertArrayEquals() {
		int[] expectedArray = { 1, 2, 3 };
		int[] actualArray = { 1, 2, 3 };
		assertArrayEquals(expectedArray, actualArray, "Arrays should be equal");
	}

	@Test
	void testAssertThrows() {
		assertThrows(ArithmeticException.class, () -> {
			int result = 1 / 0;
		}, "ArithmeticException should be thrown");
	}

	@Test
	void testAssertTimeout() {
		assertTimeout(Duration.ofSeconds(2), () -> {
			// Simulate a time-consuming operation
			Thread.sleep(1000);
			System.out.println("Operation completed within time limit");
		}, "Operation should complete within 2 seconds");
	}
}
