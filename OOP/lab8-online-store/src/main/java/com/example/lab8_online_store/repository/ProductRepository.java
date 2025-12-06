package com.example.lab8_online_store.repository;

import com.example.lab8_online_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

// Repository layer in MVC is ONLY for DB interaction
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Find all products by specific name
     *
     * Spring generates: SELECT * FROM products WHERE name = ?
     *
     * @param name Product name
     * @return List of product by that name
     */
    List<Product> findByName(String name);

    // Find all Products containing specific name ignoring case-sensitivity
    List<Product> findByNameContainingIgnoreCase(String name);

    // Find Products by price
    List<Product> findByPrice(BigDecimal price);

    /**
     * Find products by price range
     * SQL: SELECT * FROM products WHERE price BETWEEN ? AND ?
     * 
     * @param minPrice Minimum price
     * @param maxPrice Maximum price
     * @return List of products in price range
     */
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Find Products by brand
    List<Product> findByBrand(String brand);

    List<Product> findByCategory(String category);

    /**
     * Find all books sorted by price (ascending)
     * 
     * Pattern: findAll + OrderBy + Field + Asc/Desc
     * Spring generates: SELECT * FROM books ORDER BY price ASC
    */
    List<Product> findAllByOrderByPriceAsc();

    /**
     * Find products in stock (quantity > 0)
     * SQL: SELECT * FROM products WHERE quantity > 0
     * 
     * @return List of available products
     */
    List<Product> findByQuantityGreaterThan(Integer quantity);



}
