package product;
import category.Category;

/**
 * Product class for Task 1 - Basic OOP implementation
 * Public fields and basic methods (before strict encapsulation)
 */
public class Product {
    // Public fields (Task 1 style - direct access allowed)
    public String id;
    public String name;
    public String description;
    public double price;
    public int quantity;
    public Category category;
    public String[] stockStatuses = {"Out of Stock", "Low", "High"};
    public String stockStatus;
    
    // Default constructor (like Python's __init__ with no args)
    public Product() {
        this.quantity = 0;
        this.price = 0.0;
        this.stockStatus = stockStatuses[0];
    }
    
    // Parameterized constructor (like Python's __init__ with args)
    public Product(String id, String name, String description, double price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
         // Calculate initial stock status
    }
    
    // Basic getters (similar to Python @property decorators)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Category getCategory() { return category; }
    public String getStockStatus() { return stockStatus; }
    
    // Basic setters (no validation in Task 1)
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    
    public void setPrice(double price) { 
        this.price = price; 
    }
    
    public void setQuantity(int quantity) { 
        this.quantity = quantity;
    }
    
    public void setCategory(Category category) { this.category = category; }
    
    
    
    /**
     * Add stock to inventory
     * @param amount amount to add
     */
    public void addStock(int amount) {
        // Basic validation (minimal for Task 1)
        if (amount > 0) {
            quantity += amount;
            
            System.out.println("Added " + amount + " units. New quantity: " + quantity);
        } else {
            System.out.println("Cannot add negative or zero stock.");
        }
    }
    
    /**
     * Sell products from inventory
     * @param amount amount to sell
     */
    public void sellProduct(int amount) {
        if (amount <= 0) {
            System.out.println("Cannot sell negative or zero quantity.");
        }
        
        if (amount > quantity) {
            System.out.println("Insufficient stock. Available: " + quantity + ", Requested: " + amount);
        }
        
        quantity -= amount;
        
        System.out.println("Sold " + amount + " units. Remaining quantity: " + quantity);
    }
    
    /**
     * Apply percentage discount to product price
     * @param percent discount percentage (0-100)
     */
    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid discount percentage: " + percent + "%. Must be between 0 and 100.");
            return;
        }
        
        double oldPrice = price;
        double discountAmount = price * (percent / 100.0);
        price = price - discountAmount;
        
        System.out.println("Applied " + percent + "% discount.");
        System.out.println("Price changed from $" + oldPrice + 
                          " to $" + price);
    }
    
    /**
     * Calculate total value of inventory (price * quantity)
     * @return total value
     */
    public double calculateTotalValue() {
        return price * quantity;
    }
    
    /**
     * Display detailed product information
     * Similar to Python's __str__ or __repr__ methods
     */
    public void displayProductInfo() {
        System.out.println("=== Product Information ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + (description != null ? description : "No description"));
        System.out.println("Price: $" + String.format("%.2f", price));
        System.out.println("Quantity: " + quantity);
        System.out.println("Stock Status: " + stockStatus);
        System.out.println("Total Value: $" + String.format("%.2f", calculateTotalValue()));
        System.out.println("Category: " + (category != null ? category.getName() : "No category"));
        System.out.println();
    }
}