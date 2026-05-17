package store;

import static org.junit.Assert.*;
import org.junit.Test;

public class SalableProductTest {

    @Test
    public void testSalableProductConstructor() {
        SalableProduct product = new SalableProduct("P1", "Test Product", 25.0);

        assertEquals("P1", product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals(25.0, product.getPrice(), 0.01);
    }

    @Test
    public void testToString() {
        SalableProduct product = new SalableProduct("P1", "Test Product", 25.0);

        assertTrue(product.toString().contains("Test Product"));
    }
}