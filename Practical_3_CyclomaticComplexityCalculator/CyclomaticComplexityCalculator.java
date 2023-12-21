import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CyclomaticComplexityCalculator {

	public static void main(String[] args) {
		System.out.println("Calculating Cyclomatic Complexity...");

		String fileName = "Example.java";
		int ans = calculate(fileName);
		System.out.println("Cyclomatic complexity: " + ans);

	}

	public static int calculate(String fileName) {
		try {
			// Get the path to the current directory
			String currentDirectory = System.getProperty("user.dir");
			String filePath = currentDirectory + "/src/" + fileName;

			// Read the file
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			int complexity = calculateCyclomaticComplexity(reader);

			// Print the result
			return complexity;

		} catch (IOException e) {
			System.out.println("Error reading the file: " + e.getMessage());
		}
		return -1;
	}

	private static int calculateCyclomaticComplexity(BufferedReader reader) throws IOException {
		int complexity = 1; // Starting complexity is 1

		String line;
		while ((line = reader.readLine()) != null) {
			// Increment the complexity for each occurrence of the following keywords:
			// if, while, for, case, ? (ternary operator)
			complexity += countOccurrences(line, "if") + countOccurrences(line, "while") + countOccurrences(line, "for")
					+ countOccurrences(line, "case") + countOccurrences(line, "?");
		}

		return complexity;
	}

	private static int countOccurrences(String line, String keyword) {
		int count = 0;
		int index = line.indexOf(keyword);
		while (index != -1) {
			count++;
			index = line.indexOf(keyword, index + keyword.length());
		}
		return count;
	}
}
