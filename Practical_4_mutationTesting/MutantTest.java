import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MutantTest {

	@Test
	void testAdd() {
		Mutant mutant = new Mutant();
		int result = mutant.add(2, 3);
		// The mutant subtracts instead of adding, so the result should not be 5
		assertEquals(5, result, "Mutant should have a different behavior");
	}
}
