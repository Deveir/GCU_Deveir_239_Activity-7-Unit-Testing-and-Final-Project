package store;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeaponTest {

	@Test
public void testWeaponConstructor() {
        Weapon weapon = new Weapon("W1", "Iron Sword", 50.0, 10);

        assertEquals("W1", weapon.getId());
        assertEquals("Iron Sword", weapon.getName());
        assertEquals(50.0, weapon.getPrice(), 0.01);
        assertEquals(10, weapon.getDamage());
    }

    @Test
    public void testWeaponCompareTo() {
        Weapon weapon1 = new Weapon("W1", "Axe", 40.0, 8);
        Weapon weapon2 = new Weapon("W2", "Bow", 60.0, 12);

        assertTrue(weapon1.compareTo(weapon2) < 0);
    }
}