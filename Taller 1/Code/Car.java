/*
 * This module is an example of an abstract class to define a calculator operations.
 * 
 * Copyright (C) 2024  Mariam Betin Escobar <mbetine@udistrital.edu.co>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* This class represents the shopping cart.
 *
 * Possible to add and remove products, displays the contents of the cart and * calculates the total price.
 * calculates the total price of the products in the cart.
 */
class Car {
    Scanner scanner = new Scanner(System.in);
    DataClient client = new DataClient();
    private Categories category;

    private List<String> products = new ArrayList<>();
    private List<Double> prices = new ArrayList<>();


    /* Constructor of a new categories object.
     *
     * This constructor initializes the Car object with a Categories object.
     *
     * Args:
     * category (Categories): The category menu object.
     */
    public Car(Categories category) {
        this.scanner = new Scanner(System.in);
        this.category = category;
    }

    /* 
     * Add a product to the shopping cart.
     *
     * This method adds a product and its price to the respective lists.
     * and prints a confirmation message.
     *
     * Args:
     * product (String): The name of the product to add.
     * Price (Double): The price of the product to add.
     */
    public void addproduct(String product, double price) {
        products.add(product);
        prices.add(price);
        System.out.println(product + " added to car.");
    }

    /*
     * Displays the contents of the shopping cart.
     *
     * This method checks if the cart is empty and calls the method for each case.
     */
    public void viewcar(){
        if (products.isEmpty()) {
            empatycar();
        } else {
            seecar();
        }
    }

    /*
     * Case when the shopping cart is empty.
     *
     * This method shows the options for an empty cart.
     */
    private void empatycar() {
        String car = """
            Your cart is empty.
            1. Return to categories
            2. Exit
            """;

        int choice;
        do {
            System.out.print(car);
            choice = scanner.nextInt();
            if (choice == 1) {
                category.viewmenu();
            } else if (choice == 2) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }
        } while (choice !=2);
    }

    /*
     * Displays the contents of a shopping cart with products.
     *
     * This method lists all the products in the cart with their respective prices and calculates the total purchase.
     * Cell a totalcar().
     * 
     */
    private void seecar() {
        System.out.println("Products in the car:");
        double total = 0;
        for (int x = 0; x < products.size(); x++) {
            System.out.println(products.get(x) + " - $" + prices.get(x));  // Continuous import of each product/price
            total += prices.get(x);
        }
        System.out.println("Total: $" + total);
        totalcar();
    }

    /*
     * Options for a shopping cart.
     *
     * This method shows the options for the cart management. 
     */
    private void totalcar() {
        String n = """
            1. Remove product
            2. Checkout
            3. Return to categories
            4. Exit
            """;

        int choice;
        do {
            System.out.print(n);
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter product index to remove: ");
                int index = scanner.nextInt();
                removeproduct(index);
            } else if (choice == 2) {
                client.client();
            } else if (choice == 3) {
                category.viewmenu();
            } else if (choice == 4) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }
        } while (choice !=2);
    }

    /*
     * Returns the list of products in the cart.
     *
     * Returns:
     *      A List<String> containing the names of the products registered in the cart.
     */
    public List<String> getProducts() {
        return products;
    }

    /*
     * Removal of a product from the cart.
     *
     * This method removes a product and its corresponding price from the cart.
     * based on the index provided in the list.
     *
     * Args:
     * index (int): the index of the product to be removed.
     * 
     */
    public void removeproduct(int index) {
        int x=0;
        System.out.println(products.get(x) + " - $" + prices.get(x));

        if (index >= 0 && index < products.size()) {
            System.out.println(products.get(index) + " removed from cart.");
            products.remove(index);
            prices.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

}

