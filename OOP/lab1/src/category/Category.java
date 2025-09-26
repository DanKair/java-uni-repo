package category;
import java.util.ArrayList;

import product.Product;

/**
 * Category class for Task 1 - Basic OOP implementation
 * This version has public fields and standard setters (no validation guards yet)
 */
public class Category {
    // Public fields (Task 1 style - before strict encapsulation)
    public String id;
    public String name;
    public String description;
    private ArrayList<Product> products; // Keep this private for collection safety
    
    // Default constructor
    public Category() {
        this.products = new ArrayList<>();
    }
    
    // Parameterized constructor
    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
    }
    
    // Basic getters (similar to Python @property)
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public ArrayList<Product> getProducts() {
        // Return copy to prevent external modification
        return new ArrayList<>(products);
    }
    
    // Basic setters (no validation in Task 1)
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
     * Add product to category (Task 1 version - simple)
     * @param product Product to add
     */
    public void addProduct(Product product) {
        if (product != null && !products.contains(product)) {
            products.add(product);
        }
    }
    
    /**
     * Remove product from category
     * @param product Product to remove
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }
    
    /**
     * Calculate total value of all products in category
     * @return sum of all products' total values
     */
    public double getTotalValue() {
        double total = 0.0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }
    
    /**
     * Display category information and all its products
     */
    public void displayCategoryInfo() {
        System.out.println("=== Category Information ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Number of products: " + products.size());
        System.out.println("Total category value: $" + String.format("%.2f", getTotalValue()));
        
        if (!products.isEmpty()) {
            System.out.println("\nProducts in this category:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i).getName() + 
                    " - $" + String.format("%.2f", products.get(i).getPrice()) +
                    " (Qty: " + products.get(i).getQuantity() + ")");
            }
        }
        System.out.println();
    }

    public static void main(){
        Category electronics = new Category("ELEC001", "Electronics", "Electronic devices and gadgets");
        Category stationery = new Category("STAT001", "Stationery", "Office supplies and writing materials");
        
        System.out.println("Created categories:");
        System.out.println("- " + electronics.getName());
        System.out.println("- " + stationery.getName() + "\n");
    }
}

