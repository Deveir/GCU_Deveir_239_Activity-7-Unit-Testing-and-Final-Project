package store;

import java.util.ArrayList;

/**
 * Represents the user's shopping cart.
 */
public class ShoppingCart {

    private ArrayList<SalableProduct> cart;

    /**
     * Creates a ShoppingCart object.
     */
    public ShoppingCart() {
        cart = new ArrayList<SalableProduct>();
    }

    /**
     * Starts the shopping cart as empty.
     */
    public void initializeCart() {
        cart.clear();
    }

    /**
     * Adds a product to the shopping cart.
     *
     * @param product product to add
     */
    public void addToCart(SalableProduct product) {
        cart.add(product);
    }

    /**
     * Removes a product from the shopping cart.
     *
     * @param product product to remove
     */
    public void removeFromCart(SalableProduct product) {
        cart.remove(product);
    }

    /**
     * Returns the shopping cart contents.
     *
     * @return cart list
     */
    public ArrayList<SalableProduct> getCart() {
        return cart;
    }

    /**
     * Empties the shopping cart.
     */
    public void emptyCart() {
        cart.clear();
    }

    /**
     * Finds a product in the cart by ID.
     *
     * @param id product ID
     * @return product if found, otherwise null
     */
    public SalableProduct findProduct(String id) {

        for (SalableProduct product : cart) {

            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }

        return null;
    }
}