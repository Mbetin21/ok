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
import java.util.Scanner;


/* This class represents the categories of products in the catalog. */
public class Categories {
    Scanner scanner = new Scanner(System.in);
    private ProductList productlist;
    private Car car;

    /*ProducList and Car object constructor.
     * This constructor initializes the Categories object with a ProductList object and a Car object.
     * 
     * Args:
     * productlist (ProductList): The list of products available from Categories.
     * car (Car): The shopping cart.
     */
    public Categories(ProductList productlist, Car car) {
        this.scanner = new Scanner(System.in);
        this.productlist = productlist;
        this.car = car;
    }


    private static final String menu =""" 
    1. Phone.
    2. Computer.
    3. Television.
    4. Sound.
    5. Console.
    6. Accesory.
    7. See cart.
    8. Go out.\n """;

    /* Displays the menu of available categories.
     * This method presents the menu to the user, processes his choice, and calls 
     * the methods based on the selected option. If it does not validate it displays 
     * the menu until the user chooses one or exits. 
     */
    public void viewmenu() {
        int option;


        do {
            System.out.print("Welcome.\n" + "What category would you like to see?\n" + menu);
            option = scanner.nextInt();
            if (option == 1) {
                productlist.phone();
            } else if (option == 2) {
                productlist.computer();
            } else if (option == 3) {
                productlist.television();
            } else if (option == 4) {
                productlist.sound();
            } else if (option == 5) {
                productlist.console();
            } else if (option == 6) {
                productlist.accesories();
            } else if (option == 7) { 
                car.viewcar();
            } else if (option == 8) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }
        } while (option != 8);

        scanner.close();
    }

}