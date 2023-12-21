import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class FibonacciTest {

	private final Fibonacci fibonacci = new Fibonacci();

	@Test
	void testFibonacciZero() {
		assertEquals(0, fibonacci.fib(0));
	}

	@Test
	void testFibonacciOne() {
		assertEquals(1, fibonacci.fib(1));
	}

	@Test
	void testFibonacciTwo() {
		assertEquals(1, fibonacci.fib(2));
	}

	@Test
	void testFibonacciThree() {
		assertEquals(2, fibonacci.fib(3));
	}

	@Test
	void testFibonacciTen() {
		assertEquals(55, fibonacci.fib(10));
	}

	@Test
	@org.junit.jupiter.api.Timeout(1000)
	void testFibonacciTimeout() {
		// This test will fail if the fib(42) operation takes more than 1 second to
		// complete
		assertTimeout(Duration.ofMillis(1000), () -> {
			long result = fibonacci.fib(42);
			System.out.println("Result: " + result);
		});
	}

	@Test
	void testFibonacciNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			fibonacci.fib(-1);
		});
	}
}
