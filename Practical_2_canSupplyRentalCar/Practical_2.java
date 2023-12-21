
public class Practical_2 {

	public static boolean canSupplyRentalCar(int age, boolean cleanDrivingRecord, boolean onBusiness) {
		if (age >= 21 && age <= 70 && cleanDrivingRecord) {
			if (onBusiness) {
				// Premium amount is charged for business trips
				return true;
			} else {
				// No premium amount charged for non-business trips
				return true;
			}
		} else {
			// Car cannot be supplied for individuals under 21, over 70, or with a non-clean
			// driving record
			return false;
		}
	}

	public static void main(String[] args) {
		// Test cases to manually check the functionality
		System.out.println(canSupplyRentalCar(25, true, true)); // Valid case
		System.out.println(canSupplyRentalCar(19, true, true)); // Invalid age
		System.out.println(canSupplyRentalCar(25, false, true)); // Invalid driving record
		System.out.println(canSupplyRentalCar(21, true, true)); // Lower bound (age = 21)
		System.out.println(canSupplyRentalCar(20, true, true)); // Age < 21
		System.out.println(canSupplyRentalCar(70, true, true)); // Upper bound (age = 70)
	}

}
