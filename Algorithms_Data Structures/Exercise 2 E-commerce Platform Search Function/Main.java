import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Setup initial unsorted product array
        Product[] products = {
            new Product("P101", "Wireless Mouse", "Electronics"),
            new Product("P102", "Gaming Keyboard", "Electronics"),
            new Product("P103", "Leather Wallet", "Accessories"),
            new Product("P104", "Running Shoes", "Footwear"),
            new Product("P105", "Coffee Mug", "Kitchenware")
        };

        String searchTarget = "Running Shoes";

        System.out.println("=== 1. Testing Linear Search ===");
        Product resultLinear = SearchAlgorithm.linearSearch(products, searchTarget);
        System.out.println("Result: " + (resultLinear != null ? resultLinear : "Product Not Found"));

        System.out.println("\n=== 2. Preparing Setup for Binary Search ===");
     
        Arrays.sort(products);
        System.out.println("Products successfully sorted by name.");

        System.out.println("\n=== 3. Testing Binary Search ===");
        Product resultBinary = SearchAlgorithm.binarySearch(products, searchTarget);
        System.out.println("Result: " + (resultBinary != null ? resultBinary : "Product Not Found"));
    }
}