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


/*This class represents the list of available products by category.
 *
 * Displays the products menu and handles the user interactions to 
 * navigate through the different subcategories, giving the option 
 * to add products to the cart and return to the categories. 
 */
class ProductList {
    Scanner scanner = new Scanner(System.in);
    private Categories category;
    private Car car;

    /*
     * Constructor of a car object and categories.
     *
     * This constructor initializes the ProductList object with a Categories object and a Car object.
     *
     * Args:
     * category (Categories): The categories menu object.
     * car (Cart): The shopping cart.
     */
    public ProductList(Categories category, Car car) {
        this.scanner = new Scanner(System.in);
        this.category = category;
        this.car = car;
    }


    /*
     * Displays the phone's category menu and manages user entries.
     *
     * This method presents the phone subcategories to the user, processes their choice,
     * and calls the appropriate methods based on the selected option.
     * Continues to display the menu until the user decides to exit.
     */
    public void phone() {
        String list = """
        Lis to phones:
        1.  /--------/ Cell phone - $ 29.20     /       Android 13
            |        |                                  Sceen: 5.7"
            |        |                                  Ram: 12 G
            /--------/                                  Camera: 108 MP   
        2.  /--------/ Tablets / iPads - $ 32.55     /      iOS 17
            |        |                                      Sceen: 6.9"
            |        |                                      Ram: 8 GB
            /--------/                                      Camera: 78 MP
        3.  /--------/ Accesories - $ 12.30     /       Main feature: Multiple conexion 
            |        |                                  Color: Black/Blue
            |        |
            /--------/
        4. See cart.
        5. Return to categories.
        6. Go out.
        """;

        int choice;
        do {
            System.out.print(list);
            choice = scanner.nextInt();

            if (choice == 1) {
                car.addproduct("Cell phone", 29.20);
            } else if (choice == 2) {
                car.addproduct("Tablets", 32.55);
            } else if (choice == 3) {
                car.addproduct("Accesories", 12.30);
            } else if (choice == 4) { 
                car.viewcar();
            } else if (choice == 5) { 
                category.viewmenu();
            } else if (choice == 6) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }
        } while (choice != 6);
    }

    /*
     * Displays the computer category menu and manages user entries.
     *
     * This method presents the computer subcategories to the user, processes their choice,
     * and calls the appropriate methods based on the selected option.
     * Continues to display the menu until the user decides to exit.
     */
    public void computer(){
        String list = """
        List to computer:
        1.  /--------/ Desktop computer - $ 45.00     /   Processor: AMD Ryzen 9 5950X
            |        |                                    Ram: 64 GB
            |        |                                    Storage: 2 TB SSD + 4 TB HDD
            /--------/                                    Grafics: NVIDIA RTX 3090    
        2.  /--------/ Laptops - $ 42.55     /     Processor: i7-12700H
            |        |                             Ram: 32GB
            |        |                             Storage. 1 TB SSD
            /--------/                             Grafics: NVDIA RTX 3090
        3.  /--------/ Accesories - $ 10.70     /       Main feautre: Backlight
            |        |                                  Colors: Pink/Green     
            |        |
            /--------/
        4. See cart.
        5. Return to categories.
        6. Go out.
        """;

        int choice;
        do {
            System.out.print(list);
            choice = scanner.nextInt();

            if (choice == 1) {
                car.addproduct("Desktop computer", 45.00);
            } else if (choice == 2) {
                car.addproduct("Laptops", 42.55);
            } else if (choice == 3) {
                car.addproduct("Accesories", 10.70);
            } else if (choice == 4) { 
                car.viewcar();
            } else if (choice == 5) {
                category.viewmenu();
            } else if (choice == 6) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }
        } while (choice != 6);
    }

    /*
     * Displays the television category menu and manages user entries.
     *
     * This method presents the television subcategories to the user, processes their choice,
     * and calls the appropriate methods based on the selected option.
     * Continues to display the menu until the user decides to exit.
     */
    public void television(){
        String list = """
        list to television:
        1.  /--------/ Television - $ 34.20     /       Sceen: 75"
            |        |                                  Resolution: 8K
            |        |                                  Ports: 3HDMI
            /--------/
        2.  /--------/ Monitors - $ 32.55     /         Sceen: 4"
            |        |                                  Rsolution: FHD
            |        |                                  Response speed: 5 ms
            /--------/
        3.  /--------/ Projectors - $ 20.80     /       Brightness: 4500 Lumens
            |        |                                  Resolution: SVGA
            |        |
            /--------/
        4.  /--------/ Accesories - $ 15.35     /       Reception channels: 17 Channels
            |        |                                  Location: Outside/Inside
            |        |
            /--------/
        5. See cart.
        6. Return to categories.
        7. Go out.
        """;

        int choice;
        do {
            System.out.print(list);
            choice = scanner.nextInt();

            if (choice == 1) {
                car.addproduct("Television", 34.20);
            } else if (choice == 2) {
                car.addproduct("Monitors", 32.55);
            } else if (choice == 3) {
                car.addproduct("Projectors", 20.80);
            } else if (choice == 4) {
                car.addproduct("Accesories", 15.35);
            } else if (choice == 5) { 
                car.viewcar();
            } else if (choice == 6) {
                category.viewmenu();
            } else if (choice == 7) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }
        } while (choice != 7);
    }

    /*
     * Displays the sound category menu and manages user entries.
     *
     * This method presents the sound subcategories to the user, processes their choice,
     * and calls the appropriate methods based on the selected option.
     * Continues to display the menu until the user decides to exit.
     */
    public void sound(){
        String list = """
        List to sound:
        1.  /--------/ Heardphones - $ 18.90     /      Connection: Wireless
            |        |                                  Features: Noise cancellation 
            |        |
            /--------/
        2.  /--------/ Speakers - $ 30.70     /     Portable
            |        |                              Connection: Wireless
            |        |
            /--------/
        3.  /--------/ Accesories - $ 20.15     /       Connection: Wireless
            |        |                                  Professional
            |        |
            /--------/
        4. See cart.
        5. Return to categories.
        6. Go out.
        """;

        int choice;
        do {
            System.out.print(list);
            choice = scanner.nextInt();

            if (choice == 1) {
                car.addproduct("Heardphones", 18.90);
            } else if (choice == 2) {
                car.addproduct("Speakers", 30.70);
            } else if (choice == 3) {
                car.addproduct("Accesories", 20.15);
            } else if (choice == 4) {
                car.viewcar();
            } else if (choice == 5) {
                category.viewmenu();
            } else if (choice == 6) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }
        } while (choice != 6);    
    }

    /*
     * Displays the console category menu and manages user entries.
     *
     * This method presents the console subcategories to the user, processes their choice,
     * and calls the appropriate methods based on the selected option.
     * Continues to display the menu until the user decides to exit.
     */
    public void console(){
        String list = """
        List to consoles:
        1.  /--------/ Consoles - $ 70.55       /       Resolution: 4K Ultra HD
            |        |                                  Connection: Wireless
            |        |                                  Controls: 1
            /--------/
        2.  /--------/ Controls - $ 30.55       /       Connection: Wireless
            |        |                                  Range: 3 m
            |        |
            /--------/
        3.  /--------/ Accesories - $ 17.30       /     Dessing: Case with lid
            |        |                                  Dimensions: 26 cm
            |        |
            /--------/
        4. See cart.
        5. Return to categories.
        6. Go out.
        """;

        int choice;
        do {
            System.out.print(list);
            choice = scanner.nextInt();

            if (choice == 1) {
                car.addproduct("Consoles", 70.55);
            } else if (choice == 2) {
                car.addproduct("Controls", 30.55);
            } else if (choice == 3) {
                car.addproduct("Accesories", 17.30);
            } else if (choice == 4) {
                car.viewcar();
            } else if (choice == 5) {
                category.viewmenu();
            } else if (choice == 6) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }
        } while (choice != 6);    
    }

    /* Displays the accesories category menu and manages user entries.
     *
     * This method presents the accesories subcategories to the user, processes their choice,
     * and calls the appropriate methods based on the selected option.
     * Continues to display the menu until the user decides to exit. */
    public void accesories(){
        String list = """
        List to accesories:
        1.  /--------/ Cell phone - $ 12.30     /       Main feature: Multiple conexion 
            |        |                                  Color: Black/Blue
            |        |
            /--------/ 
        2.  /--------/ TV - $ 15.35     /       Reception channels: 17 Channels
            |        |                          Location: Outside/Inside
            |        |
            /--------/ 
        3.  /--------/ Computer - $ 10.70     /       Main feautre: Backlight
            |        |                                Colors: Pink/Green
            |        |
            /--------/ 
        4.  /--------/ Sound - $ 20.15     /        Connection: Wireless
            |        |                              Professional
            |        |
            /--------/ 
        5.  /--------/ Console - $ 17.30     /      Dessing: Case with lid
            |        |                            Dimensions: 26 cm
            |        |
            /--------/ 
        6. See cart.
        7. Return to categories.
        8. Go out.
        """;

        int choice;
        do {
            System.out.print(list);
            choice = scanner.nextInt();

            if (choice == 1) {
                car.addproduct("Accesories", 12.30);
            } else if (choice == 2) {
                car.addproduct("Accesories", 15.35);
            } else if (choice == 3) {
                car.addproduct("Accesories", 10.70);
            } else if (choice == 4) {
                car.addproduct("Accesories", 20.15);
            } else if (choice == 5) {
                car.addproduct("Accesories", 17.30);
            } else if (choice == 6) {
                car.viewcar();
            } else if (choice == 7) {
                category.viewmenu();
            } else if (choice == 8) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }
        } while (choice != 8);    
    }
}