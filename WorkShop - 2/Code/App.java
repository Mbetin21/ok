/**
 * This module contains a class manages the main application logic, including user authentication,
 * product management, and navigating through the application menus.
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


import java.util.*;
/**
 * This class manages products, users, and handles the main application logic.
 * 
 * Methods:
 *      know_user: Initializes the system with predefined users.
 *      run: Runs the main application loop, handling user authentication, 
 *             menu display, and directing the flow based on user type (Client or Admin).
 *      initialize: Prompts for user credentials and authenticates the user.
 *      menu_client: Handles the menu options for the client.
 *      menu_admi: Handles the menu options for the administrator.
 *      show_categories: Displays the available product categories.
 *      show_product_category: Displays products from a specific category.
 *      add_cart: Adds products to the client's cart.
 *      checkout: Finalizes the purchase and clears the cart.
 *      add_product: Adds a product to the system (admin only).
 *      delete_product: Removes a product from the system (admin only).
 *      update_stock: Updates the stock of a product (admin only).
 *      show_all_products: Displays all products in the system.
 */
class App {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private User current_user;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new App instance and initializes the system.
     */
    public App() {
        initialize();
    }

    /**
     * Initializes the system with predefined users.
     * This method adds a client and an administrator to the system.
     */
    private void know_user() {
        users.add(new Client("Juan", "123"));
        users.add(new Admi("Carlos", "456"));
    }

    /**
     * Initializes a user session.
     * 
     * Prompts for user credentials and authenticates the user.
     * 
     * Return:
     *      True: if authentication is successful, false otherwise.
     */
    private boolean initialize() {
        System.out.print("Name user: ");
        String name = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.name.equals(name) && user.authenticate(password)) {
                current_user = user;
                System.out.println("Session started.");
                return true;
            }
        }

        System.out.println("Incorrect username or password.");
        return false;
    }

    /**
     * Runs the main application loop.
     * 
     * This method handles user authentication, menu display, and
     * directs the flow based on user type (Client or Admin).
     */
    public void run() {
        while (true) {
            if (current_user == null) {
                if (!initialize()) {
                    continue;
                }
            }

            current_user.show_menu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (current_user instanceof Client) {
                menu_client(opcion);
            } else if (current_user instanceof Admi) {
                menu_admi(opcion);
            }

            if (opcion == 6 && current_user instanceof Client || 
                opcion == 5 && current_user instanceof Admi) {
                System.out.println("Closed session.");
                current_user = null;
            }
        }
    }

    /**
     * Handles the client menu options.
     * 
     * Args:
     *      option (int): The selected menu option.
     */
    private void menu_client(int option) {
        Client client = (Client) current_user;
        if (option == 1){
            show_categories();
        }else if (option == 2){
            show_product_category();
        }else if (option == 3){
            add_cart(client);
        }else if (option == 4){
            client.getcart().show_cart();
        }else if (option == 5){
            checkout(client);
        }else if (option == 6){
        } else {
            System.out.println("Invalid option.");
        }
    }

    /**
     * Displays the available product categories.
     * Iterates through the products and displays their categories.
     */
    private void show_categories() {
        System.out.println("\nCategorías disponibles:");
        Set<String> categories = new HashSet<>();
        for (Product producto : products) {
            categories.add(producto.getcategory());
        }
        for (String category : categories) {
            System.out.println("- " + category);
        }
    }

    /**
     * Displays products from a specific category.
     * Filters products by category and shows them.
     */
    private void show_product_category() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.println("\nProducts in category  " + category + ":");
        for (Product product : products) {
            if (product.getcategory().equalsIgnoreCase(category) && product.a_stock()) {
                System.out.println(product);
            }
        }
    }

    /**
     * Adds products to the client's cart.
     * Prompts for product name and quantity, and adds the product if available.
     * 
     * Args:
     *      client (Client): The current client using the system.
     */
    private void add_cart(Client client) {
        show_all_products();
        System.out.print("Enter the product name: ");
        String name_product = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        Product product_choose = null;
        for (Product product : products) {
            if (product.getname().equalsIgnoreCase(name_product) && product.a_stock()) {
                product_choose = product;
                break;
            }
        }

        if (product_choose != null) {
            client.getcart().add_product(product_choose, quantity);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found or out of stock.");
        }
    }

    /**
     * Finalizes the purchase process for the client.
     * Displays the cart contents and confirms the purchase.
     * 
     * Args:
     *      client (Client): The current client using the system.
     */
    private void checkout(Client client) {
        client.getcart().show_cart();
        System.out.print("Confirm purchase? (y/n): ");
        String check = scanner.nextLine();
        if (check.equalsIgnoreCase("y")) {
            System.out.println("Purchase made. Total: $" + client.getcart().total());
            client.getcart();
        } else {
            System.out.println("Purchase canceled.");
        }
    }

    /**
     * Handles the administrator menu options.
     * Allows the admin to add, delete, and update product inventory.
     * 
     * Args:
     *      option (int): The selected menu option.
     */
    private void menu_admi(int option) {
        if (option == 1){
            add_product();
        }else if (option == 2){
            delete_product();
        }else if (option == 3){
            update_stock();
        }else if (option == 4){
            show_all_products();
        }else if (option == 5){
        }else {
            System.out.println("Invalid option.");
        }
    }

    /**
     * Adds a new product to the system.
     * Prompts for product details and adds the product to the inventory.
     */
    private void add_product() {
        System.out.print("Name product: ");
        String name = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consumir nueva línea
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        products.add(new Product(name, category, price, description, stock));
        System.out.println("Product added successfully.");
    }

    /**
     * Deletes a product from the system.
     * Prompts for product name and removes it from the inventory.
     */
    private void delete_product() {
        show_all_products();
        System.out.print("Enter the name of the product to delete: ");
        String name_product = scanner.nextLine();

        for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) { //Iterator: (collection of a fareworks) recollect the list element by element
            Product producto = iterator.next();
            if (producto.getname().equalsIgnoreCase(name_product)) {
                iterator.remove();
                System.out.println("Delete product.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    /**
     * Updates the stock of a product.
     * Prompts for product name and updates the stock accordingly.
     */
    private void update_stock() {
        show_all_products();
        System.out.print("Enter the product name: ");
        String name_product = scanner.nextLine();
        System.out.print("Enter the quantity to add to stock (use negative to subtract: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        for (Product producto : products) {
            if (producto.getname().equalsIgnoreCase(name_product)) {
                producto.update_invetory(quantity);
                System.out.println("Stock updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    /**
     * Displays all products available in the system.
     * 
     * If there are no products, a message is displayed 
     * indicating that the store is empty.
     */
    private void show_all_products() {
        if (products.isEmpty()) {
            System.out.println("There are no products in the store.");
            return;
        }
        System.out.println("\nAll products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}