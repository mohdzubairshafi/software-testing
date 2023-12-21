public class Fibonacci {

	public int fib(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Input must be non-negative");
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
