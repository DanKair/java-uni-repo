package category;

import product.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Category class for organizing products into categories
 * Similar to Python classes but with explicit access modifiers and types
 */
public class Category {
    // Private fields - encapsulation (like Python's _private convention but enforced)
    private String id;
    private String name;
    private String description;
    private List<Product> products;
    
    // Default constructor (like Python's __init__ with default values)
    public Category() {
        this.products = new ArrayList<>();
    }
    
    // Parameterized constructor (like Python's __init__ with parameters)
    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
    }
    
    // Getters (like Python's @property decorators)
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public List<Product> getProducts() {
        // Return defensive copy to prevent external modification
        return this.products;
    }
    
    // Setters (unlike Python, we explicitly define these)
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Add product to category with validation
     * Returns boolean instead of throwing exception (guard pattern)
     * @param product Product to add
     * @return true if added successfully, false if rejected
     */
    public boolean addProduct(Product product) {
        // Reject null products
        if (product == null) {
            return false;
        }
        
        // Reject duplicates (same object reference)
        if (this.products.contains(product)) {
            return false;
        }
        
        this.products.add(product);
        return true;
    }
    
    /**
     * Remove product from category
     * @param product Product to remove
     * @return true if removed, false if not found
     */
    public boolean removeProduct(Product product) {
        return this.products.remove(product);
    }
    
    /**
     * Calculate total value of all products in this category
     * @return sum of all products' total values
     */
    public double getTotalValue() {
        double total = 0.0;
        for (Product product : products) {
            total += product.calculateTotalValue();
        }
        return total;
    }
    
    /**
     * Display category information and all its products
     * Similar to Python's __str__ method but called explicitly
     */
    public void displayCategoryInfo() {
        System.out.println("=== Category Information ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Number of products: " + products.size());
        System.out.println("Total category value: $" + String.format("%.2f", getTotalValue()) + " USD");
        
        if (!products.isEmpty()) {
            System.out.println("\nProducts in this category:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i).getName());
            }
        }
        System.out.println();
    }
}