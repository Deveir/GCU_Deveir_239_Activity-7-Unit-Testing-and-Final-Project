package store;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class FileServiceTest {

    @Test
    public void testLoadInventoryFromJson() {
        FileService fileService = new FileService();

        ArrayList<SalableProduct> products = fileService.loadInventory("inventory.json");

        assertFalse(products.isEmpty());
    }

    @Test
    public void testMissingJsonFile() {
        FileService fileService = new FileService();

        ArrayList<SalableProduct> products = fileService.loadInventory("missingfile.json");

        assertTrue(products.isEmpty());
    }
}