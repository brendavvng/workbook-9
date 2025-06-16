package com.pluralsight.NorthwindTradersSpringBoot.models;

public class Product {

    // properties
    private int productId;
    private String name;
    private int category;
    private double price;

    //default constructor with no parameters
    public Product() {}

    // constructor with parameters
    public Product(int productId, String name, int category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // This is a special method called toString().
    // It tells Java what to print when we print a Film object.
    // This is very helpful for debugging or showing the film in the console.
    @Override
    public String toString() {
        return "Product ˗ ꒰" +
                "ProductID = " + productId +
                ", ProductName = '" + name + '\'' +
                ", CategoryID = " + category + '\'' +
                ", UnitPrice = $" + String.format("%.2f", price) +
                "꒱";
    }

}
