public class Practical_1 {

	public static class Pair {
		public int min;
		public int max;

		public Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	public static Pair findMinAndMax(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			throw new IllegalArgumentException("List is empty or null");
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int num : numbers) {
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}

		return new Pair(min, max);
	}

	public static void main(String[] args) {

		int[] arr = { 1 };
		try {
			Pair ans = findMinAndMax(arr);
			System.out.println("Min: " + ans.min);
			System.out.println("Max: " + ans.max);

		} catch (Exception e) {
			System.out.println("Error: " + e.getLocalizedMessage());
		}
	}

}
