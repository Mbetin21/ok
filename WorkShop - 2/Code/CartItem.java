/**
 * This class encapsulates a product and its quantity in the cart,
 * providing methods to access and modify this information.
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
* This class represents an item in the shopping cart.
* It stores the product and its corresponding quantity.
* 
* Methods:
*      getproduct: Returns the product associated with the cart item.
*      getquantity: Returns the quantity of the product in the cart.
*      add_quantity: Adds a specified quantity to the current amount of the product.
*/
class Cartitem {
    private Product product;
    private int quantity;

    /**
    * Constructs a new Cartitem with the specified product and quantity.
    * 
    * Args:
    *      product: The product associated with this cart item.
    *      quantity: The initial quantity of the product.
    */
    public Cartitem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns the product associated with this cart item.
     * 
     * Returns:
     *      The Product object stored in the cart item.
     */
    public Product getproduct() {
        return product;
    }

    /**
     * Returns the quantity of the product in this cart item.
     * 
     * Returns:
     *      The quantity of the product.
     */
    public int getquantity() {
        return quantity;
    }

    /**
     * Adds the specified quantity to the current quantity of the product.
     * 
     * Args:
     *      quantity: The quantity to be added.
     */
    public void add_quantity(int quantity) {
        this.quantity += quantity;
    }
}
