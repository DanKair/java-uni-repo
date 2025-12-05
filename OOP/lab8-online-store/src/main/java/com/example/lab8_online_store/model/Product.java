package com.example.lab8_online_store.model;

import java.math.BigDecimal;

import jakarta.persistence.*;



@Entity
@Table(name = "products") // tells which table name exactly to look for if db table name doesn't match
public class Product {
    /**
     * Primary Key - Unique identifier for each book
     *
     * @Id - Marks this field as the primary key
     * @GeneratedValue - Auto-generate values (auto-increment)
     * strategy = IDENTITY - Use database's auto-increment feature
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String brand;
    private String category;
    private String description; // should be optional field
    // private String image; // URL of File path to image

    public Product(){

    }

    // Parametrized Constructor
    public Product(Long id, String name, BigDecimal price, Integer quantity, String brand,
                   String category, String description)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.category = category;
        this.description = description;
    }

    // Step 4: Getters and Setters (required for JSON serialization/deserialization)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Step 5: toString method for debugging
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    // Step 6: equals and hashCode (important for collections)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id != null && id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
