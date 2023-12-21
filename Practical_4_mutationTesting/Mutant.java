
public class Mutant extends Calculator {
	@Override
	public int add(int a, int b) {
		// Mutate the behavior by subtracting instead of adding
		return a - b;
	}

}
