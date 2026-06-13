import java.util.*;

public class ranking {
    public static void main(String[] args) {

        Map<String, Double> products = new HashMap<>();

        products.put("Laptop", 50000.0);
        products.put("Mouse", 500.0);
        products.put("Keyboard", 1500.0);
        products.put("Monitor", 18000.0);
        products.put("Printer", 8000.0);

        double totalPrice = 0;
        String expensiveProduct = "";
        double maxPrice = 0;

        for (Map.Entry<String, Double> entry : products.entrySet()) {
            totalPrice += entry.getValue();

            if (entry.getValue() > maxPrice) {
                maxPrice = entry.getValue();
                expensiveProduct = entry.getKey();
            }
        }

        System.out.println("Products and Prices:");
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " : Rs." + entry.getValue());
        }

        System.out.println("\nTotal Price = Rs." + totalPrice);
        System.out.println("Most Expensive Product = " + expensiveProduct);
        System.out.println("Price = Rs." + maxPrice);
    }
}
