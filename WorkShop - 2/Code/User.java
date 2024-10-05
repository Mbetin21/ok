/**
 * This abstract class represents a user in the system, providing
 * basic functionalities such as authentication.
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
 * This abstract class represents a user in the system.
 * 
 * Methods:
 *      authenticate: Verifies if the provided password matches the user's password.
 *      show_menu: Abstract method to display the menu based on the user 
 *                 type (must be implemented by subclasses).
 */
abstract class User {
    protected String name;
    protected String password;

    /**
     * Constructs a new User with the specified name and password.
     * 
     * Args:
     *      name (String): The name of the user.
     *      password (String): The password for authentication.
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * Authenticates the user by checking if the provided 
     * password matches the user's stored password.
     * 
     * Args:
     *      password (String): The password to be verified.
     * 
     * Returns:
     *      True if the password matches, false otherwise.
     */
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    /**
     * Abstract method that must be implemented by subclasses to display a specific menu.
     */
    public abstract void show_menu();
}
