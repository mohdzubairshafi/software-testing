public class Minimum {

	public static int findMinimum(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			throw new IllegalArgumentException("Input array cannot be null or empty");
		}

		int min = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}

		return min;
	}
}
