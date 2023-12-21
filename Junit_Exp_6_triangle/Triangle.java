class Triangle {

	String classify(int x, int y, int z) {
		if (isOutOfRange(x) || isOutOfRange(y) || isOutOfRange(z)) {
			throw new IllegalArgumentException("Side lengths must be in the range [1, 100]");
		}

		if (!isValidTriangle(x, y, z)) {
			return "Not a triangle";
		}

		if (x == y && y == z) {
			return "Equilateral";
		} else if (x == y || y == z || x == z) {
			return "Isosceles";
		} else {
			return "Scalene";
		}
	}

	private boolean isOutOfRange(int sideLength) {
		return sideLength < 1 || sideLength > 100;
	}

	private boolean isValidTriangle(int x, int y, int z) {
		return (x + y > z) && (y + z > x) && (x + z > y);
	}
}
