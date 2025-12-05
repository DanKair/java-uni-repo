package com.example.lab8_online_store.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.lab8_online_store.model.Product;
import com.example.lab8_online_store.service.ProductService;

import java.util.List;

/**
 * ProductController - REST API for Product management with PostgreSQL
 * 
 * Base URL: http://localhost:8080/api/products
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    // Constructor Injectino (sets newly created productService as default in constructor)
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /api/products - Get all products
    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    // GET /api/products/{id} - Get product by ID
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // POST /api/products - Create new product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // PUT /api/products/{id} - Update produc
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id); // prevents users from changing id
        return productService.updateProduct(id, product);
    }

    // DELETE /api/products/{id} - Delete product
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
    /* 
    @Autowired
    private ProductRepository productRepository;
    
    // GET /api/products - Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }
    
    // GET /api/products/search?name={query} - Search by name
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(products);
    }
    
    // GET /api/products/category/{category} - Get by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String category) {
        List<Product> products = productRepository.findByCategory(category);
        return ResponseEntity.ok(products);
    }
    
    // GET /api/products/brand/{brand} - Get by brand
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getByBrand(@PathVariable String brand) {
        List<Product> products = productRepository.findByBrand(brand);
        return ResponseEntity.ok(products);
    }
    
    // GET /api/products/price-range?min={min}&max={max} - Get by price range
    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getByPriceRange(@RequestParam Long min, @RequestParam Long max) {
        List<Product> products = productRepository.findByPriceBetween(min, max);
        return ResponseEntity.ok(products);
    }
    
    // GET /api/products/in-stock - Get available products
    @GetMapping("/in-stock")
    public ResponseEntity<List<Product>> getInStockProducts() {
        List<Product> products = productRepository.findByQuantityGreaterThan(0);
        return ResponseEntity.ok(products);
    }
    */
}
