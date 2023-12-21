import java.util.Scanner;

public class SliceBasedTesting {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Value of N: ");
		int n = scanner.nextInt();

		System.out.println("Enter the slicing criterion (Sum or Product): ");
		String criterion = scanner.next();
		scanner.close();

		// Slicing based on the criterion
		calculate(n, criterion);
	}

	public static int calculate(int n, String criterion) {
		// Slicing based on the criterion
		int ans = 0;
		if (criterion.equals("Sum")) {
			ans = calculateSum(n);
		} else if (criterion.equals("Product")) {
			ans = calculateProduct(n);
		} else {
			System.out.println("Invalid slicing criterion.");
		}
		return ans;
	}

	public static int calculateSum(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("Sum: " + sum);
		return sum;
	}

	public static int calculateProduct(int n) {
		int product = 1;
		for (int i = 1; i <= n; i++) {
			product *= i;
		}
		System.out.println("Product: " + product);
		return product;
	}
}
