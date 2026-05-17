package store;

import static org.junit.Assert.*;
import org.junit.Test;

public class HealthPotionTest {

    @Test
    public void testHealthPotionConstructor() {
        HealthPotion potion = new HealthPotion("H1", "Small Potion", 10.0, 20);

        assertEquals("H1", potion.getId());
        assertEquals("Small Potion", potion.getName());
        assertEquals(10.0, potion.getPrice(), 0.01);
        assertEquals(20, potion.getHealing());
    }
}