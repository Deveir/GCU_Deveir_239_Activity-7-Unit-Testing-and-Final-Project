package store;

import static org.junit.Assert.*;
import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void testAddToCart() {
        ShoppingCart cart = new ShoppingCart();
        SalableProduct product = new Weapon("W1", "Iron Sword", 50.0, 10);

        cart.addToCart(product);

        assertEquals(1, cart.getCart().size());
    }

    @Test
    public void testRemoveFromCart() {
        ShoppingCart cart = new ShoppingCart();
        SalableProduct product = new Weapon("W1", "Iron Sword", 50.0, 10);

        cart.addToCart(product);
        cart.removeFromCart(product);

        assertTrue(cart.getCart().isEmpty());
    }

    @Test
    public void testEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        cart.addToCart(new Weapon("W1", "Iron Sword", 50.0, 10));
        cart.addToCart(new Armor("A1", "Steel Armor", 80.0, 15));

        cart.emptyCart();

        assertTrue(cart.getCart().isEmpty());
    }
}