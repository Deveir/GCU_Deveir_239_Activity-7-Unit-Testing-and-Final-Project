package store;

import static org.junit.Assert.*;
import org.junit.Test;

public class StoreFrontTest {

    @Test
    public void testStartStore() {
        StoreFront store = new StoreFront();
        store.startStore();

        assertFalse(store.getInventoryManager().getInventory().isEmpty());
        assertTrue(store.getShoppingCart().getCart().isEmpty());
    }

    @Test
    public void testBuyProduct() {
        StoreFront store = new StoreFront();
        store.startStore();

        store.buyProduct("W1");

        assertNull(store.getInventoryManager().findProduct("W1"));
        assertNotNull(store.getShoppingCart().findProduct("W1"));
    }

    @Test
    public void testCancelProduct() {
        StoreFront store = new StoreFront();
        store.startStore();

        store.buyProduct("W1");
        store.cancelProduct("W1");

        assertNotNull(store.getInventoryManager().findProduct("W1"));
        assertNull(store.getShoppingCart().findProduct("W1"));
    }
}