/**
 * This class encapsulates all relevant information about a product,
 * including its name, category, price, description, and stock quantity.
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



/**
 * This class represents a product in the store.
 * 
 * Methods:
 *      toString: Returns a string representation of the product's information.
 *      update_inventory: Updates the stock quantity of the product.
 *      a_stock: Checks if the product is in stock.
 *      getname: Returns the name of the product.
 *      getcategory: Returns the category of the product.
 *      getprice: Returns the price of the product.
 */
class Product {
    private String name;
    private String category;
    private double price;
    private String description;
    private int stock;

    /**
     * Constructs a new Product instance with the specified details.
     * 
     * Args:
     *      name (String): The name of the product.
     *      category (String): The category to which the product belongs.
     *      price (double): The price of the product.
     *      description (String): A description of the product.
     *      stock (int): The current stock quantity of the product.
     */
    public Product(String name, String category, double price, String description, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    /**
     * Returns a string representation of the product, including its name, price, category, stock, and description.
     * 
     * Returns:
     *      A formatted string containing the product's details.
     */
    public String toString() {
        return name + " - $" + price + " (" + category + ") - Stock: " + stock + "\nDescription: " + description;
    }

    /**
     * Updates the stock of the product by adding the specified quantity.
     * 
     * Args:
     *      quantity: The quantity to add to the stock (can be negative to reduce stock).
     */
    public void update_invetory(int quantity) {
        this.stock += quantity;
    }

    /**
     * Checks if the product is currently in stock.
     * 
     * Returns:
     *      True: if the stock is greater than zero, false otherwise.
     */
    public boolean a_stock(){
        return stock > 0;
    }

    /**
     * Returns the name of the product.
     * 
     * Returns:
     *      The product's name.
     */
    public String getname() { 
        return name; 
    }

    /**
     * Returns the category of the product.
     * 
     * Returns:
     *      The product's category.
     */
    public String getcategory() { 
        return category; 
    }

    /**
     * Returns the price of the product.
     * 
     * Returns:
     *      The product's price.
     */
    public double getprice() { 
        return price; 
    }
}