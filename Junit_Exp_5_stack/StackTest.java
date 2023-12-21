import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

class StackTest {

	@Test
	void testPush() {
		Stack stack = new Stack();
		stack.push(10);
		assertEquals(1, stack.getSize());
	}

	@Test
	void testPop() {
		Stack stack = new Stack();
		stack.push(10);
		int result = stack.pop();
		assertEquals(10, result);
		assertEquals(0, stack.getSize());
	}

	@Test
	void testPopEmptyStack() {
		Stack stack = new Stack();
		assertThrows(EmptyStackException.class, () -> stack.pop());
	}

	@Test
	void testPushFullStack() {
		Stack stack = new Stack();
		// Push more elements than the stack capacity
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		assertThrows(StackOverflowError.class, () -> stack.push(11));
	}

	@Nested
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	@Suite
	@SelectClasses(StackTest.class)
	class StackTestSuite {

		private int ans = 0;

		@Test
		@org.junit.jupiter.api.Timeout(1000)
		void testTimeout() {
			Stack stack = new Stack();
			stack.push(42);
			// This test will fail if it takes more than 1 second to complete
			assertTimeout(java.time.Duration.ofMillis(1000), () -> {
				// Save the result of the pop method
				ans = popMethodWithDelay(stack);
				// Introduce a sleep to simulate a longer operation
				Thread.sleep(1500);
			});
			assertEquals(42, ans);
		}

		private int popMethodWithDelay(Stack stack) {
			// Simulate the pop method taking some time
			try {
				Thread.sleep(500); // Simulating a delay of 500 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return stack.pop();
		}

	}

	@Test
	@org.junit.jupiter.api.Disabled("Ignoring this test for now")
	void testIgnoreAnnotation() {
		// This test is ignored and won't be executed
		fail("This test should be ignored");
	}
}
