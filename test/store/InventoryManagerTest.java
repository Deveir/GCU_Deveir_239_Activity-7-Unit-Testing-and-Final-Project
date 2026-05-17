package store;

import static org.junit.Assert.*;
import org.junit.Test;

public class InventoryManagerTest {

    @Test
    public void testInitializeInventory() {
        InventoryManager manager = new InventoryManager();
        manager.initializeInventory();

        assertFalse(manager.getInventory().isEmpty());
    }

    @Test
    public void testFindProduct() {
        InventoryManager manager = new InventoryManager();
        manager.initializeInventory();

        SalableProduct product = manager.findProduct("W1");

        assertNotNull(product);
        assertEquals("W1", product.getId());
    }

    @Test
    public void testAddAndRemoveProduct() {
        InventoryManager manager = new InventoryManager();
        SalableProduct product = new Weapon("W99", "Test Sword", 99.0, 20);

        manager.addProduct(product);
        assertNotNull(manager.findProduct("W99"));

        manager.removeProduct(product);
        assertNull(manager.findProduct("W99"));
    }

    @Test
    public void testSortByPriceAscending() {
        InventoryManager manager = new InventoryManager();
        manager.initializeInventory();

        manager.sortByPriceAscending();

        double firstPrice = manager.getInventory().get(0).getPrice();
        double secondPrice = manager.getInventory().get(1).getPrice();

        assertTrue(firstPrice <= secondPrice);
    }
}