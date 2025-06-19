package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    // creating property
    @Autowired
    @Qualifier("jdbcProductDao")
    private ProductDao productDao;

    // constructor
    public ProductsController(ProductDao productDao) {
        this.productDao = productDao;
    }

    // http://localhost:8080/products - should return a list of all product
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productDao.getAll();
    }

    // http://localhost:8080/products/5 - should return a specific product
    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDao.getById(id);
    }

    // adding postmapping
    @PostMapping("/api/products")
    public Product addProduct(@RequestBody Product product) {
        return productDao.insert(product);
    }

    @PutMapping("/api/products/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        productDao.update(id, product);
    }

    // delete mapping
    @DeleteMapping("/api/products/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProductId(@PathVariable int id) {
        productDao.delete(id);
    }
}
