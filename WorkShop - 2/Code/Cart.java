/**
 * This class manages a list of CartItem objects, allowing for the addition
 * of products, viewing cart contents, calculating totals, and clearing the cart.
 * 
 * Copyright (C) 2024 Mariam Betin Escobar <mbetine@udistrital.edu.co>
 *
 * This program is free software: you can redistribute it and/or modify it
 * modify it under the terms of the GNU General Public License as published by the
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; not even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program.
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a shopping cart for customers.
 * 
 * Methods:
 *      add_product: Adds a product with a specified quantity to the cart.
 *      show_cart: Displays the contents of the cart.
 *      total: Returns the total cost of all items in the cart.
 *      clear_cart: Clears the cart, removing all items.
 */
class Cart {
    private List<Cartitem> items;

    /**
     * Constructs a new Cart instance with an empty list of items.
     */
    public Cart() {
        this.items = new ArrayList<>();
    }

    /**
    * This method adds a product to the cart or updates its quantity if already present.
    * 
    * Args:
    *       product (Product): The product to be added.
    *       quantity (int): The amount of the product to be added.
    */
    public void add_product(Product product, int quantity) {
        boolean found = false;
        for (Cartitem item : items) {
            if (item.getproduct().getname().equalsIgnoreCase(product.getname())) {
                item.add_quantity(quantity);  
                found = true;
                break;
            }
        }
        if (!found) {
            items.add(new Cartitem(product, quantity));  
        }
        System.out.println("Product added to cart: " + product.getname() + " (Quantity: " + quantity + ")");
    }

    /**
     * This method displays the contents of the cart including 
     * product names, quantities, and prices.
     */
    public void show_cart() {
        if (items.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("\nCart contents:");
            for (Cartitem item : items) {
                System.out.println(item.getproduct().getname() + " - Queantity: " + item.getquantity() + 
                " - Price: $" + item.getproduct().getprice());
            }
        }
    }

    /**
     * This method calculates the total price of the products in the cart.
     * 
     * Return:
     *      double: The total price of all items in the cart.
     */
    public double total() {
        double total = 0;
        for (Cartitem item : items) {
            total += item.getproduct().getprice() * item.getquantity();
        }
        return total;
    }

    /**
    * This method clears all products from the cart and prints a 
    * message indicating the cart is empty.
    */
    public void clear_cart() {
        items.clear();
        System.out.println("The cart has been emptied.");
    }
}

