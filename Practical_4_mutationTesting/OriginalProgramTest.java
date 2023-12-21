import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OriginalProgramTest {

	@Test
	void testAdd() {
		OriginalProgram originalProgram = new OriginalProgram();
		int result = originalProgram.add(2, 3);
		assertEquals(5, result, "Original program should add numbers correctly");
	}
}
