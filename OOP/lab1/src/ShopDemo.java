
import category.Category;
import product.Product;

/**
 * Demo class for Task 1 - Basic OOP functionality showcase
 * Shows product and category management without strict validation
 */
public class ShopDemo {
    public static void main(String[] args) {
        System.out.println("=== Shop Management System Demo - Task 1 ===\n");
        
        // Create categories (like Python: category = Category(...))
        Category electronics = new Category("ELEC001", "Electronics", "Electronic devices and gadgets");
        Category stationery = new Category("STAT001", "Stationery", "Office supplies and writing materials");
        
        System.out.println("Created categories:");
        System.out.println(electronics.getName());
        System.out.println(stationery.getName() + "\n");
        
        // Create products using parameterized constructor
        Product laptop = new Product("LAP001", "Gaming Laptop", "High-performance gaming laptop", 
                                   1299.99, 5, electronics);
        Product pen = new Product("PEN001", "Blue Ballpoint Pen", "Smooth writing pen", 
                                2.50, 50, stationery);
        Product notebook = new Product("NOTE001", "Spiral Notebook", "200-page lined notebook", 
                                     5.99, 25, stationery);
        
        System.out.println("Created products:");
        System.out.println("- " + laptop.getName() + " ($" + laptop.getPrice() + ")");
        System.out.println("- " + pen.getName() + " ($" + pen.getPrice() + ")");
        System.out.println("- " + notebook.getName() + " ($" + notebook.getPrice() + ")\n");
        
        // Add products to categories
        electronics.addProduct(laptop);
        stationery.addProduct(pen);
        stationery.addProduct(notebook);
        
        System.out.println("=== INVENTORY MANAGEMENT DEMO ===\n");
        
        // Show initial laptop info
        laptop.displayProductInfo();
        
        // Test addStock method
        System.out.println("--- Adding Stock ---");
        laptop.addStock(3);
        laptop.addStock(-1); // Should show error message
        System.out.println();
        
        // Test sellProduct method
        System.out.println("--- Selling Products ---");
        laptop.sellProduct(2);
        laptop.sellProduct(10); // Should show insufficient stock message
        laptop.sellProduct(-1); // Should show error message
        System.out.println();
        
        // Show stock status changes
        System.out.println("--- Stock Status Changes ---");
        pen.displayProductInfo();
        
        pen.sellProduct(45); // Should change from IN_STOCK to LOW (5 remaining)
        System.out.println("After selling 45 pens:");
        System.out.println("Stock Status: " + pen.getStockStatus() + ", Quantity: " + pen.getQuantity());
        
        pen.sellProduct(5); // Should change to OUT_OF_STOCK
        System.out.println("After selling remaining 5 pens:");
        System.out.println("Stock Status: " + pen.getStockStatus() + ", Quantity: " + pen.getQuantity());
        System.out.println();
        
        // Test applyDiscount method
        System.out.println("--- Discount Application ---");
        System.out.println("Notebook original price: $" + String.format("%.2f", notebook.getPrice()));
        notebook.applyDiscount(20); // 20% discount
        notebook.applyDiscount(150); // Should show error message
        notebook.applyDiscount(-10); // Should show error message
        System.out.println();
        
        // Test calculateTotalValue
        System.out.println("--- Total Value Calculation ---");
        System.out.println("Laptop total value (price × quantity): $" + 
                          String.format("%.2f", laptop.calculateTotalValue()));
        System.out.println("Notebook total value: $" + 
                          String.format("%.2f", notebook.calculateTotalValue()));
        System.out.println();
        
        // Category information display
        System.out.println("=== CATEGORY INFORMATION ===\n");
        electronics.displayCategoryInfo();
        stationery.displayCategoryInfo();
        
        // Test direct field access (Task 1 allows this)
        System.out.println("=== DIRECT FIELD ACCESS (Task 1 Feature) ===");
        System.out.println("Before direct access - Laptop name: " + laptop.name);
        laptop.name = "Super Gaming Laptop"; // Direct field modification
        laptop.price = 1199.99; // Direct price change
        System.out.println("After direct access - Laptop name: " + laptop.name);
        System.out.println("After direct access - Laptop price: $" + laptop.price);
        System.out.println();
        
        // Create product using default constructor
        System.out.println("=== DEFAULT CONSTRUCTOR DEMO ===");
        Product emptyProduct = new Product();
        System.out.println("Product created with default constructor:");
        emptyProduct.displayProductInfo();
        
        // Set values using setters
        emptyProduct.setId("MOUSE001");
        emptyProduct.setName("Wireless Mouse");
        emptyProduct.setDescription("Ergonomic wireless mouse");
        emptyProduct.setPrice(29.99);
        emptyProduct.setQuantity(15);
        emptyProduct.setCategory(electronics);
        
        System.out.println("After setting values:");
        emptyProduct.displayProductInfo();
        
        System.out.println("=== FINAL SUMMARY ===");
        System.out.println("Electronics category total value: $" + 
                          String.format("%.2f", electronics.getTotalValue()));
        System.out.println("Stationery category total value: $" + 
                          String.format("%.2f", stationery.getTotalValue()));
        
        System.out.println("\n=== Task 1 Demo completed successfully! ===");
    }
}