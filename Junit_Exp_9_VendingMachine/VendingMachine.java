import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

	private int totalInsertedCoins;
	private int refundAmount;
	private int usedCoins;
	private List<String> selectedProducts;

	public VendingMachine() {
		this.totalInsertedCoins = 0;
		this.refundAmount = 0;
		this.usedCoins = 0;
		this.selectedProducts = new ArrayList<>();
	}

	public void acceptCoin(int coin) {
		// Only accept coins of 1, 5, 10, 20 Cents. Refund for other coins.
		switch (coin) {
		case 1:
		case 5:
		case 10:
		case 20:
			totalInsertedCoins += coin;
			break;
		default:
			throw new IllegalArgumentException(
					"Unsupported coin. The vending machine only accepts 1, 5, 10, and 20 Cents.");
		}
	}

	public List<String> getAllProducts() {
		// Return a list of all available products with their prices
		List<String> products = new ArrayList<>();
		products.add("1. Coke (25 cents)");
		products.add("2. Pepsi (35 cents)");
		products.add("3. Soda (45 cents)");
		return products;
	}

	public void selectProduct(String product) {
		// Select a product and deduct the price from the total inserted coins
		int price = getProductPrice(product);
		if (totalInsertedCoins >= price) {
			selectedProducts.add(product);
			usedCoins += price;
			refundAmount = totalInsertedCoins - price;
			totalInsertedCoins = totalInsertedCoins - price;
		} else {
			throw new IllegalArgumentException("Insufficient funds. Please insert more coins.");
		}
	}

	public int cancelRequest() {
		// Cancel the selected products and refund the full amount
		int refundValue = totalInsertedCoins + usedCoins;
		totalInsertedCoins = 0;
		refundAmount = 0;
		usedCoins = 0;
		selectedProducts.clear();
		return refundValue;
	}

	public List<String> finishRequest() {
		// Return the selected products and any remaining change
		List<String> result = new ArrayList<>(selectedProducts);
		refundAmount = totalInsertedCoins;
		totalInsertedCoins = 0;
		result.add("Remaining Change: " + refundAmount);
		refundAmount = 0;
		usedCoins = 0;
		selectedProducts.clear();
		return result;
	}

	public void reset() {
		// Reset the vending machine, canceling all selected products
		totalInsertedCoins = refundAmount + usedCoins;
		refundAmount = 0;
		usedCoins = 0;
		selectedProducts.clear();
	}

	private int getProductPrice(String product) {
		// Get the price of the selected product
		switch (product) {
		case "Coke":
			return 25;
		case "Pepsi":
			return 35;
		case "Soda":
			return 45;
		default:
			throw new IllegalArgumentException("Unknown product: " + product);
		}
	}

	public int getTotalInsertedCoins() {
		return totalInsertedCoins;
	}

	public int getUsedCoins() {
		return usedCoins;
	}

	public List<String> getSelectedProducts() {
		return selectedProducts;
	}

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nTotal Balance Left: " + vendingMachine.getTotalInsertedCoins() + " cents");
			System.out.println("Used Balance : " + vendingMachine.getUsedCoins() + " cents\n");
			System.out.println("Vending Machine Options:");
			System.out.println("1. Insert Coin");
			System.out.println("2. Show All Products");
			System.out.println("3. Select Product");
			System.out.println("4. Cancel Request");
			System.out.println("5. Reset Machine");
			System.out.println("6. Buy Product");
			System.out.println("7. Exit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			try {
				switch (choice) {
				case 1:
					int coinValue;
					do {
						System.out.print("Enter coin value (-1 to finish): ");
						coinValue = scanner.nextInt();

						if (coinValue != -1) {
							vendingMachine.acceptCoin(coinValue);
							System.out.println("Coins inserted: " + vendingMachine.getTotalInsertedCoins());
						}

					} while (coinValue != -1);
					break;

				case 2:
					System.out.println("Available Products: " + vendingMachine.getAllProducts());
					break;
				case 3:
					String selectedProduct;
					System.out.println("Available Products: " + vendingMachine.getAllProducts());
					do {
						System.out.print("Enter product name (-1 to finish): ");
						selectedProduct = scanner.next();

						if (!selectedProduct.equals("-1")) {
							vendingMachine.selectProduct(selectedProduct);
							System.out.println("Selected Product: " + selectedProduct);
						}

					} while (!selectedProduct.equals("-1"));
					break;
				case 4:
					int refundAmount = vendingMachine.cancelRequest();
					System.out.println("Request canceled. Refund: " + refundAmount + " cents.");
					System.exit(0);
					break;
				case 5:
					vendingMachine.reset();
					System.out.println("Vending machine reset.");
					break;
				case 6:
					System.out.println("Transaction Result: " + vendingMachine.finishRequest());
					System.exit(0);
					break;
				case 7:
					System.out.println("Exiting Vending Machine. Have a nice day!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			} finally {
				scanner.close();
			}
		}
	}
}
