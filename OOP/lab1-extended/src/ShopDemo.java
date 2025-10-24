

import category.Category;
import product.Product;

/**
 * Demo class to showcase encapsulation and validation guards
 * Demonstrates both successful and failed operations
 */
public class ShopDemo {
    public static void main(String[] args) {
        System.out.println("=== Shop Management System Demo - Task 2 ===\n");
        
        // Create category
        Category stationery = new Category("STAT001", "Stationery", "Office supplies and writing materials");
        System.out.println("Created category: " + stationery.getName());
        
        // Create product
        Product pen = new Product("PEN001", "Red Ballpoint Pen", "Smooth writing pen", 2.50, 5, stationery);
        System.out.println("Created product: " + pen.getName());
        System.out.println("Initial stock status: " + pen.getStockStatus());
        System.out.println("Initial quantity: " + pen.getQuantity() + "\n");
        // Empty Product
        Product book = new Product();
        System.out.println("Created product: " + book.getName());
        System.out.println("Initial stock status: " + book.getStockStatus());
        System.out.println("Initial quantity: " + book.getQuantity() + "\n");
        
        // === ACCEPTED OPERATIONS ===
        System.out.println("=== ACCEPTED OPERATIONS ===");
        
        // 1. Valid price update
        System.out.print("Trying to set price to $250.00 USD: ");
        boolean result = pen.trySetPrice(250.0);
        System.out.println(result ? "SUCCESS" : "FAILED");
        System.out.println("Current price: $" + String.format("%.2f", pen.getPrice()) + " USD" + "\n");
        
        // 2. Valid stock addition
        System.out.print("Adding 20 units to stock (current: " + pen.getQuantity() + "): ");
        result = pen.addStock(20);
        System.out.println(result ? "SUCCESS" : "FAILED");
        System.out.println("New quantity: " + pen.getQuantity());
        System.out.println("New stock status: " + pen.getStockStatus() + "\n");
        
        // === REJECTED OPERATIONS ===
        System.out.println("=== REJECTED OPERATIONS ===");
        
        // 1. Invalid price (negative)
        double oldPrice = pen.getPrice();
        System.out.print("Trying to set price to -$1.00 USD: ");
        result = pen.trySetPrice(-1.0);
        System.out.println(result ? "SUCCESS" : "FAILED");
        System.out.println("Price remained: $" + String.format("%.2f", pen.getPrice()) + " USD");
        System.out.println("Price unchanged: " + (pen.getPrice() == oldPrice) + "\n");
        
        // 2. Invalid name (too short)
        String oldName = pen.getName();
        System.out.print("Trying to set name to 'A': ");
        result = pen.trySetName("A");
        System.out.println(result ? "SUCCESS" : "FAILED");
        System.out.println("Name remained: " + pen.getName());
        System.out.println("Name unchanged: " + pen.getName().equals(oldName) + "\n");
        
        // 3. Invalid sale (insufficient stock)
        int oldQuantity = pen.getQuantity();
        System.out.print("Trying to sell 10,000 units (current stock: " + pen.getQuantity() + "): ");
        result = pen.sellProduct(10_000);
        System.out.println(result ? "SUCCESS" : "FAILED");
        System.out.println("Quantity remained: " + pen.getQuantity());
        System.out.println("Quantity unchanged: " + (pen.getQuantity() == oldQuantity) + "\n");
        
        // 4. Invalid discount (over 90%)
        double oldPriceForDiscount = pen.getPrice();
        System.out.print("Trying to apply 200% discount: ");
        result = pen.applyDiscount(200);
        System.out.println(result ? "SUCCESS" : "FAILED");
        System.out.println("Price remained: $" + String.format("%.2f", pen.getPrice()) + " USD");
        System.out.println("Price unchanged: " + (pen.getPrice() == oldPriceForDiscount) + "\n");
        
        // === STOCK STATUS DEMONSTRATION ===
        System.out.println("=== STOCK STATUS DEMONSTRATION ===");
        
        // Sell some items to show different stock statuses
        System.out.println("Current quantity: " + pen.getQuantity() + " (" + pen.getStockStatus() + ")");
        
        pen.sellProduct(20); // Should leave 5
        System.out.println("After selling 20: " + pen.getQuantity() + " (" + pen.getStockStatus() + ")");
        
        pen.sellProduct(4); // Should leave 1
        System.out.println("After selling 4 more: " + pen.getQuantity() + " (" + pen.getStockStatus() + ")");
        
        pen.sellProduct(1); // Should leave 0
        System.out.println("After selling last 1: " + pen.getQuantity() + " (" + pen.getStockStatus() + ")\n");
        
        // === CATEGORY DUPLICATE TEST ===
        System.out.println("=== CATEGORY DUPLICATE PREVENTION ===");
        
        System.out.print("Adding pen to category first time: ");
        result = stationery.addProduct(pen);
        System.out.println(result ? "SUCCESS" : "FAILED");
        
        System.out.print("Adding same pen to category again: ");
        result = stationery.addProduct(pen);
        System.out.println(result ? "SUCCESS" : "FAILED (duplicate rejected)");
        
        System.out.print("Adding null product to category: ");
        result = stationery.addProduct(null);
        System.out.println(result ? "SUCCESS" : "FAILED (null rejected)");
        
        System.out.println("\nProducts in category: " + stationery.getProducts().size() + "\n");
        
        // === FINAL STATE ===
        System.out.println("=== FINAL STATE ===");
        pen.displayProductInfo();
        stationery.displayCategoryInfo();
        
        System.out.println("=== Demo completed successfully! ===");
        System.out.println("All validation guards are working as expected.");
    }
}