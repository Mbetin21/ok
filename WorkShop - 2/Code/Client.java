/**
 * This class extends the User class, adding client-specific functionality
 * such as managing a shopping cart.
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
 * Represents a Client user in the system. Extends user class.
 * 
 * Methods:
 *      show_menu: Displays the menu options specific to a Client.
 *      getcart: Returns the Cart object associated with the Client.
 */
class Client extends User {
    private Cart cart;

    /**
     * Constructs a new Client.
     * 
     * Initializes a Client with a name and password, calling the superclass constructor
     * to set these values. Also creates a new Cart object for the client.
     *
     * Args:
     *      name (String): The name of the client.
     *      password (String): The password for the client's account.
     */
    public Client(String name, String password) {
        super(name, password);
        this.cart = new Cart();
    }

    /**
     * Displays the client menu options.
     * 
     * This method overrides the show_menu method from the User class,
     * presenting client-specific options such as viewing categories,
     * adding products to cart, and checking out.
     */
    @Override
    public void show_menu() {
        System.out.println("\n--- Customer Menu ---");
        System.out.println("1. View categories");
        System.out.println("2. View products by category");
        System.out.println("3. Add product to cart");
        System.out.println("4. View cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
    }

    /**
     * Retrieves the client's shopping cart.
     * 
     * Return:
     *      The Cart object associated with this client.
     */
    public Cart getcart() {
        return cart;
    }
}