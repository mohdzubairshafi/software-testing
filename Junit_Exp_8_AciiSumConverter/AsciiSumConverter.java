public class AsciiSumConverter {

	public static String convertToBinarySum(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Input string cannot be null");
		}

		int sum = 0;

		for (char c : input.toCharArray()) {
			sum += (int) c;
		}

		return Integer.toBinaryString(sum);
	}

	public static void main(String[] arg) {

		String s = "JUnit";
		String ans = convertToBinarySum(s);
		System.out.print(ans);
	}
}
