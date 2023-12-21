class ScientificCalculator {

	public double add(double a, double b) {
		return a + b;
	}

	public double subtract(double a, double b) {
		return a - b;
	}

	public double multiply(double a, double b) {
		return a * b;
	}

	public double divide(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		return a / b;
	}

	public double squareRoot(double number) {
		if (number < 0) {
			throw new IllegalArgumentException("Cannot calculate square root of a negative number");
		}
		return Math.sqrt(number);
	}

	public double power(double base, double exponent) {
		return Math.pow(base, exponent);
	}

	public double sin(double angleInDegrees) {
		return Math.sin(Math.toRadians(angleInDegrees));
	}

	public double cos(double angleInDegrees) {
		return Math.cos(Math.toRadians(angleInDegrees));
	}

	public double tan(double angleInDegrees) {
		return Math.tan(Math.toRadians(angleInDegrees));
	}

	public static void main(String[] args) {
		ScientificCalculator calculator = new ScientificCalculator();
		// Example usage
		System.out.println("Addition: " + calculator.add(5, 3));
		System.out.println("Subtraction: " + calculator.subtract(8, 4));
		System.out.println("Multiplication: " + calculator.multiply(2, 6));
		System.out.println("Division: " + calculator.divide(9, 3));
		System.out.println("Square Root: " + calculator.squareRoot(25));
		System.out.println("Power: " + calculator.power(2, 3));
		System.out.println("Sin(90): " + calculator.sin(90));
		System.out.println("Cos(180): " + calculator.cos(180));
		System.out.println("Tan(60): " + calculator.tan(60));
	}
}
