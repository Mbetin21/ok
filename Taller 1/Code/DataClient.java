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

/*
 * This class represents the DataClient for storing user data on purchase.
 *
 * Collects and modifies customer information
 * for order processing and payment method selection.
 * 
 */

public class DataClient {
    Scanner scanner = new Scanner(System.in);

    String modification = """
        1. If I want to modify.
        2. I do not want to modify.
        3. Go out.
        """;
    String name;
    String adress;
    long nphone;
    int option;


    /*
     * Collects customer information for order processing.
     *
     * This method requests the user's name, address and telephone number,
     * allowing the modification of this information, and handles payment. 
     * It continues to run until the user decides to exit.
     * 
     */
    public void client() {
        do {
            System.out.println("Name/Headline: ");
            name = scanner.nextLine();
            System.out.println("Adress: ");
            adress = scanner.nextLine();
            System.out.println("Telephone number: ");
            nphone = scanner.nextLong();
            scanner.nextLine(); 

            System.out.println("Do you want to modify any information?\n");
            System.out.println(modification);
            option = scanner.nextInt();
            scanner.nextLine(); 

            if (option == 1) {
                int selec;
                do {
                    System.out.println("Which date?.\n" + "1. Name. \n" + "2. Adress.\n" + "3. Telephone number.\n");

                    selec = scanner.nextInt();
                    scanner.nextLine();

                    if (selec == 1) {
                        System.out.println("Name/Headline:");
                        name = scanner.nextLine();
                        setname(name);
                    } else if (selec == 2) {
                        System.out.println("Adress:");
                        adress = scanner.nextLine();
                        setadress(adress);
                    } else if (selec == 3) {
                        System.out.println("Telephone number:");
                        nphone = scanner.nextLong();
                        scanner.nextLine();
                        setnphone(nphone);
                    } else {
                        System.out.println("Please choose a valid option.");
                    }
                } while (selec < 1 || selec > 3);
            } else if (option == 2) {
                System.out.println("Payment method: \n" + "1. Against delivery.\n" + "2. Electronic.");
                int selec;
                do {
                    selec = scanner.nextInt();
                    scanner.nextLine();
                    if (selec == 1 || selec == 2) {
                        System.out.println("Successful purchase. We are doing our best to deliver as soon as possible.");
                        System.out.println(name + "\n" + adress + "\n" + nphone);
                    } else {
                        System.out.println("Please choose a valid option.");
                    }
                } while (true);
            } else if (option == 3) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Please choose a valid option.");
            }

        } while (option != 3);
    }

    /*
     * Sets the name of the client.
     *
     * Args:
     *      name (String): The name to be set for the client.
     */
    public void setname(String name) {
        this.name = name;
    }


    /*
     * Sets the address of the client.
     *
     * Args:
     *      adress (String): The address to be set for the client.
     */
    public void setadress(String adress) {
        this.adress = adress;
    }

    /*
     * Sets the phone number of the client.
     *
     * Args:
     *      nphone (long): The phone number to be set for the client.
     */
    public void setnphone(long nphone) {
        this.nphone = nphone;
    }
}
