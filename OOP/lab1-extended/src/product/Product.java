package product;

import category.Category;

/**
 * Product class with encapsulation and validation guards
 * All fields are private with guarded mutators that return boolean
 * This is stricter than Python's convention-based privacy
 */
public class Product {
    // Private fields - true encapsulation (enforced by compiler)
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Category category;
    
    // Default constructor
    public Product() {
        this.id = "DEFAULT";
        this.name = "Unnamed Product";
        this.description = "";
        this.quantity = 0;
        this.price = 0.0;
    }

    
    // Parameterized constructor
    public Product(String id, String name, String description, double price, int quantity, Category category){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    
    // Getters only - no direct setters (read-only access)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Category getCategory() { return category; }
    
    /**
     * Computed property for stock status (no setter allowed)
     * Like Python's @property but computed each time
     * @return stock status string
     */
    public String getStockStatus() {
        if (quantity == 0) {
            return "OUT_OF_STOCK";
        } else if (quantity <= 10) {
            return "LOW";
        } else {
            return "IN_STOCK";
        }
    }
    
    // Guarded mutators - return boolean instead of throwing exceptions
    
    /**
     * Try to set ID with validation
     * @param id new ID value
     * @return true if set successfully, false if invalid
     */
    public boolean trySetId(String id) {
        if (id == null) return false;
        
        String trimmed = id.trim();
        if (trimmed.length() < 2) return false;
        
        this.id = trimmed;
        return true;
    }
    
    /**
     * Try to set name with validation
     * @param name new name value
     * @return true if set successfully, false if invalid
     */
    public boolean trySetName(String name) {
        if (name == null) return false;
        
        String trimmed = name.trim();
        if (trimmed.length() < 2) return false;
        
        this.name = trimmed;
        return true;
    }
    
    /**
     * Try to set description with validation
     * @param description new description value (can be null)
     * @return true if set successfully, false if invalid
     */
    public boolean trySetDescription(String description) {
        if (description == null) {
            this.description = null;
            return true;
        }
        
        String trimmed = description.trim();
        if (trimmed.length() > 200) return false;
        
        this.description = trimmed;
        return true;
    }
    
    /**
     * Try to set price with validation
     * @param price new price value
     * @return true if set successfully, false if invalid
     */
    public boolean trySetPrice(double price) {
        if (price < 0.0 || price > 1_000_000.0) return false;
        
        this.price = price;
        return true;
    }
    
    /**
     * Try to set quantity with validation
     * @param quantity new quantity value
     * @return true if set successfully, false if invalid
     */
    public boolean trySetQuantity(int quantity) {
        if (quantity < 0 || quantity > 1_000_000) return false;
        
        this.quantity = quantity;
        return true;
    }
    
    /**
     * Try to set category with validation
     * @param category new category value
     * @return true if set successfully, false if invalid
     */
    public boolean trySetCategory(Category category) {
        if (category == null) return false;
        
        this.category = category;
        return true;
    }
    
    // Inventory management methods with guards
    
    /**
     * Add stock with validation
     * @param amount amount to add (must be positive)
     * @return true if stock added, false if invalid amount
     */
    public boolean addStock(int amount) {
        if (amount <= 0) return false;
        if (quantity + amount > 1_000_000) return false; // Prevent overflow
        
        quantity += amount;
        return true;
    }
    
    /**
     * Sell product with validation
     * @param amount amount to sell
     * @return true if sold, false if insufficient stock or invalid amount
     */
    public boolean sellProduct(int amount) {
        if (amount <= 0) return false;
        if (amount > quantity) return false;
        
        quantity -= amount;
        return true;
    }
    
    /**
     * Apply discount with validation
     * @param percent discount percentage (must be 0-90)
     * @return true if discount applied, false if invalid percentage
     */
    public boolean applyDiscount(double percent) {
        if (percent < 0.0 || percent > 90.0) return false;
        
        double discountAmount = price * (percent / 100.0);
        price = price - discountAmount;
        return true;
    }
    
    /**
     * Calculate total value of inventory for this product
     * @return price * quantity
     */
    public double calculateTotalValue() {
        return price * quantity;
    }
    
    /**
     * Display detailed product information
     * Similar to Python's __str__ but called explicitly
     */
    public void displayProductInfo() {
        System.out.println("=== Product Information ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + (description != null ? description : "No description"));
        System.out.println("Price: $" + String.format("%.2f", price) + " USD");
        System.out.println("Quantity: " + quantity);
        System.out.println("Stock Status: " + getStockStatus());
        System.out.println("Total Value: $" + String.format("%.2f", calculateTotalValue()));
        System.out.println("Category: " + (category != null ? category.getName() : "No category"));
        System.out.println();
    }
}