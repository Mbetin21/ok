/**
 * This class extends the User class, inheriting basic user functionality
 * and adding administrator-specific features.
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
 * Represents an Administrator user in the system. Extends User class.
 * 
 * Methods:
 *      show_menu: Displays the menu options specific to an Administrator.
 */
class Admi extends User {
    /**
     * Constructs a new Administrator.
     * 
     * This constructor initializes an Administrator with a name and password,
     * calling the superclass constructor to set these values.
     *
     * Args:
     *      name (String): The name of the administrator.
     *      password (String): The password for the administrator's account.
     */
    public Admi(String name, String password) {
        super(name, password);
    }

    /**
     * Displays the administrator menu options.
     * 
     * This method overrides the show_menu method from the User class,
     * presenting administrator-specific options such as adding products,
     * removing products, updating stock, and viewing all products.
     */
    @Override
    public void show_menu() {
        System.out.println("\n--- Administrator menu  ---");
        System.out.println("1. Add product");
        System.out.println("2. Remove porduct");
        System.out.println("3. Update stock");
        System.out.println("4. View all products");
        System.out.println("5. Exit");
    }
    
}

