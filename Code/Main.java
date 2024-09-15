package com.example;
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

  /**
    * Main class to initialize the application.
    */
  public class Main {
    public static void main(String[] args) {
        Car car = new Car(null); 
        ProductList productList = new ProductList(null, car); 
        Categories categories = new Categories(productList, car);
  
          
        car = new Car(categories);
        productList = new ProductList(categories, car);
        categories = new Categories(productList, car);
  
        categories.viewmenu();
    }
  }