package store;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Manages the store inventory.
 */
public class InventoryManager {

    private ArrayList<SalableProduct> inventory;
    private FileService fileService;

    /**
     * Creates an InventoryManager object.
     */
    public InventoryManager() {
        inventory = new ArrayList<SalableProduct>();
        fileService = new FileService();
    }

    /**
     * Initializes inventory from the JSON file.
     */
    public void initializeInventory() {
        inventory.clear();
        inventory = fileService.loadInventory("inventory.json");
    }

    /**
     * Adds a product to inventory.
     *
     * @param product product to add
     */
    public void addProduct(SalableProduct product) {
        inventory.add(product);
    }

    /**
     * Removes a product from inventory.
     *
     * @param product product to remove
     */
    public void removeProduct(SalableProduct product) {
        inventory.remove(product);
    }

    /**
     * Returns the full inventory list.
     *
     * @return inventory list
     */
    public ArrayList<SalableProduct> getInventory() {
        return inventory;
    }

    /**
     * Finds a product in inventory by ID.
     *
     * @param id product ID
     * @return product if found, otherwise null
     */
    public SalableProduct findProduct(String id) {

        for (SalableProduct product : inventory) {

            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }

        return null;
    }

    /**
     * Sorts inventory by name from A to Z.
     */
    public void sortByNameAscending() {
        Collections.sort(inventory, new NameAscendingComparator());
    }

    /**
     * Sorts inventory by name from Z to A.
     */
    public void sortByNameDescending() {
        Collections.sort(inventory, new NameDescendingComparator());
    }

    /**
     * Sorts inventory by price from low to high.
     */
    public void sortByPriceAscending() {
        Collections.sort(inventory, new PriceAscendingComparator());
    }

    /**
     * Sorts inventory by price from high to low.
     */
    public void sortByPriceDescending() {
        Collections.sort(inventory, new PriceDescendingComparator());
    }
}