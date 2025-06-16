package com.pluralsight.NorthwindTradersSpringBoot;


import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {

    //create an instance of our ProductDao
    @Autowired
    @Qualifier("jdbcProductDao")
    private ProductDao productDao;

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // This is a "loop" that will keep showing the menu until the user chooses to exit.
        while (true) {
            // Print the menu options to the screen.
            System.out.println("\n=== Products Menu ===");
            System.out.println("1. List Products");
            System.out.println("2. Add Products");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's choice as a String.
            String choice = scanner.nextLine();

            // Use a "switch" to handle each possible choice.
            switch (choice) {

                case "1":
                    // The user chose option 1 → List all products.

                    // Call the DAO to get a list of all products.
                    List<Product> products = productDao.getAll();

                    // Print the products to the screen.
                    System.out.println("\n");
                    System.out.println("♡ ∩_∩ \n" +
                            "(„•֊•„)♡\n" +
                            "|￣UU￣￣￣￣￣￣￣￣￣|");
                    System.out.println("      Products: ");
                    System.out.println(" ﹉﹉﹉﹉﹉୨♡୧﹉﹉﹉﹉﹉");
                    for (Product product : products) {
                        System.out.println(product);
                    }

                    break;

                case "2":
                    // The user chose option 2 → Add a new product

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter product category: ");
                    int productCategory = scanner.nextInt();

                    System.out.print("Enter the product price: ");
                    double productPrice = Double.parseDouble(scanner.nextLine());

                    // Create a new product object and set its data.
                    Product newProduct = new Product();

                    // Create a new Product object and set its data.
                    newProduct.setName(name);
                    newProduct.setCategory(productCategory);
                    newProduct.setPrice(productPrice);

                    // Add the new film to the DAO (which stores it in memory).
                    productDao.add(newProduct);

                    // Let the user know that the product was added.
                    System.out.println("Product added successfully.");

                    break;

                case "3":
                    // The user chose option 3 → Exit the program.

                    // Print a goodbye message.
                    System.out.println("Goodbye!");

                    // End the program with a success status (0).
                    System.exit(0);

                default:
                    // The user entered something that is not a valid option.

                    // Tell the user the input was invalid and show the menu again.
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }
}
