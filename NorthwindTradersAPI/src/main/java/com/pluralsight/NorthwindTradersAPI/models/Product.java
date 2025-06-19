package com.pluralsight.NorthwindTradersAPI.models;

import java.util.List;

public class Product {

    int productId;
    String productName;
    int categoryId;
    double unitPrice;

    // empty constructor
    public Product() {}

    // constructor with all properties
    public Product(int productId, String productName, int categoryId, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
    }

    // getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public static List<Product> getAll() {
    }

    @Override
    public void run(String... args) throws Exception {

    }

    public void add(Product product) {

    }
}
