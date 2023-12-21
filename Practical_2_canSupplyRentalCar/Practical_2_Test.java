import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Practical_2_Test {

	@Test
	public void testEquivalenceClass() {
		assertTrue(Practical_2.canSupplyRentalCar(25, true, true)); // Valid case
		assertFalse(Practical_2.canSupplyRentalCar(19, true, true)); // Invalid age
		assertFalse(Practical_2.canSupplyRentalCar(25, false, true)); // Invalid driving record
	}

	@Test
	public void testDecisionTableTesting() {
		// 1 Age > 21, Clean record, On business
		assertTrue(Practical_2.canSupplyRentalCar(25, true, true));
		// 2 Age > 21, Clean record, Not on business
		assertTrue(Practical_2.canSupplyRentalCar(25, true, false));
		// 3 Age > 21, Non-clean record, On business
		assertFalse(Practical_2.canSupplyRentalCar(25, false, true));
		// 4 Age > 21, Non-clean record, Not on business
		assertFalse(Practical_2.canSupplyRentalCar(25, false, false));
		// 5 Age < 21, Clean record, On business
		assertFalse(Practical_2.canSupplyRentalCar(19, true, true));
		// 6 Age < 21, Clean record, Not on business
		assertFalse(Practical_2.canSupplyRentalCar(19, true, false));
		// 7 Age < 21, Non-clean record, On business
		assertFalse(Practical_2.canSupplyRentalCar(19, false, true));
		// 8 Age < 21, Non-clean record, Not on business
		assertFalse(Practical_2.canSupplyRentalCar(19, false, false));
	}

	@Test
	public void testBoundaryValueTesting() {
		assertFalse(Practical_2.canSupplyRentalCar(20, true, true)); // Age just below the minimum (age = 20)
		assertTrue(Practical_2.canSupplyRentalCar(21, true, true)); // Minimum age (age = 21)
		assertTrue(Practical_2.canSupplyRentalCar(22, true, true)); // Age just above the minimum
		assertTrue(Practical_2.canSupplyRentalCar(35, true, true)); // Nominal Value
		assertTrue(Practical_2.canSupplyRentalCar(69, true, true)); // Age just below the maximum
		assertTrue(Practical_2.canSupplyRentalCar(70, true, true)); // Maximum age (age = 70)
		assertFalse(Practical_2.canSupplyRentalCar(71, true, true)); // Age just above the maximum
	}

	@Test
	public void testCauseEffectGraph() {
		assertFalse(Practical_2.canSupplyRentalCar(19, true, true)); // Invalid age
		assertFalse(Practical_2.canSupplyRentalCar(25, false, true)); // Invalid driving record
		assertTrue(Practical_2.canSupplyRentalCar(25, true, false)); // Valid case
		assertTrue(Practical_2.canSupplyRentalCar(25, true, true)); // Valid case On Business
	}
}
