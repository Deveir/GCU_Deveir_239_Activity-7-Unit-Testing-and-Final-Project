package store;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArmorTest {

    @Test
    public void testArmorConstructor() {
        Armor armor = new Armor("A1", "Steel Armor", 80.0, 15);

        assertEquals("A1", armor.getId());
        assertEquals("Steel Armor", armor.getName());
        assertEquals(80.0, armor.getPrice(), 0.01);
        assertEquals(15, armor.getDefense());
    }
}