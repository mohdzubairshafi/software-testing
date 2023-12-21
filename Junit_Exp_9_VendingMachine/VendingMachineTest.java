import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {

	private VendingMachine vendingMachine;

	@BeforeEach
	void setUp() {
		vendingMachine = new VendingMachine();
	}

	@Test
	void acceptValidCoins() {
		vendingMachine.acceptCoin(1);
		vendingMachine.acceptCoin(5);
		vendingMachine.acceptCoin(10);
		vendingMachine.acceptCoin(20);

		assertEquals(36, vendingMachine.getTotalInsertedCoins());
	}

	@Test
	void rejectInvalidCoin() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			vendingMachine.acceptCoin(2);
		});

		assertEquals("Unsupported coin. The vending machine only accepts 1, 5, 10, and 20 Cents.",
				exception.getMessage());
		assertEquals(0, vendingMachine.getTotalInsertedCoins());
	}

	@Test
	void getAllProducts() {
		assertEquals(3, vendingMachine.getAllProducts().size());
	}

	@Test
	void selectProductWithSufficientFunds() {
		vendingMachine.acceptCoin(20);
		vendingMachine.acceptCoin(5);
		vendingMachine.selectProduct("Coke");
		assertEquals(0, vendingMachine.getTotalInsertedCoins());
		assertEquals(25, vendingMachine.getUsedCoins());
		assertEquals(1, vendingMachine.getSelectedProducts().size());
		List<String> result = vendingMachine.finishRequest();
		assertEquals("Remaining Change: 0", result.get(1));
	}

	@Test
	void selectProductWithInsufficientFunds() {
		vendingMachine.acceptCoin(20);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			vendingMachine.selectProduct("Coke");
		});

		assertEquals("Insufficient funds. Please insert more coins.", exception.getMessage());
		assertEquals(20, vendingMachine.getTotalInsertedCoins());
		assertEquals(0, vendingMachine.getUsedCoins());
		assertTrue(vendingMachine.getSelectedProducts().isEmpty());
	}

	@Test
	void cancelRequest() {
		vendingMachine.acceptCoin(20);
		vendingMachine.acceptCoin(5);
		vendingMachine.selectProduct("Coke");

		int refundAmount = vendingMachine.cancelRequest();

		assertEquals(25, refundAmount);
		assertEquals(0, vendingMachine.getTotalInsertedCoins());
		assertEquals(0, vendingMachine.getUsedCoins());
		assertTrue(vendingMachine.getSelectedProducts().isEmpty());
	}

	@Test
	void finishRequestWithProducts() {
		vendingMachine.acceptCoin(20);
		vendingMachine.acceptCoin(5);

		vendingMachine.selectProduct("Coke");
		List<String> result = vendingMachine.finishRequest();
		assertEquals("Remaining Change: 0", result.get(1));
	}

	@Test
	void finishRequestWithoutProducts() {
		vendingMachine.acceptCoin(20);
		vendingMachine.acceptCoin(5);
		List<String> result = vendingMachine.finishRequest();
		assertEquals("Remaining Change: 25", result.get(0));
	}

	@Test
	void reset() {
		vendingMachine.acceptCoin(20);
		vendingMachine.acceptCoin(5);
		vendingMachine.selectProduct("Coke");
		vendingMachine.reset();

		assertEquals(25, vendingMachine.getTotalInsertedCoins());
		assertEquals(0, vendingMachine.getUsedCoins());
		assertTrue(vendingMachine.getSelectedProducts().isEmpty());
	}
}
