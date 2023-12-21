import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

class TriangleTest {

	private Triangle triangle;

	@BeforeEach
	void setUp() {
		triangle = new Triangle();
	}

	@Test
	void testEquilateralTriangle() {
		assertEquals("Equilateral", triangle.classify(3, 3, 3));
	}

	@Test
	void testIsoscelesTriangle() {
		assertEquals("Isosceles", triangle.classify(3, 3, 4));
	}

	@Test
	void testScaleneTriangle() {
		assertEquals("Scalene", triangle.classify(3, 4, 5));
	}

	@Test
	void testNotATriangle() {
		assertEquals("Not a triangle", triangle.classify(1, 2, 3));
	}

	@Test
	void testSideOutOfRange() {
		assertThrows(IllegalArgumentException.class, () -> {
			triangle.classify(0, 50, 70);
		});
	}

	@Test
	void testTimeout() {
		assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
			// Simulate a time-consuming operation that takes 1 seconds to complete
			Thread.sleep(1000);
			assertEquals("Scalene", triangle.classify(3, 4, 5));
		});
	}

	@Test
	@Disabled("Ignoring this test for now")
	void testIgnoreAnnotation() {
		assertEquals("Ignored", triangle.classify(0, 0, 0));
	}

	@Nested
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	@Suite
	@SelectClasses(TriangleTest.class)
	class TestSuite {
		@Test
		void testTimeout() {
			assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
				// Simulate a time-consuming operation that takes 3 seconds to complete
				Thread.sleep(3000);
				assertEquals("Scalene", triangle.classify(3, 4, 5));
			});
		}
	}
}
